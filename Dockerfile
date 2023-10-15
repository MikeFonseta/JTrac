FROM openjdk:11

# Set the working directory
WORKDIR /

# Copy the application jar to the container
COPY jtrac/ .
EXPOSE 8080

CMD ["echo", "HERE"]
