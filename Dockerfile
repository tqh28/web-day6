FROM openjdk:8

ENV TZ=UTC

EXPOSE 8080

ADD target/web-day7-0.0.1-SNAPSHOT.jar web-day7.jar

CMD ["java", "-jar", "web-day7.jar", "--spring.datasource.url=jdbc:mysql://remotemysql.com:3306/IcX4eYCO77", "--spring.datasource.username=IcX4eYCO77", "--spring.datasource.password=D6Q7iL9wHg"]

# docker build -t tqh28/web-day7:latest .