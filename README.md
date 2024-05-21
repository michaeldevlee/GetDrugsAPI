# druglookup

druglookup is a web application built to transform data from the openFDA API to make it easier to consume on the frontend.

## Introduction
The openFDA API provides endpoints to retrieve useful drug data however, the responses can be very large and have nested fields. The primary goal of this project was to demonstrate the simplification through a full-stack application that pulls in the transformed data.

## Technologies Used

- Backend: Maven 3.9.6, Java 17, Spring Boot, RESTful API
- Frontend: Angular 17, TypeScript, HTML, CSS
- APIs: openFDA API

## Features

- Retrieve and transform data from the openFDA API.
- Display the data in a user-friendly format on the frontend.

## Local Setup and Installation

The application utilizes docker to setup the environment as seen in the `docker-compose-local.yaml`

```
version: '3.8'

services:
  # Angular Demo
  thedrugapi-frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    networks:
      - drugnet
    ports:
      - '80:80'

  # Spring Boot Demo API
  thedrugapi-backend:
    build:
      context: ./backend
      dockerfile: Dockerfile
    networks:
      - drugnet
    ports:
      - '8080:8080'
networks:
  drugnet:
    driver: bridge
```


1. Change directories to the `backend` folder and run `mvn clean install` to produce the `.jar` file to be run in the docker container
2. Change directories back to the root of the project and run `docker compose -f docker-compose-local.yaml up -d` to create the containers
3. Open your browser and navigate to http://localhost to use the application.
4. Type in the appropriate search fields and press `Submit Query` to get the transformed data

## What I learned
### Angular Components

- Creating Components: Learned how to generate and use components to encapsulate different parts of the UI.
- Component Communication: Utilized Input and Output decorators for parent-child communication and event handling.

### Angular Services

- Dependency Injection: Gained experience with Angular's DI system to manage service lifetimes and dependencies.
- HTTP Client: Used Angular's HttpClient module to make HTTP requests to the backend API and handle responses.

### Event System

- Event Binding: Implemented event binding to handle user interactions and dynamically update the UI.

## Live Site
This demo can be viewed in production [here](https://druglookup.netlify.app). The frontend is hosted on Netlify while the backend is in a OCI compute instance docker container behind an NGINX reverse proxy. 

### Examples
![image](https://github.com/michaeldevlee/GetDrugsAPI/assets/58196525/6221fafe-4362-4d2e-8d0b-c85e81eb057f)
![image](https://github.com/michaeldevlee/GetDrugsAPI/assets/58196525/1faa1b4d-4863-46ff-8fc7-50c7a4d8b5b5)
![image](https://github.com/michaeldevlee/GetDrugsAPI/assets/58196525/27977113-3eb2-41d3-9b04-19476b13a4cd)


