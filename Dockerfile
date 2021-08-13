FROM java:8u111-jdk
RUN mkdir /usr/src/app
WORKDIR /usr/src/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/src/app/spring-boot-demo.jar
ENV TZ=Europe/Kyiv
EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/src/app/spring-boot-demo.jar"]
