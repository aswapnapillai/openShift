From java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=SBA
ENV MYSQL_USER=swara
ENV MYSQL_PASSWORD=KisanSwaraj@123
ENV MYSQL_CI_URL=jdbc:mysql://139.59.85.157:3306/SBA?useSSL=false
ADD ./target/favouriteservice-1.0.jar /usr/src/bookrecommendationservice-1.0.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "bookrecommendationservice-1.0.jar"]
