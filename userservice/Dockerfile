FROM openjdk:8
VOLUME /tmp
ADD ./target/userservice-1.0.jar userservice-1.0.jar
EXPOSE 9876
ENTRYPOINT ["java","-jar","userservice-1.0.jar"]
