docker compose up -d

#Get in Redis CLI
docker exec -it redis redis-cli

#Use RabbitMQ UI
http://localhost:15672

#Get all
KEYS *

#Get event by KEY
GET event:xxxxxxxxxxx

curl -X POST http://localhost:8080/api/v1/message -H "Content-Type: text/plain" -d "Hello Consumer App"
