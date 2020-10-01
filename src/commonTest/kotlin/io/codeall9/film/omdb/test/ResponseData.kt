package io.codeall9.film.omdb.test

import io.codeall9.film.omdb.model.*

//language=JSON
internal const val JSON_MOVIE_1 = "{\n  \"Title\": \"Inception\",\n  \"Year\": \"2010\",\n  \"Rated\": \"PG-13\",\n  \"Released\": \"16 Jul 2010\",\n  \"Runtime\": \"148 min\",\n  \"Genre\": \"Action, Adventure, Sci-Fi, Thriller\",\n  \"Director\": \"Christopher Nolan\",\n  \"Writer\": \"Christopher Nolan\",\n  \"Actors\": \"Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy\",\n  \"Plot\": \"A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.\",\n  \"Language\": \"English, Japanese, French\",\n  \"Country\": \"USA, UK\",\n  \"Awards\": \"Won 4 Oscars. Another 152 wins & 204 nominations.\",\n  \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg\",\n  \"Ratings\": [\n    {\n      \"Source\": \"Internet Movie Database\",\n      \"Value\": \"8.8/10\"\n    },\n    {\n      \"Source\": \"Rotten Tomatoes\",\n      \"Value\": \"87%\"\n    },\n    {\n      \"Source\": \"Metacritic\",\n      \"Value\": \"74/100\"\n    }\n  ],\n  \"Metascore\": \"74\",\n  \"imdbRating\": \"8.8\",\n  \"imdbVotes\": \"1,893,414\",\n  \"imdbID\": \"tt1375666\",\n  \"Type\": \"movie\",\n  \"DVD\": \"07 Dec 2010\",\n  \"BoxOffice\": \"$292,568,851\",\n  \"Production\": \"Warner Bros. Pictures\",\n  \"Website\": \"N/A\",\n  \"Response\": \"True\"\n}"

//language=JSON
internal const val JSON_MOVIE_2 = "{\n  \"Title\": \"Joker\",\n  \"Year\": \"2019\",\n  \"Rated\": \"R\",\n  \"Released\": \"04 Oct 2019\",\n  \"Runtime\": \"122 min\",\n  \"Genre\": \"Crime, Drama, Thriller\",\n  \"Director\": \"Todd Phillips\",\n  \"Writer\": \"Todd Phillips, Scott Silver, Bob Kane (based on characters created by), Bill Finger (based on characters created by), Jerry Robinson (based on characters created by)\",\n  \"Actors\": \"Joaquin Phoenix, Robert De Niro, Zazie Beetz, Frances Conroy\",\n  \"Plot\": \"In Gotham City, mentally-troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: \\\"The Joker\\\".\",\n  \"Language\": \"English\",\n  \"Country\": \"USA, Canada\",\n  \"Awards\": \"N/A\",\n  \"Poster\": \"https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg\",\n  \"Ratings\": [\n    {\n      \"Source\": \"Internet Movie Database\",\n      \"Value\": \"8.9/10\"\n    },\n    {\n      \"Source\": \"Rotten Tomatoes\",\n      \"Value\": \"68%\"\n    },\n    {\n      \"Source\": \"Metacritic\",\n      \"Value\": \"59/100\"\n    }\n  ],\n  \"Metascore\": \"59\",\n  \"imdbRating\": \"8.9\",\n  \"imdbVotes\": \"360,218\",\n  \"imdbID\": \"tt7286456\",\n  \"Type\": \"movie\",\n  \"DVD\": \"N/A\",\n  \"BoxOffice\": \"N/A\",\n  \"Production\": \"Warner Bros. Pictures\",\n  \"Website\": \"N/A\",\n  \"Response\": \"True\"\n}"

