package me.erikflores.movies.movie;

public class Rating {

    private double imdb;
    private int metaCritic;
    private int rottenTomatoes;

    private Rating(double imdb, int metaCritic, int rottenTomatoes){
        this.imdb = imdb;
        this.metaCritic = metaCritic;
        this.rottenTomatoes = rottenTomatoes;
    }

    public double getIMDB(){
        return imdb;
    }

    public int getMetacritic(){
        return metaCritic;
    }

    public int getRottenTomatoes(){
        return rottenTomatoes;
    }
    public static class builder{

        private double imdb;
        private int metaCritic;
        private int rottenTomatoes;

        public Rating build(){
            return new Rating(imdb, metaCritic, rottenTomatoes);
        }

        public builder withIMDB(double rating){
            this.imdb = rating;
            return this;
        }

        public builder withMetaCritic(int rating){
            this.metaCritic = rating;
            return this;
        }

        public builder withRottenTomatoes(int rating){
            this.rottenTomatoes = rating;
            return this;
        }

    }


}
