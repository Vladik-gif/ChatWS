FROM amazoncorretto:19-al2-full as final
WORKDIR /app
EXPOSE 8080
COPY ./build/libs/Chat-0.0.1-SNAPSHOT.jar /chat
ENTRYPOINT ["java","-jar", "/chat"]
