## OpenMovieDatabase API

A kotlin wrapper for [OMDb](http://www.omdbapi.com/) API powered by [Ktor](https://github.com/ktorio/ktor)

## How to build

Use the gradle [wrapper](./gradlew) to build the project.

```bash
gradlew build
```

## Usage

```kotlin
val omdb = OmdbClient("apiKey")

val movie1: Movie = omdb.getMovieById("id")
val movie2: Movie = omdb.getMovieByTitle("title")

val search: SearchResult = omdb.searchFilms("query")
```

## Roadmap
 - [ ] Support desktop or native platform
 - [ ] Support Poster API
 

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
This project is under [GNU General Public License v3.0](./LICENSE)