package Theatre;

import java.util.HashMap;

public class Theater {
    // Fields
    private String name;
    private HashMap<String, Movie> movies;
    
    // Constructor
    public Theater(String name) {
        this.name = name;
        movies = new HashMap<>();
    }
    
    // Methods
    public Movie getMovie(String name) {
        return movies.get(name);
    }
    public void addMovie(Movie movie) {
        if(!movies.containsKey(movie.getTitle())){
            movies.put(movie.getTitle(), movie);
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HashMap<String, Movie> getMovies() {
        return movies;
    }
    public void setMovies(HashMap<String, Movie> movies) {
        this.movies = movies;
    }
    
    // Overridden
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Theater)) return false;
        Theater theater = (Theater) obj;
        if (theater.name.compareTo(this.name) == 0)
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result=17;
        result=31*result+(name!=null ? name.hashCode():0);
        return result;
    }
}
