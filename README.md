# deegeu-quizzer
A simple micro service that returns trivia questions. This respository is the source code for the Trivia Question microservice playlist on DeegeU.com and [YouTube](https://www.youtube.com/playlist?list=PLZlGOBonMjFVQJgpSUv-sBi1p4Zhb10cz).


You can find more programming videos on [the DeegeU channel](http://www.deegeu.com/subscribe)

## Getting started

The application can be run using the following command. Use the correct version for SNAPSHOT and BUILDNUMBER when running. This will launch the application.

```
java -jar ./target/deegeu-quizzer.SNAPSHOT.BUILDNUMBER-swarm.jar
```

The service can be tested using either curl, REST client, or your favorite browser.

Running the command will return a random question at a command prompt.
```
curl http://localhost:8080/trivia/questions/random
```

The starting point for the API is at 
```
curl -I http://localhost:8080/trivia
```

This code is written and compiled for Java 8.

## Building the code

The mvn POM file requires two parameters passed.

```
mvn clean install -Dproject.version=1.0.0 -Dbuild.number=$BUILD_NUMBER.$GIT_COMMIT
```

The code can be compiled locally using 

```
mvn clean install -Dproject.version=1.0.0 -Dbuild.number=001
```

## Getting help

If you are having troubles getting the source code, please see [Getting the source code](http://www.deegeu.com/getting-the-source-code/) or the video [How to get code from GitHub](http://www.deegeu.com/videos/how-to-get-code-from-github/)  

## License

MIT: http://rem.mit-license.org

## Feedback

Any feedback is welcome. You can contact me at dj at deegeu.com, the [Facebook page](https://www.facebook.com/deegeu.programming.tutorials), the [Google+ page](https://plus.google.com/+Deegeu-programming-tutorials/posts) or on [DeegeU.com](http://www.deegeu.com).

## Contributions

If you wish to contribute to any issues you find in the source code, please issue a pull request.
