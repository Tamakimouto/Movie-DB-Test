package edu.uga.cs4300.logiclayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.uga.cs4300.persistlayer.MoviePersistImpl;

/**
 * MovieLogicImpl
 *
 * Uses the persist layer to run complete db accesses.
 */
public class MovieLogicImpl {

    /**
     * getMovieList
     *
     * returns a resultset containing movies by genre
     */
    public static ResultSet getMovieList(String genre) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        ResultSet movies = movFunctions.listMovies(genre);
        return movies;
    }

    /**
     * getMovie
     *
     * returns a resultset containing a single movie by id
     */
    public static ResultSet getMovie(int id) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        ResultSet movie = movFunctions.getMovieInfoById(id);
        return movie;
    }

    /**
     * getMovie
     *
     * returns a resultset containing a single movie by title
     */
    public static ResultSet getMovie(String title) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        ResultSet movie = movFunctions.getMovieInfo(title);
        return movie;
    }

    /**
     * getMovieReviews
     *
     * returns a resultset containing reviews by id
     */
    public static ResultSet getMovieReviews(int id) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        ResultSet reviews = movFunctions.getReviews(id);
        return reviews;
    }

    /**
     * deleteReview
     *
     * deletes reviews by id
     */
    public static void deleteReview(int id) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        movFunctions.deleteReview(id);
    }

    /**
     * deleteMovie
     *
     * deletes movie by id
     */
    public static void deleteMovie(int movieId) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        movFunctions.deleteMovie(movieId);
        movFunctions.deleteReviewsByMovie(movieId);
        movFunctions.deleteMoviesGenres(movieId);
    }

    /**
     * createReview
     *
     * creates the specified review
     */
    public static void createReview(int movieId, String review) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        movFunctions.createReview(movieId, review);
    }

    /**
     * createMovie
     *
     * creates the specified movie
     */
    public static void createMovie(int movieId, String title, int year, float rank) {
        MoviePersistImpl movFunctions = new MoviePersistImpl();
        movFunctions.createMovie(movieId, title, year, rank);
    }
}
