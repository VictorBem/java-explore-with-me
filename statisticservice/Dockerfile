FROM amazoncorretto:11-al2023-jdk
VOLUME /tmp
ARG JAR_FILE=/service/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar"]