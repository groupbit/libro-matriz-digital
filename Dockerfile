FROM jetty:9-jre8-alpine
WORKDIR $JETTY_BASE
RUN mkdir migrations
COPY bin/wait-for /wait-for
COPY src/main/resources/db/migration/* migrations/
COPY target/libro-matriz-digital.war webapps/ROOT.war