//language=JSON
internal const val JSON_SERIES_1 = "{\n  \"Title\": \"Rick and Morty\",\n  \"Year\": \"2013–\",\n  \"Rated\": \"TV-MA\",\n  \"Released\": \"02 Dec 2013\",\n  \"Runtime\": \"23 min\",\n  \"Genre\": \"Animation, Adventure, Comedy, Sci-Fi\",\n  \"Director\": \"N/A\",\n  \"Writer\": \"Dan Harmon, Justin Roiland\",\n  \"Actors\": \"Justin Roiland, Chris Parnell, Spencer Grammer, Sarah Chalke\",\n  \"Plot\": \"An animated series that follows the exploits of a super scientist and his not-so-bright grandson.\",\n  \"Language\": \"English\",\n  \"Country\": \"USA\",\n  \"Awards\": \"13 wins & 9 nominations.\",\n  \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMjRiNDRhNGUtMzRkZi00MThlLTg0ZDMtNjc5YzFjYmFjMmM4XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_SX300.jpg\",\n  \"Ratings\": [\n    {\n      \"Source\": \"Internet Movie Database\",\n      \"Value\": \"9.3/10\"\n    }\n  ],\n  \"Metascore\": \"N/A\",\n  \"imdbRating\": \"9.3\",\n  \"imdbVotes\": \"297,018\",\n  \"imdbID\": \"tt2861424\",\n  \"Type\": \"series\",\n  \"totalSeasons\": \"3\",\n  \"Response\": \"True\"\n}"

//language=JSON
internal const val JSON_EPISODE_1 = "{\n  \"Title\": \"Chapter Two: Trick or Treat, Freak\",\n  \"Year\": \"2017\",\n  \"Rated\": \"TV-14\",\n  \"Released\": \"27 Oct 2017\",\n  \"Season\": \"2\",\n  \"Episode\": \"2\",\n  \"Runtime\": \"56 min\",\n  \"Genre\": \"Drama, Fantasy, Horror, Mystery, Sci-Fi, Thriller\",\n  \"Director\": \"Matt Duffer, Ross Duffer\",\n  \"Writer\": \"Matt Duffer (created by), Ross Duffer (created by), Matt Duffer, Ross Duffer, Jessie Nickson-Lopez (executive story editor), Paul Dichter (staff writer), Kate Trefry (staff writer)\",\n  \"Actors\": \"Winona Ryder, David Harbour, Finn Wolfhard, Millie Bobby Brown\",\n  \"Plot\": \"After Will sees something terrible on trick-or-treat night, Mike wonders whether Eleven's still out there. Nancy wrestles with the truth about Barb.\",\n  \"Language\": \"English\",\n  \"Country\": \"N/A\",\n  \"Awards\": \"N/A\",\n  \"Poster\": \"https://m.media-amazon.com/images/M/MV5BOTY2MDE3ODU2OV5BMl5BanBnXkFtZTgwMjE4MzcyNDM@._V1_SX300.jpg\",\n  \"Ratings\": [\n    {\n      \"Source\": \"Internet Movie Database\",\n      \"Value\": \"8.4/10\"\n    }\n  ],\n  \"Metascore\": \"N/A\",\n  \"imdbRating\": \"8.4\",\n  \"imdbVotes\": \"12536\",\n  \"imdbID\": \"tt6020792\",\n  \"seriesID\": \"tt4574334\",\n  \"Type\": \"episode\",\n  \"Response\": \"True\"\n}"

