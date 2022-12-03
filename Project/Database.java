package Project;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entry.*;
import Theatre.*;

/**
 * Database
 */
public class Database {
    // Private field and constructor
    private Connection connection;
    private Database(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:../Database/theater.db");
        } catch (Exception e) {
            e.printStackTrace();
        }         
    }

    // Static object variable
    private static Database db = null;

    // Singleton Constructor and destructor
    public static Database getInstance() {
        if(db == null) 
            db = new Database();
        return db;   
    }
    
    public static void closeALLConnections(){
        try {
            db.connection.close();
            db = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Seats and Theater object from database
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
    
    public Theater getTheater(){
        HashMap<String, Theater> theaters = new HashMap<>();
        try {
            String query = "SELECT * FROM time_seat";
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theaters.get("Theater480");
    }

    // User Database Interactions
    public void addUserToDatabase(String username, String password, String email, boolean registered) throws SQLException {
        int registeredBit = (registered == true) ? 1 : 0;
        String query = "INSERT INTO \"user\" VALUES ('" + username + "', '" + email + "', '" + password + "', " + registeredBit + ");";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
     }

    public void deleteUserFromDatabase(String email) throws SQLException {
        String query = "DELETE FROM user WHERE email='" + email + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void findUserFromDatabase(String email) throws SQLException {
        String query = "DELETE FROM user WHERE email='" + email + "'";
        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    public void populateUserArray(List<User> users) throws SQLException {
        String query = "SELECT username, email, password, registered FROM user";
        Statement statement  = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) { 
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            int registered = rs.getInt("registered");
            
            if (registered == 1) {
                User newUser = new RegisteredUser(username, password, email);
                users.add(newUser);
            }
            else {
                User newUser = new User(email);
                users.add(newUser);
            }
        }

        statement.close();
    }

    public boolean checkIfEmailExists(String email) throws SQLException {
        String query = "SELECT email FROM user";
        Statement statement  = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) { 
            String current_email = rs.getString("email");
            if (email.equals(current_email)) return true;
        }
        return false;
    }
    
    public boolean checkIfUsernameExists(String username) throws SQLException {
        String query = "SELECT username FROM user";
        Statement statement  = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) { 
            String current_username = rs.getString("username");
            if (username.equals(current_username)) return true;
        }
        return false;
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