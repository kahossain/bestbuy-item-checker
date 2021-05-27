FROM maven:3-jdk-11

RUN apt-get update -qq && apt-get install -qq --no-install-recommends jq

COPY target/*.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT [ "java", "-jar", "/usr/app/bestbuy-item-tracker.jar"]
