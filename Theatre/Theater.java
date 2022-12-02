package Theatre;

import Entry.RegisteredUser;

import java.util.ArrayList;

public class Theater {
        private ArrayList<Movie> movies;
        private ArrayList<Showroom> showrooms;
        private ArrayList<RegisteredUser> users;

        private String name;

        public Theater(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public ArrayList<Movie> getMovies() {
                return movies;
        }

        public void setMovies(ArrayList<Movie> movies) {
                this.movies = movies;
        }

        public ArrayList<Showroom> getShowrooms() {
                return showrooms;
        }

        public void setShowrooms(ArrayList<Showroom> showrooms) {
                this.showrooms = showrooms;
        }

        public ArrayList<RegisteredUser> getUsers() {
                return users;
        }

        public void setUsers(ArrayList<RegisteredUser> users) {
                this.users = users;
        }

        public void add(Movie movie) {
                movies.add(movie);
        }

        public void add(Showroom room) {
                showrooms.add(room);
        }

        public void add(RegisteredUser user) {
                users.add(user);
        }

        public void remove(Movie movie) {
                movies.remove(movie);
        }

        public void remove(Showroom room) {
                showrooms.remove(room);
        }

        public void remove(RegisteredUser user) {
                users.remove(user);
        }
}
