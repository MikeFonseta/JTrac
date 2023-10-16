FROM openjdk:11
COPY Versions/2.2.0/ .
RUN rm -rf logs/ && rm -rf data/
ENTRYPOINT ["sh","/start.sh"]
