package Theatre;
import java.sql.*;
import java.util.HashMap;

/**
 * Database
 */
public class Database {
    // Private field and constructor
    private Theater theater;
    private Database(){

        Connection connection = null;
        HashMap<String, Theater> theaters = new HashMap<>();
        
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../Database/theater.db");
            System.out.println("Opened database connection");
            String query = "SELECT * FROM time_seat";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {

                // Make a theater
                String theater_str = resultSet.getString("theatre");
                Theater theater = new Theater(theater_str);

                // Make a movie object
                String movie_str = resultSet.getString("movie_name");
                Movie movie = new Movie(movie_str);

                // Create a showtime with room
                int room = resultSet.getInt("room number");
                int year = resultSet.getInt("year");
                int month = resultSet.getInt("month");
                int day = resultSet.getInt("day");
                int hour = resultSet.getInt("hour");
                int minute = resultSet.getInt("minute");
                Showtime showtime = new Showtime(room, year, month, day, hour, minute);

                // Create Seat
                String seat_id = resultSet.getString("seat");
                boolean memberOnly = 0 != resultSet.getInt("MemberOnly");
                boolean booked = 0 !=  resultSet.getInt("Booked");
                Seat seat = new Seat(seat_id, memberOnly, booked);

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
            
            // for(Map.Entry<String, Theater> t : theaters.entrySet() ){
            //     for(Map.Entry<String, Movie> m : t.getValue().getMovies().entrySet()){
            //         System.out.println(m.getKey());
            //         for(Showtime s : m.getValue().getShowtimes() ) {
            //             System.out.println("\t" + s.getTime());
            //             for(Map.Entry<String, Seat> x : s.getSeats().entrySet()) {
            //                 if(x.getValue().getIsMemberOnly())
            //                     System.out.println("\t\t"+ x.getValue().getId());
            //             }
            //         }
            //     }

            // }

            connection.close();
        } catch (SQLException e) {
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
    
    // getter
    public Theater getTheater() {
        return theater;
    }
    
    public static void main(String[] args) {
    }
}