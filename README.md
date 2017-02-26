# Online Shopping Mall - Microservices Architecture In Practice

> The goal of this project is to use Spring Cloud to build a practical
microservices architecture mall system, using docker to deploy.

## Architecture
![Project architecture](https://rawgit.com/johntostring/millimall/master/doc/millimall-architecture.png)

### Service Discovery
- Consul
- Kubernetes provides

### Container Orchestration
- Kubernetes
- Docker Compose

## Start required services
- config-server
- oauth2-server
```
docker-compose -f consul.yml -f database.yml -f docker-compose.yml up -d
```