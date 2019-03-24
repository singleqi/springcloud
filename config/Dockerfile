FROM java:8
VOLUME /tmp
ADD ./target/config.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9010
ENTRYPOINT ["java","-jar","/app.jar"]