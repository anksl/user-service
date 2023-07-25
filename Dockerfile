FROM ibm-semeru-runtimes:open-11-jre
COPY target/user-service.jar user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]