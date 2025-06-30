# Spring, RabbitMQ, Redis demo app

## Software

Tools: Java21, Spring, RabbitMQ, Redis, Docker

## RabbitMQ UI
http://localhost:15672

## Setup - Localhost

```bash
cd cd rabbitmq-producer/
```
```bash
docker compose up -d
```

Startup "rabbitmq-consumer" and "rabbitmq-producer". You could use the script inside the project's directory:

```bash
./mvnw spring-boot:run
```

## Setup - Via Docker network

- Not ready yet!

## Test the application

```bash
curl -X POST http://localhost:8080/api/v1/message -H "Content-Type: text/plain" -d "Hello App :)"
```

### Enter to Redis CLI via Docker

```bash
docker exec -it redis redis-cli
```

### Get all keys inside redis

```bash
KEYS *
```
### Get event by its id (replace * with your id)

```bash
GET event:*********
```



