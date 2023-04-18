# voting-service

## To run in terminal ##

#### In the project directory ####

    docker-compose up --build -d

#### To follow the logs ####

    docker logs --follow  voting-service-app

## To run in IDE ##

#### In application settings ####

Set active profiles to: local

### To authenticate ###

    [POST] localhost:8080/auth/sign-in

#### Can use the credentials:

- To role USER
    - email: user@test.com
    - password: user123

- To role ADMIN
    - email: admin@test.com
    - password: admin123

- To role MASTER
    - email: master@test.com
    - password: master123

### Agenda endpoint ###

    [POST] localhost:8080/v1/agenda

#### It is necessary to send 5 mandatory parameters

| Request Parameter | What is It           |
|-------------------|----------------------|
| name              | Name of agenda       |  
| subject           | Subject of agenda    |  
| comments          | Comments of agenda   |
| startTime         | Agenda opening hours |  
| durationInHours   | Expected duration    |  

### Voting session endpoint ###

    [POST] localhost:8080/v1/voting-sessions

#### It is necessary to send 6 mandatory parameters

| Request Parameter | What is It                           |
|-------------------|--------------------------------------|
| agendaCode        | Code of agenda                       |  
| startTime         | Voting session opening time          |  
| durationInMinutes | Expected duration in minutes         |
| allowedRoles      | Roles accepted to vote               |  
| votingFields      | Fields to be voted                   |  
| isSingleVote      | true if each user can only vote once |  

### Voting endpoint ###

    [POST] localhost:8080/v1/voting-sessions/{voting-session-id}/vote

#### It is necessary to send 1 mandatory parameters

| Request Parameter | What is It  |
|-------------------|-------------|
| field             | Voted field |  
