package io.swagger.api.factories;

import io.swagger.api.ExternalApiService;
import io.swagger.api.impl.ExternalApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-05-22T14:24:41.728+02:00")
public class ExternalApiServiceFactory {

   private final static ExternalApiService service = new ExternalApiServiceImpl();

   public static ExternalApiService getExternalApi()
   {
      return service;
   }
}
