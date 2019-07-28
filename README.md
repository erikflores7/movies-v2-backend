## Backend API for Movies Website v2

### Movie
 - Contains information such as Title, ID, Release Date, Genres, and more
 

##### Example: 
```json
{
  "movie": {
    "id": "tt-123141",
    "title": "My Life",
    "releaseDate": "Aug 00010",
    "runTime": 180,
    "genres": [
      "ACTION", "THRILLER"
    ]
  }
}
```

### GetMovieRequest (/api/v1/GetMovieRequest)
 - Request specific movie with id
 - Will return Movie object if found
##### Example Input:
  ```json
{
    "id": "movie-id-123124"
}
```
### GetMovieResult
 - Movie object with the id
 
### SearchMovieRequest (/api/v1/SearchMovieRequest)
 - Request for movie search
 - Can be Title, Year, Genre, Latest, Upcoming, etc.
 - Input is just URL path
##### Example Input:
  ```json
{
    "path": "movies/search/title/Avengers"
}
``` 
##### Example Output
 ```json
  {
    "movie": [
     {
       "id": "movie-id-123124",
       "title": "The Avengers",
       "releaseDate": "124141245",
       "runtime": 160
     },
     {
       "id": "movie-id-5678",
       "title": "Avengers: Endgame",
       "releaseDate": "Aug 131",
       "runTime": 100
     }
   ]
  }
```
TODO: Add actual response example


FrontEnd will handle form submission and change URL
according to type of search, examples:

  Search by Title:
  /movies/search/title/Avengers
    
  Search by Genre:
  /movies/search/genre/horror
  
  Search by Year:
  /movies/search/year/2019
  
  Search by Latest:
  /movies/search/latest
  
  Get Movie by Id:
  /movies/movieid12345

 ## Things to keep in mind:
 * Should handle calling API for movies even if results appear
 * Should also periodically use API to get new movies
 * Also update existing movie info if it is incomplete due to not being able to receive all the info
 * Should have a minimum percentage of missing info to avoid random movies from being displayed
 * Can use more APIs or WebScraping for more movie data

 Should be much more organized and easier to read/build upon than old website

 Separation of Back-End and Front-End already makes requests much easier to execute and Java makes managing movie
 data much nicer
 
 ## Currently working on:
 * Implementing basic Get/Search functions and SQL functions
 * Converting old String Dates to SQL Dates
 * Need to begin using pooling for database connection