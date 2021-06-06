### **Spring Boot Rest API with MongoDB**

This project was developed for online books retail firm case. To develop it, there are some prerequisites.

    * Java version : 11.0.11
    * Maven : 3.5+
    * Docker : 20.10.2

Mongodb was used. There is no  prerequisite about mongodb because docker container resolved it. To containerize mongodb, we run below commands on terminal after docker installation.

    * docker pull mongo
    * docker run --name mongodb -d -p 27017:27017 mongo:latest

**Name** property is important for here because our application will connect database by using this name as host.

It is necessary to talk about how the project structure was developed. You can see **WebMvcConfig** under **config** directory where interceptor definition with bean annotation was created. It adds interceptors with both included and excluded pattern.

    * AuthenticationInterceptor : It checks whether token in request header is valid or not.
    * LoggingInterceptor : It logs which user sends which request and response details such as status and elapsed time.
    * AuthorizationInterceptor : It checks whether customer is also administrator. If customer is not administrator, he/she cannot send some request.

There are customer exception handler, and some specific exception class under **exception** directory. To prevent unstructured exception thrown, customer exception handler can catch exception and send custom response.

**CustomResponse** under **response** directory is important because generic response model make your responses more understandable. **BaseController** has custom response methods that can be called by all controllers.  

Requests follow below layer.
    
    * interceptors (if required),
    * controller,
    * service,
    * repository

Finally, **response** can be sent as **dto**.

To containerize spring rest api, in the root directory of project;

    * ./mvnw spring-boot:build-image (it builds image)
    * docker run --name sbrestapi --link mongodb -d -p 8080:8080 sbrestapi:0.0.1 (--link attribute is important because it allows spring boot application container to access mongodb container)

Postman documentation url : https://documenter.getpostman.com/view/16080504/TzY68DVe
    