<p align="center">
  <img src="https://rawgit.com/johntostring/millimall/master/doc/logo.png" alt="Millimall E-commerce" width="256">
  <br>
</p>
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

## License
    <one line to give the program's name and a brief idea of what it does.>
    Copyright (C) <year>  <name of author>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.