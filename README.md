# axio-test-task
## How to deploy a project
 1) You have to download a [docker image](https://hub.docker.com/repository/docker/l3r8y/axio-test-task-image/general) with application
 2) Download [docker image](https://hub.docker.com/repository/docker/l3r8y/axio-test-task-image/general) with database
 3) Start container with **database** with port `5432`
 4) Start container with **application** with any port (I'm usually do it on `8080`)
 5) Open in browser `http://localhost:application_port/`