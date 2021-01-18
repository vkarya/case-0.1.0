FROM java:8

WORKDIR /app
COPY ./build/libs/case-0.1.0-0.1.0.jar /app

EXPOSE 8080

CMD ["java", "-jar", "case-0.1.0-0.1.0.jar"]