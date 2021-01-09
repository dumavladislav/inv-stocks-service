FROM openjdk:11-jdk-slim
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

COPY ./target/ /usr/src/inv-stocks-service/
WORKDIR /usr/src/inv-stocks-service

#RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Europe/Moscow /etc/localtime
RUN echo "Europe/Moscow" >  /etc/timezone

ENTRYPOINT ["java", "-jar", "./inv-stocks-service-0.0.1-SNAPSHOT.jar"]