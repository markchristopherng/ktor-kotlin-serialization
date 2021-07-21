The Greeting sample app by Mark Ng. It includes 2 versions of the Greeting app

- one using Ktor
- one using Ktor and Koin for dependency injection

#### Build
```bash
./gradlew clean build
```

#### Run in IDE (Intellij)

right click on Application.kt - Ktor and Koin example

### Testing
```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"firstName":"Mark","lastName":"Ng"}' \
  http://localhost:8080/greeting
```
