/* Suppose you are building a video streaming service. All videos are either TV series or movies.
Create an abstract class named Video and define the following properties and behaviors:
    title: a String representing the title of the video
    duration: an int representing the duration of the video in minutes
    getInfo(): a method that returns a String containing all of the video’s properties in a readable format
    Create two classes that extend Video: TvSeries and Movie.
TvSeries objects should have an additional episodes property, an int representing the number of episodes in the series.
Movie objects should have an additional rating property, a double representing the rating of the movie */

// Clase abstracta base que define la estructura general de un video
abstract class Video {
    String title;   // El título del video
    int duration;   // La duración del video en minutos

    // Constructor de la clase Video. Recibe el título y la duración.
    Video(String title, int duration) {
        this.title = title;      // Asigna el título al atributo title
        this.duration = duration; // Asigna la duración al atributo duration
    }

    // Metodo que devuelve la información básica del video, como su título y duración.
    // Este metodo puede ser sobrescrito por las subclases para agregar más detalles.
    String getInfo() {
        return "Title: " + title + ", Duration: " + duration + " minutes";
    }
}

// Clase Movie que extiende de Video y agrega un atributo de rating
class Movie extends Video {
    double rating; // El rating de la película (ejemplo, escala de 1 a 10)

    // Constructor de la clase Movie. Llama al constructor de Video y agrega rating.
    // Este constructor recibe título, duración y rating como parámetros.
    Movie(String title, int duration, double rating) {
        super(title, duration);  // Llama al constructor de la clase base (Video)
        this.rating = rating;    // Asigna el valor del rating a la propiedad rating
    }

    // Sobreescribe el metodo getInfo() para agregar el rating a la información del video.
    // El metodo getInfo() de Movie obtiene la información básica del video
    // y luego agrega el rating de la película.
    @Override
    String getInfo() {
        return super.getInfo() + ", Rating: " + rating; // Llama a getInfo() de la clase base y agrega el rating
    }
}

// Clase TvSeries que extiende de Video y agrega el número de episodios
class TvSeries extends Video {
    int episodes; // El número de episodios en la serie de televisión

    // Constructor de la clase TvSeries. Llama al constructor de Video y agrega el número de episodios.
    // Este constructor recibe título, duración y número de episodios como parámetros.
    TvSeries(String title, int duration, int episodes) {
        super(title, duration); // Llama al constructor de la clase base (Video)
        this.episodes = episodes; // Asigna el número de episodios a la propiedad episodes
    }

    // Sobreescribe el metodo getInfo() para agregar el número de episodios a la información del video.
    // El metodo getInfo() de TvSeries obtiene la información básica del video
    // y luego agrega el número de episodios de la serie.
    @Override
    String getInfo() {
        return super.getInfo() + ", Episodes: " + episodes; // Llama a getInfo() de la clase base y agrega el número de episodios
    }
}

// Clase principal para probar el sistema de streaming de video
public class VideoStreaming {
    public static void main(String[] args) {
        // Crea una instancia de Movie con título, duración y rating
        // Llamamos al constructor de la clase Movie para crear un objeto con los datos específicos.
        Movie movie = new Movie("El Guateque", 110, 9.1);

        // Crea una instancia de TvSeries con título, duración y número de episodios
        // Llamamos al constructor de la clase TvSeries para crear un objeto con los datos específicos.
        TvSeries series = new TvSeries("The last of as", 60, 10);

        // Imprime la información de la película usando el metodo getInfo().
        // Este metodo devuelve una cadena con todos los detalles del video.
        System.out.println(movie.getInfo());

        // Imprime la información de la serie
        System.out.println(series.getInfo());
    }
}
