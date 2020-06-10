# kiwi

kiwi is a java web application meant to act as my personal portfolio. It pulls a list of my current public GitHub repositories and displays them in a bootstrap grid format in the browser.

## Running locally

Clone the repository and execute the following.  The application runs on port 8080.

```
// Uses the docker-compose.yml file to start the application
./gradlew dockerComposeUp
```

You can view the service logs by running the following.

```
docker-compose logs -f
```

## License
[MIT](https://choosealicense.com/licenses/mit/)