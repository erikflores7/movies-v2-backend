package me.erikflores.movies.movie;

public class Rating {

    private double imdb;
    private int metacritic;
    private int rottenTomates;

    private Rating(double imdb, int metacritic, int rottenTomates){
        this.imdb = imdb;
        this.metacritic = metacritic;
        this.rottenTomates = rottenTomates;
    }

    public double getIMDB(){
        return imdb;
    }

    public int getMetacritic(){
        return metacritic;
    }

    public int getRottenTomates(){
        return rottenTomates;
    }
    public static class builder{

        private double imdb;
        private int metacritic;
        private int rottingTomates;

        public Rating build(){
            return new Rating(imdb, metacritic, rottingTomates);
        }

        public builder withIMDB(double rating){
            this.imdb = rating;
            return this;
        }

        public builder withMetaCritic(int rating){
            this.metacritic = rating;
            return this;
        }

        public builder withRottenTomatoes(int rating){
            this.rottingTomates = rating;
            return this;
        }

    }


}
