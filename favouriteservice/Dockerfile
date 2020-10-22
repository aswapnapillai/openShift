FROM openjdk:8
VOLUME /tmp
ADD ./target/favouriteservice-1.0.jar favouriteservice-1.0
EXPOSE 8765
ENTRYPOINT ["java","-jar","favouriteservice-1.0"]