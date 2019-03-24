FROM java:8
VOLUME /tmp
ADD ./target/ribbon.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9002
ENTRYPOINT ["java","-jar","/app.jar"]