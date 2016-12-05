package edu.uga.cs4300.objectlayer;

/**
  * Movie
  *
  *  Movie object template
  */
public class Movie {
    public int id;
    public String name;
    public int year;
    public float rank;

    public Movie(int id, String name, int year, float rank) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public float getRank() {
        return rank;
    }
}
