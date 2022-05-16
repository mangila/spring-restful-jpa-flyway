#!/bin/sh
./mvnw clean package && docker build -t mangila/spring-restful-jpa-flyway . && docker push mangila/spring-restful-jpa-flyway