# Spring Boot Microservices

# ATTENTION: This repository is archived, you can find the source code in the new repository that includes much more concepts and upto date - https://github.com/SaiUpadhyayula/spring-boot-3-microservices-course

The link to the new tutorial can be found here - https://www.youtube.com/playlist?list=PLSVW22jAG8pDeU80nDzbUgr8qqzEMppi8

This repository contains the latest source code of the spring-boot-microservices tutorial

You can watch the tutorial on Youtube here - https://www.youtube.com/watch?v=mPPhcU7oWDU&t=20634s

## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker

1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.

