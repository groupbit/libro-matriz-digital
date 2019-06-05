FROM jetty:9-jre8-alpine
WORKDIR $JETTY_BASE
COPY bin/wait-for /wait-for
COPY target/libro-matriz-digital.war webapps/ROOT.war
RUN mkdir migrations
COPY src/main/resources/db/migration/* migrations/
