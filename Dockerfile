FROM openjdk:11
EXPOSE 8080
COPY target/blog-application.jar blog-application.jar
ENTRYPOINT ["java","-jar","/blog-application.jar"]