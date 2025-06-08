FROM maven:3.8.4-openjdk-17-slim
WORKDIR /usr/app
COPY . .
RUN mvn clean package
ENTRYPOINT ["java","-jar","./target/mockbase-1.0-SNAPSHOT.jar"]
EXPOSE 5010