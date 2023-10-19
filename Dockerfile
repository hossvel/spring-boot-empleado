FROM maven:3-alpine
WORKDIR /appmavenjenkins
ADD . /appmavenjenkins
EXPOSE 8081
CMD jenkins/scripts/deliver.sh
