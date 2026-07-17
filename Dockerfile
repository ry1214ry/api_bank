
FROM tomcat:10.1-jdk21-temurin-alpine

RUN rm -rf /usr/local/tomcat/webapps/*

RUN sed -i 's/port="8080"/port="9292"/g' /usr/local/tomcat/conf/server.xml

COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 9292

CMD ["catalina.sh", "run"]

