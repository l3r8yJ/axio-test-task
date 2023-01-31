# axio-test-task
## How to deploy a project
 1) You have to download a [docker image](https://hub.docker.com/repository/docker/l3r8y/axio-test-task-image/general) with application
 2) Start **database** with port `5432`
 3) Start container with **application** with any port (I'm usually do it on `8080`)
 4) Open in browser `http://localhost:application_port/`
## Схема базы данных
![image](https://user-images.githubusercontent.com/46355873/215897226-c5a389f0-ee55-493e-a1d6-1b9f539eca59.jpeg)
## CI/CI GitHub actions(build project, build docker image after merged pull request)
![image](https://user-images.githubusercontent.com/46355873/215898250-677dfaf7-0891-4cc2-bc4e-4abce504dcdf.jpeg)
## Главная страница 
![Screenshot 2023-02-01 at 02 07 34](https://user-images.githubusercontent.com/46355873/215895329-71a80d58-174d-4082-b87e-68dcb94b59d6.jpg)
## Список клиентов
![Screenshot 2023-02-01 at 02 07 48](https://user-images.githubusercontent.com/46355873/215895422-a66dd77b-6473-4a79-8aa1-2d32fb38b928.jpg)
## Поиск по фамилии
![Screenshot 2023-02-01 at 02 08 40](https://user-images.githubusercontent.com/46355873/215895707-96be53ba-2c51-44fa-a460-3f76c2d58ee3.jpg)
## Поиск по паспорту
![Screenshot 2023-02-01 at 02 09 06](https://user-images.githubusercontent.com/46355873/215895785-03a7b1ed-c536-45de-aac4-4d346b6c3319.jpg)
## Поиск по номеру телефона
![Screenshot 2023-02-01 at 02 09 24](https://user-images.githubusercontent.com/46355873/215895819-ea7f00ec-eb71-4505-868f-856aa1218f1c.jpg)
## Список заявок со статусом одобрения
![Screenshot 2023-02-01 at 02 09 31](https://user-images.githubusercontent.com/46355873/215895943-252a587d-9b1f-4487-ae60-7250743508ad.jpg)
## Список договоров со статусом подписания
![Screenshot 2023-02-01 at 02 09 37](https://user-images.githubusercontent.com/46355873/215896005-a28c1262-7675-4414-9e55-23dde0fbb6e2.jpg)
## Форма для оформления новой заявки
![Screenshot 2023-02-01 at 02 09 45](https://user-images.githubusercontent.com/46355873/215896070-89b87688-3a08-4b89-84c1-70469c1f4e82.jpg)
