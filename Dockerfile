FROM openjdk:24-jdk
ADD target/invoiceApp.jar invoiceApp.jar
ENTRYPOINT ["java","-jar","/invoiceApp.jar"]
EXPOSE 8080