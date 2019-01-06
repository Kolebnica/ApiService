# ApiService
Service API entrypoints.

[![Build Status](https://travis-ci.org/Kolebnica/ApiService.svg?branch=master)](https://travis-ci.org/Kolebnica/ApiService)

## REST API

Default port: 8084

Accessing OpenAPI: [localhost:8084/api-specs/ui/?url=http://localhost:8084/api-specs/api/openapi.json](localhost:8084/api-specs/ui/?url=http://localhost:8084/api-specs/api/openapi.json)

## Making & running a Docker image

1. Build Docker image with `docker build -t skiprope/apiservice . `
2. Run Docker image `docker run --name skiprope-apiservice --publish 8084:8084 --detach skiprope/apiservice`
3. Stop & remove docker container `docker stop skiprope-apiservice && docker rm skiprope-apiservice`
4. Remove docker image `docker rmi skiprope/apiservice`