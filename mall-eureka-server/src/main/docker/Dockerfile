FROM java:8
VOLUME /tmp
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8
WORKDIR /
ADD mall-eureka-server-1.0-alpha-1.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
