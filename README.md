# DEMO SERVER

タスクボードAPIサーバ

## Run Application

```shell
# Set environment variables
export $(.env)
# Start up Database server
docker-compose up -d
# Run Spring Application
./gradlew clean bootRun
```

[API Documentation](https://localhost:8080/swagger-ui/#/)

## Environment Variables

|name|value|
|:---|:---|
|DB_USER|postgres|
|DB_PASSWORD|postgres|
|DB_PORT|51065|
|DB_URL|jdbc:postgresql://localhost:${DB_PORT}|