package Theatre;

import java.time.LocalDateTime;

public class Showtime {
    private LocalDateTime dateTime;
    private Movie movie;

    private Showtime(int year, int month, int day, int hour, int min, Movie movie) {
        this.dateTime = LocalDateTime.of(year, month, day, hour, min);
        this.movie = movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public boolean refundable() {
        LocalDateTime time = LocalDateTime.now().plusHours(72);
        if ( time.compareTo(dateTime) >= 0) {
            return false;
        } else {
            return true;
        }
    }

}
