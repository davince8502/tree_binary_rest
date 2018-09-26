TREE BINARY API TEST
================
servicios web REST base para un Arbol Binario basado en SPRING.


**Requerimientos** : Java 8.0, 
		     Eclipse STS con Gradle.


###  Clonar / Descargar

Clonar el repositorio usando Git:

```bash
git clone https://github.com/davince8502/tree_binary_rest.git
```

De otra forma, puede [decargar](https://github.com/davince8502/tree_binary_rest/archive/master.zip)
el repositorio en .zip.

###  Importar Proyecto

Importar el proyecto Gradle en eclipse, se puede seguir la [guia](http://www.vogella.com/tutorials/EclipseGradle/article.html).

###  Desplegar Servidor

Compilar el proyecto y desplegar el WAR en Tomcat >= v8.0  ó Wildfly >= 9.0.

Debera ver el siguiente resultado:

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.9.RELEASE)

2018-09-25 22:37:23.073  INFO 11144 --- [ost-startStop-1] com.tree.ServletInitializer              : Starting ServletInitializer on mlhernandez with PID 11144 (D:\workSpaces\tree-binary\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\tree_binary_api_rest\WEB-INF\classes started by Usuario in D:\Instaladores\sts-bundle\sts-3.9.6.RELEASE)
2018-09-25 22:37:23.075  INFO 11144 --- [ost-startStop-1] com.tree.ServletInitializer              : No active profile set, falling back to default profiles: default
2018-09-25 22:37:23.191  INFO 11144 --- [ost-startStop-1] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@63fb91b1: startup date [Tue Sep 25 22:37:23 COT 2018]; root of context hierarchy
2018-09-25 22:37:23.475  INFO 11144 --- [ost-startStop-1] o.s.c.a.ConfigurationClassParser         : Properties location [classpath:properties/aplicacion.properties] not resolvable: class path resource [properties/aplicacion.properties] cannot be opened because it does not exist
2018-09-25 22:37:26.266  INFO 11144 --- [ost-startStop-1] o.a.c.c.C.[.[.[/tree_binary_api]         : Initializing Spring embedded WebApplicationContext
2018-09-25 22:37:26.266  INFO 11144 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3075 ms
2018-09-25 22:37:27.829  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'simpleCorsFilter' to: [/*]
2018-09-25 22:37:27.829  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'errorPageFilter' to: [/*]
2018-09-25 22:37:27.830  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2018-09-25 22:37:27.830  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2018-09-25 22:37:27.830  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2018-09-25 22:37:27.830  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2018-09-25 22:37:27.833  INFO 11144 --- [ost-startStop-1] .s.DelegatingFilterProxyRegistrationBean : Mapping filter: 'springSecurityFilterChain' to: [/*]
2018-09-25 22:37:27.833  INFO 11144 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2018-09-25 22:37:30.070  INFO 11144 --- [ost-startStop-1] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: org.springframework.security.web.util.matcher.AnyRequestMatcher@1, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@33dcf2b7, org.springframework.security.web.context.SecurityContextPersistenceFilter@6d7a8bbc, org.springframework.security.web.header.HeaderWriterFilter@3ff8ae33, org.springframework.security.web.authentication.logout.LogoutFilter@6ca4174, com.tree.security.auth.jwt.JwtTokenAuthenticationProcessingFilter@576c5f0c, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@326b14e5, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@30783e7c, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@1b57cdcc, org.springframework.security.web.session.SessionManagementFilter@29c7bfa9, org.springframework.security.web.access.ExceptionTranslationFilter@32b9cba, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@12eaa469]
2018-09-25 22:37:30.547  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@63fb91b1: startup date [Tue Sep 25 22:37:23 COT 2018]; root of context hierarchy
2018-09-25 22:37:30.751  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/auth/login],methods=[POST],produces=[application/json]}" onto public org.springframework.http.ResponseEntity<com.tree.domain.dto.ResponseServiceDTO> com.tree.controller.LoginController.loginUser(com.tree.domain.model.Usuario)
2018-09-25 22:37:30.753  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/arbol/create],methods=[POST],produces=[application/json]}" onto public org.springframework.http.ResponseEntity<com.tree.domain.dto.ResponseServiceDTO> com.tree.controller.TreeBinaryController.crearArbol(com.tree.domain.dto.ArbolDto)
2018-09-25 22:37:30.754  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/arbol/addNodos],methods=[POST],produces=[application/json]}" onto public org.springframework.http.ResponseEntity<com.tree.domain.dto.ResponseServiceDTO> com.tree.controller.TreeBinaryController.addNodos(com.tree.domain.dto.ArbolDto)
2018-09-25 22:37:30.759  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2018-09-25 22:37:30.760  INFO 11144 --- [ost-startStop-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2018-09-25 22:37:30.833  INFO 11144 --- [ost-startStop-1] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-25 22:37:30.833  INFO 11144 --- [ost-startStop-1] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-25 22:37:30.936  INFO 11144 --- [ost-startStop-1] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2018-09-25 22:37:31.498  INFO 11144 --- [ost-startStop-1] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2018-09-25 22:37:31.518  INFO 11144 --- [ost-startStop-1] com.tree.ServletInitializer              : Started ServletInitializer in 9.772 seconds (JVM running for 16.338)
2018-09-25 22:37:31.557  INFO 11144 --- [           main] org.apache.coyote.ajp.AjpNioProtocol     : Starting ProtocolHandler ["ajp-nio-8009"]
2018-09-25 22:37:31.563  INFO 11144 --- [           main] org.apache.catalina.startup.Catalina     : Server startup in 14225 ms
```

Se pueden observar los diferentes ENDPOINTS REST configurados.

### Revisar Configuracion Proyecto

Abrir el archivo `/compras_api_rest/src/main/resources/application.yml` para revisar las propiedades de conexión y seguridad.

Datos de Generación JWT - JSON Web Token

```shell
rest.security.jwt:
  tokenExpirationTime: 60 # Number of minutes
  refreshTokenExpTime: 60 # Minutes
  tokenIssuer: tree_binary_api
  tokenSigningKey: pass12345
  
rest.security.web:
  pathWihtoutAuth: /api/**  
  tokenBasedAuthEntryPoint: /auth/**

```
Si desea cambiar el tiempo de vida del Token para los servicios REST puede modificar el parametro `tokenExpirationTime`.



Probar Servicios REST
---------------------------


Mediante un cliente de servicios como [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop), importar los siguientes comandos de linea CURL:


### Login / Generacion Token


```shell
curl -X POST \
  http://localhost:8080/tree_binary_api/auth/login \
  -H 'content-type: application/json' \
  -d '{
	"password":"654321",
	"email":"admin@tree.com"
}'
```

Resultado despues de loguearse satisfactoriamente:

```shell
{
    "responseCode": "000000",
    "responseMessage": null,
    "data": {
        "accessToken": {
            "expireTime": "1537937300000",
            "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc3VhcmlvIiwic2NvcGVzIjpbIkFETUlOIl0sImRhdGFVc2VyIjoxLCJpc3MiOiJ0cmVlX2JpbmFyeV9hcGkiLCJpYXQiOjE1Mzc5MzM3MDAsImV4cCI6MTUzNzkzNzMwMH0.wv1747GEBa_3OldFpVNsuBH3VyZLXCyJaCI-FudfABIrIFS3BMwXUHxR9xP5mfWqCZr1tCzMqaXfNG53cg-kvA"
        },
        "user": {
            "username": "Usuario",
            "password": null,
            "email": "admin@tree.com",
            "id": 1
        }
    },
    "errores": null
}
```

Se obtiene un `responseCode` igual `000000` lo que indica una respuesta exitosa. El `accessToken` contiene los datos del Token a ser usado en los demas servicios REST mientras su tiempo de vida este vigente.

Los Datos del cliente (Usuario) se ven en el objeto `user`.


### Crear Arbol

```shell
curl -X POST \
  http://localhost:8080/tree_binary_api/auth/arbol/create \
  -H 'Content-Type: application/json' \
  -H 'x-authorization: bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc3VhcmlvIiwic2NvcGVzIjpbIkFETUlOIl0sImRhdGFVc2VyIjoxLCJpc3MiOiJ0cmVlX2JpbmFyeV9hcGkiLCJpYXQiOjE1Mzc5MzM3MDAsImV4cCI6MTUzNzkzNzMwMH0.wv1747GEBa_3OldFpVNsuBH3VyZLXCyJaCI-FudfABIrIFS3BMwXUHxR9xP5mfWqCZr1tCzMqaXfNG53cg-kvA' \
  -d '{
	"values": [70,84,85]
	
}'
```

Resultado:

```shell
{
    "responseCode": "000000",
    "responseMessage": null,
    "data": {
        "raiz": {
            "valor": 70,
            "padre": null,
            "hijoIzquierdo": null,
            "hijoDerecho": {
                "valor": 84,
                "padre": null,
                "hijoIzquierdo": null,
                "hijoDerecho": {
                    "valor": 85,
                    "padre": null,
                    "hijoIzquierdo": null,
                    "hijoDerecho": null
                }
            }
        },
        "identificador": 1
    },
    "errores": null
}
```
Se puede observar, que se uso un atributo de cabecera `x-authorization` donde se concatena a la palabra `bearer` y un espacio ` ` el token generado en el servicio de Login.

Si no se usa ese atributo en la cabecera los servicios responderan de la siguiente forma:

```shell
{
    "status": 401,
    "message": "Authentication failed: Authorization header cannot be blank!",
    "errorCode": 1000,
    "timestamp": 1537934095790
}
```

En caso de que el token haya expirado, los servicios responderan:

```shell
{
    "status": 401,
    "message": "Token has expired",
    "errorCode": 1003,
    "timestamp": 1537934150403
}
```


### Adicionar Nodos Arbol

Tener encuenta que se debe configurar el ID del Arbol al que se le quiere anexar mas nodos.

```shell
curl -X POST \
  http://localhost:8080/tree_binary_api/auth/arbol/addNodos \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: b7b75cd4-8663-4499-870d-7b01ba16069d' \
  -H 'x-authorization: bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc3VhcmlvIiwic2NvcGVzIjpbIkFETUlOIl0sImRhdGFVc2VyIjoxLCJpc3MiOiJ0cmVlX2JpbmFyeV9hcGkiLCJpYXQiOjE1Mzc5MzM3MDAsImV4cCI6MTUzNzkzNzMwMH0.wv1747GEBa_3OldFpVNsuBH3VyZLXCyJaCI-FudfABIrIFS3BMwXUHxR9xP5mfWqCZr1tCzMqaXfNG53cg-kvA' \
  -d '{
	"id": 1,
	"values":[70,84,78,80]
}'
```


Resultado esperado:

```shell
{
    "responseCode": "000000",
    "responseMessage": null,
    "data": {
        "raiz": {
            "valor": 70,
            "padre": null,
            "hijoIzquierdo": {
                "valor": 70,
                "padre": null,
                "hijoIzquierdo": null,
                "hijoDerecho": null
            },
            "hijoDerecho": {
                "valor": 84,
                "padre": null,
                "hijoIzquierdo": {
                    "valor": 84,
                    "padre": null,
                    "hijoIzquierdo": {
                        "valor": 78,
                        "padre": null,
                        "hijoIzquierdo": null,
                        "hijoDerecho": {
                            "valor": 80,
                            "padre": null,
                            "hijoIzquierdo": null,
                            "hijoDerecho": null
                        }
                    },
                    "hijoDerecho": null
                },
                "hijoDerecho": {
                    "valor": 85,
                    "padre": null,
                    "hijoIzquierdo": null,
                    "hijoDerecho": null
                }
            }
        },
        "identificador": 1
    },
    "errores": null
}
```

Gracias por revisar este código.


