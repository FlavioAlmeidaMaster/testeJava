FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/Teste-Java.jar
WORKDIR /app
ENTRYPOINT java -jar Teste-Java.jar