//language=JSON
internal const val JSON_SEARCH_1 = "{\n  \"Search\": [\n    {\n      \"Title\": \"Terminator 2: Judgment Day\",\n      \"Year\": \"1991\",\n      \"imdbID\": \"tt0103064\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"The Terminator\",\n      \"Year\": \"1984\",\n      \"imdbID\": \"tt0088247\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BYTViNzMxZjEtZGEwNy00MDNiLWIzNGQtZDY2MjQ1OWViZjFmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator 3: Rise of the Machines\",\n      \"Year\": \"2003\",\n      \"imdbID\": \"tt0181852\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMTk5NzM1ODgyN15BMl5BanBnXkFtZTcwMzA5MjAzMw@@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator Salvation\",\n      \"Year\": \"2009\",\n      \"imdbID\": \"tt0438488\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BODE1MTM1MzA2NF5BMl5BanBnXkFtZTcwODQ5MTA2Mg@@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator Genisys\",\n      \"Year\": \"2015\",\n      \"imdbID\": \"tt1340138\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMjM1NTc0NzE4OF5BMl5BanBnXkFtZTgwNDkyNjQ1NTE@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator: The Sarah Connor Chronicles\",\n      \"Year\": \"2008–2009\",\n      \"imdbID\": \"tt0851851\",\n      \"Type\": \"series\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BZGE2ZDgyOWUtNzdiNS00OTI3LTkwZGQtMTMwNzM4YWUxNGNhXkEyXkFqcGdeQXVyNjU2NjA5NjM@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator: Dark Fate\",\n      \"Year\": \"2019\",\n      \"imdbID\": \"tt6450804\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BNzhlYjE5MjMtZDJmYy00MGZmLTgwN2MtZGM0NTk2ZTczNmU5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator 3: Rise of the Machines\",\n      \"Year\": \"2003\",\n      \"imdbID\": \"tt0364056\",\n      \"Type\": \"game\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMjA5OTk4MTQwNV5BMl5BanBnXkFtZTgwMzkxNTEwMTE@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Terminator 2: Judgment Day\",\n      \"Year\": \"1991\",\n      \"imdbID\": \"tt0244839\",\n      \"Type\": \"game\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BN2FhOTQ2MmQtNTY0OC00NWYyLThjNjMtZmZiOTBmYTY4MmM2XkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_SX300.jpg\"\n    },\n    {\n      \"Title\": \"Lady Terminator\",\n      \"Year\": \"1989\",\n      \"imdbID\": \"tt0095483\",\n      \"Type\": \"movie\",\n      \"Poster\": \"https://m.media-amazon.com/images/M/MV5BMTg5NTA1NzEtNWNiNy00ZTc4LWJhZTgtYmJkODZhYWI3NmQ4XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"\n    }\n  ],\n  \"totalResults\": \"84\",\n  \"Response\": \"True\"\n}"

//language=JSON
internal const val JSON_NOT_FOUND = "{\n  \"Response\": \"False\",\n  \"Error\": \"data not found!\"\n}"

internal val testMovie1 = Movie(
    "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy",
    "Won 4 Oscars. Another 152 wins & 204 nominations.",
    "$292,568,851",
    "USA, UK",
    "07 Dec 2010",
    "Christopher Nolan",
    "Action, Adventure, Sci-Fi, Thriller",
    "tt1375666",
    "8.8",
    "1,893,414",
    "English, Japanese, French",
    "74",
    "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
    "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg",
    "Warner Bros. Pictures",
    "PG-13",
    listOf(Rating("Internet Movie Database", "8.8/10"), Rating("Rotten Tomatoes", "87%"), Rating("Metacritic", "74/100")),
    "16 Jul 2010",
    "True",
    "148 min",
    "Inception",
    "movie",
    "N/A",
    "Christopher Nolan",
    "2010"
)

internal val testMovie2 = Movie(
    "Joaquin Phoenix, Robert De Niro, Zazie Beetz, Frances Conroy",
    "N/A",
    "N/A",
    "USA, Canada",
    "N/A",
    "Todd Phillips",
    "Crime, Drama, Thriller",
    "tt7286456",
    "8.9",
    "360,218",
    "English",
    "59",
    "In Gotham City, mentally-troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: \"The Joker\".",
    "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",
    "Warner Bros. Pictures",
    "R",
    listOf(Rating("Internet Movie Database", "8.9/10"), Rating("Rotten Tomatoes", "68%"), Rating("Metacritic", "59/100")),
    "04 Oct 2019",
    "True",
    "122 min",
    "Joker",
    "movie",
    "N/A",
    "Todd Phillips, Scott Silver, Bob Kane (based on characters created by), Bill Finger (based on characters created by), Jerry Robinson (based on characters created by)",
    "2019"
)

internal val testSeries1 = Series("Justin Roiland, Chris Parnell, Spencer Grammer, Sarah Chalke", "13 wins & 9 nominations.", "USA", "N/A", "Animation, Adventure, Comedy, Sci-Fi", "tt2861424", "9.3", "297,018", "English", "N/A", "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.", "https://m.media-amazon.com/images/M/MV5BMjRiNDRhNGUtMzRkZi00MThlLTg0ZDMtNjc5YzFjYmFjMmM4XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_SX300.jpg", "TV-MA", listOf(Rating("Internet Movie Database", "9.3/10")), "02 Dec 2013", "23 min", "Rick and Morty", "3", "series", "Dan Harmon, Justin Roiland", "2013–", "True")

