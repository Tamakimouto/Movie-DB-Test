package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * MoviePersistImpl
 *
 * All of the SQL statements are setup in this file.
 */
public class MoviePersistImpl extends DbAccessImpl {

    public MoviePersistImpl(){}

    public ResultSet listMovies(String genre) {
        String action = "SELECT movie_id FROM movies_genres WHERE genre=\"" + genre + "\"";
        Connection dbCon = connect();
        ResultSet movids = retrieve(dbCon, action);
        return movids;
    }

    public ResultSet deleteMoviesGenres(int movieId) {
        String action = "DELETE FROM movies_genres WHERE movie_id=" + movieId;
        Connection dbCon = connect();
        ResultSet movids = retrieve(dbCon, action);
        return movids;
    }

    public ResultSet getMovieInfoById(int id) {
        String action = "SELECT * FROM movies WHERE id=" + id;
        Connection dbCon = connect();
        ResultSet movieInfo = retrieve(dbCon, action);
        return movieInfo;
    }

    public ResultSet getMovieInfo(String title) {
        String action = "SELECT * FROM movies WHERE name=\"" + title + "\"";
        Connection dbCon = connect();
        ResultSet movieInfo = retrieve(dbCon, action);
        return movieInfo;
    }

    public ResultSet getReviews(int id) {
        String action = "SELECT * FROM reviews WHERE movie_id=" + id;
        Connection dbCon = connect();
        ResultSet movieReviews = retrieve(dbCon, action);
        return movieReviews;
    }

    public void createReview(int movieId, String review) {
        String action = "INSERT INTO reviews (id, movie_id, review) " +
            "VALUES (" + null + ", " + movieId  + ", \"" + review + "\")";
        Connection dbCon = connect();
        create(dbCon, action); 
    }

    public void deleteReview(int id) {
        String action = "DELETE FROM review WHERE id=" + id;
        Connection dbCon = connect();
        delete(dbCon, action);
    }

    public void deleteReviewsByMovie(int movieId) {
        String action = "DELETE FROM review WHERE movie_id=" + movieId;
        Connection dbCon = connect();
        delete(dbCon, action);
    }

    public void createMovie(int id, String title, int year, float rank) {
        String action = "INSERT INTO movies (id, name, year, rank) " +
            "VALUES (" + id + ", \"" + title + "\", " + year  + ", " + rank + ")";
        Connection dbCon = connect();
        create(dbCon, action);
    }

    public void deleteMovie(int id) {
        String action = "DELETE FROM movies WHERE id=" + id;
        Connection dbCon = connect();
        delete(dbCon, action);
    }
}
