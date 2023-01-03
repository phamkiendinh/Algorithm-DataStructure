import java.util.*;

public class MovieOrdering {
    ArrayList<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        MovieOrdering mv = new MovieOrdering();
        Movie a = new Movie("Squid Game", "Thriller", 7.6, 120);
        Movie b = new Movie("Spider-Man", "Action", 8.5, 110);
        Movie c = new Movie("The Matrix Resurrections", "Action", 6.2, 140);
        MovieOrdering mo = new MovieOrdering();
        mo.addMovie(a);
        mo.addMovie(b);
        mo.addMovie(c);
        System.out.println("Current: " + mo.currentJoyfulness()); // return 230
        System.out.println("Max: " + mo.maxJoyfulness()); // return 370
    }

    //
    public void addMovie(Movie m) {
        movies.add(m);
    }

    public int currentJoyfulness() {
        int sum = 0;
        for (int i = 0; i < movies.size() - 1; i++) {
            if (i == 0) {
                sum += movies.get(i).duration;
            }
            if (movies.get(i).genre != movies.get(i + 1).genre && movies.get(i).rating < movies.get(i + 1).rating) {
                sum += movies.get(i + 1).duration;
            }
        }
        return sum;
    }

    public int maxJoyfulness() {
        Movie array[] = new Movie[movies.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = movies.get(i);
        }
        int result = getSubset(array, 0, 0);
        return result;
    }

    private int getSubset(Movie array[], int index, int max) {
        if (index == array.length) {
            System.out.println("Array: " + Arrays.toString(array));
            int sum = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (i == 0) {
                    sum += array[i].duration;
                }
                if (array[i].genre != array[i + 1].genre && array[i].rating < array[i + 1].rating) {
                    sum += array[i + 1].duration;
                }
            }
            return sum;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            int a = getSubset(array, index + 1, max);
            if (max < a) {
                max = a;
            }
            swap(array, i, index);
        }
        return max;
    }

    private void swap(Movie array[], int i1, int i2) {
        Movie temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}

class Movie {
    String title;
    String genre;
    double rating;
    int duration;

    public Movie(String title, String genre, double rating, int duration) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
    }
}