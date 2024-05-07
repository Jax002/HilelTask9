FROM openjdk:11

WORKDIR /app

COPY target/HilelTask8jar /app/HilelTask8.jar

CMD ["java", "-jar", "HilelTask8.jar"]