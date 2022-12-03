package Project;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import Theatre.Movie;
import Theatre.Seat;
import Theatre.Showtime;
import Theatre.Theater;

/**
 * Database
 */
public class Database {
    // Private field and constructor
    private Theater theater;
    private Connection connection;
    private Database(){
        try {
            HashMap<String, Theater> theaters = new HashMap<>();
            String query = "SELECT * FROM time_seat";
            connection = DriverManager.getConnection("jdbc:sqlite:../Database/theater.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {

                // Make a theater
                String theater_str = resultSet.getString("theater");
                Theater theater = new Theater(theater_str);

                // Make a movie object
                String movie_str = resultSet.getString("movie_name");
                Movie movie = new Movie(movie_str);

                // Create a showtime with room
                int room = resultSet.getInt("room_number");
                int year = resultSet.getInt("year");
                int month = resultSet.getInt("month");
                int day = resultSet.getInt("day");
                int hour = resultSet.getInt("hour");
                int minute = resultSet.getInt("minute");
                Showtime showtime = new Showtime(room, year, month, day, hour, minute);

                // Create Seat
                String seat_id = resultSet.getString("seat");
                boolean member_only = resultSet.getBoolean("member_only");
                boolean booked = resultSet.getBoolean("Booked");
                Seat seat = new Seat(seat_id, member_only, booked);

                // Make Theater object
                if(!theaters.containsKey(theater_str)){
                    theaters.put(theater_str, theater);
                }
                theater = theaters.get(theater_str);
                theater.addMovie(movie);
                movie = theater.getMovie(movie.getTitle());
                movie.addShowtime(showtime);
                showtime = movie.getShowtime(showtime);
                showtime.add(seat);
            }
            this.theater = theaters.get("Theater480");
        } catch (Exception e) {
            e.printStackTrace();
        }            
    }

    // Static object variable
    private static Database db = null;

    public static Database getInstance() {
        if(db == null) 
            db = new Database();
        return db;   
    }
    public static void closeALLConnections(){
        try {
            db.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateSeatAvailability(String theater, String movie, Showtime showtime, Seat seat){
        try {
            String sql =
                "UPDATE time_seat " +
                "SET booked= ? " +
                "WHERE theater=? AND room_number=? AND movie_name=? AND year=? AND month=? AND day=? AND hour=? AND minute=? AND seat=?";
            PreparedStatement query = connection.prepareStatement(sql);
            query.setBoolean(1, seat.getIsBooked());
            query.setString(2, theater);
            query.setInt(3,showtime.getRoomNumber());
            query.setString(4, movie);
            query.setInt(5, showtime.getTime().getYear());
            query.setInt(6, showtime.getTime().getMonthValue());
            query.setInt(7, showtime.getTime().getDayOfMonth());
            query.setInt(8, showtime.getTime().getHour());
            query.setInt(9, showtime.getTime().getMinute());
            query.setString(10, seat.getId());
            System.out.println(query.executeUpdate());
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // getter
    public Theater getTheater() {
        return theater;
    }
    
    public static void main(String[] args) {
        Database db = getInstance();
        Theater t = db.getTheater();

        for( Map.Entry<String, Movie> m : t.getMovies().entrySet() ){
            for(Showtime s : m.getValue().getShowtimes() ) {
                for(Map.Entry<String, Seat> x : s.getSeats().entrySet()) {
                    x.getValue().setBooked(true);
                    if(x.getValue().getIsMemberOnly())
                        db.updateSeatAvailability(t.getName(), m.getValue().getTitle(), s, x.getValue());
                }
            }
        }
        Database.closeALLConnections();
    }
}