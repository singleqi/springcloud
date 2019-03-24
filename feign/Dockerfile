FROM java:8
VOLUME /tmp
ADD ./target/feign.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9001
ENTRYPOINT ["java","-jar","/app.jar"]