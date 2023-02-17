FROM openjdk:17-jdk

VOLUME /tmp

COPY target/*.jar resourceserverjava.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/resourceserverjava.jar","--spring.profiles.active=$ENV_VAR"]
