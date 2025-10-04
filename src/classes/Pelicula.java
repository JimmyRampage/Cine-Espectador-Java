package classes;

public class Pelicula {
    private String titulo;
    private double duracion;
    private int edadMinima;
    private String director;

    public Pelicula() {
    }
    
    public Pelicula(String titulo, double duracion, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public int getEdadMinima() {
        return this.edadMinima;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n");
        str.append("Pelicula: " + titulo + "\n");
        str.append("\t- Duracion: " + duracion + "\n");
        str.append("\t- Edad Mínima: " + edadMinima + "\n");
        str.append("\t- Director: " + director + "\n");
        return str.toString();
    }

}
