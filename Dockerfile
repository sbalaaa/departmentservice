# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/restservice-boot-1.0.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/restservice-boot-1.0.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar", "-DskipTests=true"]