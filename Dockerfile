# back
FROM openjdk:8-jdk-alpine

LABEL maintainer="2262288@gmail.com"
VOLUME /tmp

EXPOSE 8099

ARG JAR_FILE=build/libs/auth-mocroservice-0.0.4.jar
ADD ${JAR_FILE} digital-breakthrough.jar
ENTRYPOINT ["java","-jar","/digital-breakthrough.jar"]
