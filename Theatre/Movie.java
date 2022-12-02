import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<Showtime> showtimes;

    // Constructor
    public Movie(String title) {
        this.title = title;
        showtimes = new ArrayList<>();
    }

    // Methods
    public void addShowtime(Showtime showtime) {
        if(!showtimes.contains(showtime))
            showtimes.add(showtime);
    }
    public Showtime getShowtime(Showtime showtime) {
        for(Showtime s : showtimes){
            if(s.equals(showtime))
                return s;
        }
        System.out.println("Error showtime not found!");
        return showtime;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }
    public void setShowtimes(ArrayList<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    // Overridden functions
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Movie)) return false;
        Movie movie = (Movie) obj;
        if (movie.title.compareTo(this.title) == 0)
            return true;
        return false;
    }
    @Override
    public int hashCode() {
        int result=17;
        result=31*result+(title!=null ? title.hashCode():0);
        return result;
    }
}