internal val testEpisode1 = Episode("Winona Ryder, David Harbour, Finn Wolfhard, Millie Bobby Brown", "N/A", "N/A", "Matt Duffer, Ross Duffer", "2", "Drama, Fantasy, Horror, Mystery, Sci-Fi, Thriller", "tt6020792", "8.4", "12536", "English", "N/A", "After Will sees something terrible on trick-or-treat night, Mike wonders whether Eleven's still out there. Nancy wrestles with the truth about Barb.", "https://m.media-amazon.com/images/M/MV5BOTY2MDE3ODU2OV5BMl5BanBnXkFtZTgwMjE4MzcyNDM@._V1_SX300.jpg", "TV-14", listOf(Rating("Internet Movie Database", "8.4/10")), "27 Oct 2017", "56 min", "2", "tt4574334", "Chapter Two: Trick or Treat, Freak", "episode", "Matt Duffer (created by), Ross Duffer (created by), Matt Duffer, Ross Duffer, Jessie Nickson-Lopez (executive story editor), Paul Dichter (staff writer), Kate Trefry (staff writer)", "2017", "True")

private val searchList = listOf(
    FilmInfo("tt0103064", "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "Terminator 2: Judgment Day", "movie", "1991"),
    FilmInfo("tt0088247", "https://m.media-amazon.com/images/M/MV5BYTViNzMxZjEtZGEwNy00MDNiLWIzNGQtZDY2MjQ1OWViZjFmXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "The Terminator", "movie", "1984"),
    FilmInfo("tt0181852", "https://m.media-amazon.com/images/M/MV5BMTk5NzM1ODgyN15BMl5BanBnXkFtZTcwMzA5MjAzMw@@._V1_SX300.jpg", "Terminator 3: Rise of the Machines", "movie", "2003"),
    FilmInfo("tt0438488", "https://m.media-amazon.com/images/M/MV5BODE1MTM1MzA2NF5BMl5BanBnXkFtZTcwODQ5MTA2Mg@@._V1_SX300.jpg", "Terminator Salvation", "movie", "2009"),
    FilmInfo("tt1340138", "https://m.media-amazon.com/images/M/MV5BMjM1NTc0NzE4OF5BMl5BanBnXkFtZTgwNDkyNjQ1NTE@._V1_SX300.jpg", "Terminator Genisys", "movie", "2015"),
    FilmInfo("tt0851851", "https://m.media-amazon.com/images/M/MV5BZGE2ZDgyOWUtNzdiNS00OTI3LTkwZGQtMTMwNzM4YWUxNGNhXkEyXkFqcGdeQXVyNjU2NjA5NjM@._V1_SX300.jpg", "Terminator: The Sarah Connor Chronicles", "series", "2008–2009"),
    FilmInfo("tt6450804", "https://m.media-amazon.com/images/M/MV5BNzhlYjE5MjMtZDJmYy00MGZmLTgwN2MtZGM0NTk2ZTczNmU5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg", "Terminator: Dark Fate", "movie", "2019"),
    FilmInfo("tt0364056", "https://m.media-amazon.com/images/M/MV5BMjA5OTk4MTQwNV5BMl5BanBnXkFtZTgwMzkxNTEwMTE@._V1_SX300.jpg", "Terminator 3: Rise of the Machines", "game", "2003"),
    FilmInfo("tt0244839", "https://m.media-amazon.com/images/M/MV5BN2FhOTQ2MmQtNTY0OC00NWYyLThjNjMtZmZiOTBmYTY4MmM2XkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_SX300.jpg", "Terminator 2: Judgment Day", "game", "1991"),
    FilmInfo("tt0095483", "https://m.media-amazon.com/images/M/MV5BMTg5NTA1NzEtNWNiNy00ZTc4LWJhZTgtYmJkODZhYWI3NmQ4XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "Lady Terminator", "movie", "1989")
)
internal val testSearch1 = SearchResult(searchList, "84", "True")

internal val testNotFoundError = ErrorStatus("False", "data not found!")
