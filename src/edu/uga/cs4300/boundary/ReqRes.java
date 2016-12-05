package edu.uga.cs4300.boundary;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;
import edu.uga.cs4300.logiclayer.*;
import edu.uga.cs4300.objectlayer.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ReqRes")
public class ReqRes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Configuration cfg = null;

    private String templateDir = "/WEB-INF/templates";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqRes() {
        super();
    }

    public void init() {
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.25) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_25);

        // Specify the source where the template files come from.
        cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String f = request.getParameter("form");

        if (f.equals("genre")) {
            String g = request.getParameter("genre");
            ResultSet movieIds = MovieLogicImpl.getMovieList(g);
            ResultSet movie = null;
            Map<String, Object> ls = new HashMap<String, Object>();
            List<Movie> movies = new ArrayList<Movie>();
            try {
                while (movieIds.next()) {
                    movie = MovieLogicImpl.getMovie(movieIds.getInt(1));
                    while (movie.next())
                        movies.add(new Movie(movie.getInt(1), movie.getString(2), movie.getInt(3), movie.getFloat(4)));
                }
                ls.put("movies", movies);
                runTemplate("movielist.ftl", ls, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (f.equals("title")) {
            String title = request.getParameter("title");
            ResultSet movie = MovieLogicImpl.getMovie(title);
            Map<String, Object> info = new HashMap<String, Object>();
            try {
                while (movie.next()) {
                    Movie selected = new Movie(movie.getInt(1), movie.getString(2), movie.getInt(3), movie.getFloat(4));
                    info.put("movie", selected);
                }
                runTemplate("singleMovie.ftl", info, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (f.equals("review")) {
            String id = request.getParameter("movieId");
            ResultSet rev = MovieLogicImpl.getMovieReviews(Integer.parseInt(id.replaceAll(",", "")));
            Map<String, Object> ls = new HashMap<String, Object>();
            List<Review> reviews = new ArrayList<Review>();
            try {
                while (rev.next())
                    reviews.add(new Review(rev.getInt(1), rev.getInt(2), rev.getString(3)));
                ls.put("reviews", reviews);
                ls.put("id", Integer.parseInt(id.replaceAll(",", "")));
                runTemplate("movieReviews.ftl", ls, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (f.equals("delete")) {
            String action = request.getParameter("cType");
            if (action.equals("review")) {
                String reviewId = request.getParameter("revId");
                String currentMovieId = request.getParameter("currMovie");
                MovieLogicImpl.deleteReview(Integer.parseInt(reviewId.replaceAll(",", "")));
                ResultSet rev = MovieLogicImpl.getMovieReviews(Integer.parseInt(currentMovieId.replaceAll(",", "")));
                Map<String, Object> ls = new HashMap<String, Object>();
                List<Review> reviews = new ArrayList<Review>();
                try {
                    while (rev.next())
                        reviews.add(new Review(rev.getInt(1), rev.getInt(2), rev.getString(3)));
                    ls.put("reviews", reviews);
                    runTemplate("movieReviews.ftl", ls, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                String movId = request.getParameter("movieId");
                MovieLogicImpl.deleteMovie(Integer.parseInt(movId.replaceAll(",", "")));
                Map<String, Object> ls = new HashMap<String, Object>();
                runTemplate("home.ftl", ls, response);
            }
        } else if (f.equals("create")) {
            String action = request.getParameter("cType");
            if (action.equals("review")) {
                String reviewContent = request.getParameter("revText");
                String currentMovieId = request.getParameter("currMovie");
                MovieLogicImpl.createReview(Integer.parseInt(currentMovieId.replaceAll(",", "")), reviewContent);
                ResultSet rev = MovieLogicImpl.getMovieReviews(Integer.parseInt(currentMovieId.replaceAll(",", "")));
                Map<String, Object> ls = new HashMap<String, Object>();
                List<Review> reviews = new ArrayList<Review>();
                try {
                    while (rev.next())
                        reviews.add(new Review(rev.getInt(1), rev.getInt(2), rev.getString(3)));
                    ls.put("reviews", reviews);
                    runTemplate("movieReviews.ftl", ls, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                Map<String, Object> ls = new HashMap<String, Object>();
                runTemplate("createMovie.ftl", ls, response);
            }
        } else if (f.equals("newMovie")) {
            String id = request.getParameter("id");
            String title = request.getParameter("name");
            String year = request.getParameter("year");
            String rank = request.getParameter("rank");
            MovieLogicImpl.createMovie(Integer.parseInt(id.replaceAll(",", "")), title, Integer.parseInt(year), Float.parseFloat(rank));
            Map<String, Object> ls = new HashMap<String, Object>();
            runTemplate("home.ftl", ls, response);
        }
    }


    /**
     * runTemplate
     *
     * This function runs the freemarker template depending on
     * the given parameters.
     */
    public void runTemplate(String template, Map<String, Object> tplModel, HttpServletResponse response) {
        Template tpl;
        try {
            tpl = cfg.getTemplate(template);
            response.setContentType("text/html");
            Writer out = response.getWriter();
            tpl.process(tplModel, out);
        } catch (TemplateNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
