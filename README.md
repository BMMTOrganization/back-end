* To start this project back end, cd to the project `finalProject` folder and
  (and for now, you'll need to run on branch `messy`)
```
./mvnw spring-boot:run
```
* You should get a Spring Boot app up and running on port 8080.
* Use PostMan or other http tool to verify the server is running.
* Or in a browser do a `http://localhost:8080` to see the API calls possible.
* Other things to try
```
http://localhost:8080/userProfiles
http://localhost:8080/accounts
```
* You'll need to change the postgres creds in `finalProject/src/main/resources/application.properties` to agree with
* a user on your postgres server (user and password probably) and you will have needed to do a
```
CREATE DATABASE bmmt;
```
* from inside of a `psql` session. Make sure the user you choose to access with has full privileges on `bmmt`.
* (You might use `root` if you're in a development environment)