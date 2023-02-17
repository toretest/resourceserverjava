FROM openjdk:17-jdk

ARG ENV_ARG="default"

ENV ENV_VAR=$ENV_ARG

VOLUME /tmp

COPY target/*.jar myApp.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myApp.jar","--spring.profiles.active=$ENV_VAR"]
