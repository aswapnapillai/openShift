From java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=SBA
ENV MYSQL_USER=swara
ENV MYSQL_PASSWORD=KisanSwaraj@123
ENV MYSQL_CI_URL=jdbc:mysql://139.59.85.157:3306/SBA
ADD ./target/userservice-1.0.jar /usr/src/userservice-1.0.jar
EXPOSE 9876
ENTRYPOINT ["java", "-jar", "userservice-1.0.jar"]
