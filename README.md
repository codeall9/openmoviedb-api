## OpenMovieDatabase API

A kotlin wrapper for [OMDb](http://www.omdbapi.com/) API powered by [Ktor](https://github.com/ktorio/ktor)

## How to build

Use the gradle [wrapper](./gradlew) to build the project.

```bash
gradlew build
```

## Usage

#### Select an engine
Declare an [HTTP engines](https://ktor.io/clients/http-client/engines.html) in your project, for example:
```kotlin
dependencies {
    implementation("io.ktor:ktor-client-cio:$ktor_version")
}
```

#### Create requests
```kotlin
val omdb: OpenMovieDatabase = OmdbClient("apiKey")

val movie1: Movie = omdb.getMovieById("id")
val movie2: Movie = omdb.getMovieByTitle("title")

val search: SearchResult = omdb.searchFilms("query")
```

## Roadmap
 - [X] Support desktop or native platform
 - [ ] Support Poster API
 

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
This project is under [Mozilla Public License Version 2.0](./LICENSE)