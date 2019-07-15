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

### GetMovieRequest (/api/GetMovieRequest)
 - Request for movie, can take in MovieID, Release Year, Title, and/or Genres
 - Will use this to query database and will return GetMovieResult
##### Example Input:
  ```json
{
    "id": "movie-id-123124",
    "title": "Avengers121342",
    "releaseDate": "124141245"
}
```
### GetMovieResult
 - List of Movies found from request received
##### Example Output
 ```json
  {
    "movie": [
     {
       "id": "movie-id-123124",
       "title": "Avengers121342",
       "releaseDate": "124141245",
       "runtime": 160
     },
     {
       "id": "movie-id-5678",
       "title": "Spider-Man",
       "releaseDate": "Aug 131",
       "runTime": 100
     }
   ]
  }
```
TODO: Add actual response example


FrontEnd should make a POST call to GetMovieRequest then use JSON 
to output movies

 ## Things to keep in mind:
 * GetMovieRequest should handle making calls to look for movies in external APIs in case new releases have been made
 regardless of whether movie appears or not
 * Should also update movie list with latest movies
 * Also update existing movie info if it is incomplete due to not being able to receive all the info
 * Should have a minimum percentage of missing info to avoid random movies from being added
 * Can use more APIs or WebScraping for more movie data

 Should be much more organized and easier to read/build upon than old website

 Separation of Back-End and Front-End already makes requests much easier to execute and Java makes managing movie
 data much nicer