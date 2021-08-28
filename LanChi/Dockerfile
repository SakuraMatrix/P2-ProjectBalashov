FROM openjdk:11
ADD ./target/*.jar app.jar
ENV CASSANDRA_IP=""
ENTRYPOINT { "sh", "-c", "java -jar /app.jar" }