package com.dummyframework.core.handler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dummyframework.annotations.PathVariable;
import com.dummyframework.annotations.QueryParameter;
import com.dummyframework.annotations.RequestBody;
import com.dummyframework.annotations.ResponseBody;

public class HandlerDetail {

  private Method handler;

  private String uri;

  private Map<String, Class<?>> pathVariables = new HashMap<>();

  private Map<String, Class<?>> queryParameters = new HashMap<>();

  private List<String> parameterNames = new ArrayList<>();

  private Class<?> payload = null;

  private boolean sendResponse = false;

  public HandlerDetail(Method handler, String uri) {
    this.handler = handler;
    this.uri = uri;
    resolveHandlerParameters();
    setSendResponse();
  }

  public Method getHandler() {
    return handler;
  }

  public String getUri() {
    return uri;
  }

  public boolean canSendResponseToBody() {
    return this.sendResponse;
  }

  private void resolveHandlerParameters() {
    Parameter[] parameters = handler.getParameters();
    for (Parameter parameter : parameters) {
      String paramName = parameter.getName();
      if (parameter.isAnnotationPresent(PathVariable.class)) {
        PathVariable pathVariable = parameter.getAnnotation(PathVariable.class);
        pathVariables.put(pathVariable.name(), parameter.getType());
        paramName = pathVariable.name();
      } else if (parameter.isAnnotationPresent(QueryParameter.class)) {
        QueryParameter queryParameter = parameter.getAnnotation(QueryParameter.class);
        queryParameters.put(queryParameter.name(), parameter.getType());
        paramName = queryParameter.name();
      } else if (parameter.isAnnotationPresent(RequestBody.class)) {
        if (payload == null)
          payload = parameter.getType();
      }
      parameterNames.add(paramName);
    }
  }

  private void setSendResponse() {
    sendResponse =
        (handler.getReturnType() != Void.class && (handler.isAnnotationPresent(ResponseBody.class)
            || parentClass().isAnnotationPresent(ResponseBody.class)));
  }

  public Map<String, Class<?>> getPathVariables() {
    return pathVariables;
  }

  public Map<String, Class<?>> getQueryParameters() {
    return queryParameters;
  }

  public Class<?> getPayload() {
    return payload;
  }

  public Class<?> parentClass() {
    return handler.getDeclaringClass();
  }

  public List<String> getParameterNames() {
    return parameterNames;
  }
}
