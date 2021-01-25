# kiwi

kiwi is a java/vue web application meant to act as my personal portfolio. It pulls a list of my current public GitHub repositories and displays them in a bootstrap grid format in the browser.

## Running locally

Clone the repository and execute the following.  The application runs on port 8080.

```
// Build the code
./gradlew build

// Start the application
docker-compose up --build
```

You can view the service logs by running the following.

```
docker-compose logs -f
```

## License
[MIT](https://choosealicense.com/licenses/mit/)