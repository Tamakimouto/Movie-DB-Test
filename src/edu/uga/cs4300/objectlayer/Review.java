package edu.uga.cs4300.objectlayer;

/**
  * Review
  *
  * Review object template
  */
public class Review {
    public int id;
    public int movieId;
    public String review;

    public Review(int id, int movieId, String review) {
        this.id = id;
        this.movieId = movieId;
        this.review = review;
    }

    public int getId(){
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getReview() {
        return review;
    }
}
