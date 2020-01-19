FROM openjdk:12-alpine

EXPOSE 8080

COPY target/SpringbootApp-*.jar /SpringbootApp.jar

CMD ["java", "-jar", "/SpringbootApp.jar"]