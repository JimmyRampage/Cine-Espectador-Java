
import classes.*;

public class App {
    public static void main(String[] args) throws Exception {
        // INSTANCIANDO CINE
        Cine cinema = new Cine();

        //// Agregando peliculas
        cinema.setPeliculasEstreno(new Pelicula("El Padrino", 2.55, 18, "Francis Ford Coppola"));
        cinema.setPeliculasEstreno(new Pelicula("Inception", 2.28, 13, "Christopher Nolan"));
        cinema.setPeliculasEstreno(new Pelicula("La La Land", 2.08, 12, "Damien Chazelle"));
        cinema.setPeliculasEstreno(new Pelicula("Forrest Gump", 2.22, 13, "Robert Zemeckis"));
        cinema.setPeliculasEstreno(new Pelicula("The Lion King", 1.28, 0, "Roger Allers and Rob Minkoff"));
        cinema.setPeliculasEstreno(new Pelicula("Lilo & Stitch", 1.25, 0, "Chris Sanders and Dean DeBlois"));

        //// Ver cartelera
        // cinema.verCartelera();

        Sala sala1 = new Sala();
        sala1.setFilaColumna(4, 4);
        Sala sala2 = new Sala();
        sala2.setFilaColumna(4, 4);
        Sala sala3 = new Sala();
        sala3.setFilaColumna(4, 4);

        cinema.setSala(sala1);
        cinema.setSala(sala2);
        cinema.setSala(sala3);

        sala1.setPeliculaSala(cinema.getPeliculasEstrenoPool());
        sala2.setPeliculaSala(cinema.getPeliculasEstrenoPool());
        sala3.setPeliculaSala(cinema.getPeliculasEstrenoPool());

        System.out.println(sala1);
        System.out.println(sala2);
        System.out.println(sala3);
        
        // Ver CINE
        System.out.println(cinema);
        
        // ESPECTADOR
        Espectador esp0 = new Espectador();
        Espectador esp1 = new Espectador();
        Espectador esp2 = new Espectador();
        Espectador esp3 = new Espectador();
        Espectador esp4 = new Espectador();
        Espectador esp5 = new Espectador();
        Espectador esp6 = new Espectador();
        Espectador esp7 = new Espectador();
        Espectador esp8 = new Espectador();
        Espectador esp9 = new Espectador();
        Espectador esp10 = new Espectador();
        Espectador esp11 = new Espectador();

        // cinema.reservarEspectador(esp7, 1, 'A', sala3);
        // cinema.reservarEspectador(esp7, 1, 'A', sala3);
        // cinema.reservarEspectador(esp7, 1, 'I', sala3);
        // cinema.reservarEspectador(esp7, 7, 'A', sala3);
        // cinema.reservarEspectador(esp7, 7, 'I', sala3);
        // cinema.reservarEspectador(esp7, 2, 'B', sala3);
        // cinema.reservarEspectador(esp7, 3, 'C', sala3);
        // cinema.reservarEspectador(esp7, 6, 'B', sala3);

        // SELECCION ALEATOREA
        // // SALA 1
        cinema.reservarEspectador(esp1, sala1);
        cinema.reservarEspectador(esp2, sala1);
        cinema.reservarEspectador(esp3, sala1);
        cinema.reservarEspectador(esp4, sala1);
        cinema.reservarEspectador(esp5, sala1);
        cinema.reservarEspectador(esp6, sala1);
        cinema.reservarEspectador(esp7, sala1);
        cinema.reservarEspectador(esp8, sala1);
        cinema.reservarEspectador(esp9, sala1);
        cinema.reservarEspectador(esp0, sala1);

        // // SALA 2
        // cinema.reservarEspectador(esp1, sala2);
        // cinema.reservarEspectador(esp2, sala2);
        // cinema.reservarEspectador(esp3, sala2);
        // cinema.reservarEspectador(esp4, sala2);
        // cinema.reservarEspectador(esp5, sala2);
        // cinema.reservarEspectador(esp6, sala2);
        // cinema.reservarEspectador(esp7, sala2);
        // cinema.reservarEspectador(esp8, sala2);
        // cinema.reservarEspectador(esp9, sala2);
        // cinema.reservarEspectador(esp0, sala2);

        // // SALA 3 (COLAPSANDO LA SALA 2X1)
        // cinema.reservarEspectador(esp1, sala3);
        // cinema.reservarEspectador(esp1, sala3);
        // cinema.reservarEspectador(esp2, sala3);
        // cinema.reservarEspectador(esp2, sala3);
        // cinema.reservarEspectador(esp3, sala3);
        // cinema.reservarEspectador(esp3, sala3);
        // cinema.reservarEspectador(esp4, sala3);
        // cinema.reservarEspectador(esp4, sala3);
        // cinema.reservarEspectador(esp5, sala3);
        // cinema.reservarEspectador(esp5, sala3);
        // cinema.reservarEspectador(esp6, sala3);
        // cinema.reservarEspectador(esp6, sala3);
        // cinema.reservarEspectador(esp7, sala3);
        // cinema.reservarEspectador(esp7, sala3);
        // cinema.reservarEspectador(esp8, sala3);
        // cinema.reservarEspectador(esp8, sala3);
        // cinema.reservarEspectador(esp9, sala3);
        // cinema.reservarEspectador(esp9, sala3);
        // cinema.reservarEspectador(esp0, sala3);
        // cinema.reservarEspectador(esp0, sala3);
        // cinema.reservarEspectador(esp10, sala3);
        // cinema.reservarEspectador(esp10, sala3);
        // cinema.reservarEspectador(esp10, sala3);
        // cinema.reservarEspectador(esp11, sala3);
        // cinema.reservarEspectador(esp11, sala3);
        // cinema.reservarEspectador(esp11, sala3);
        System.out.println(cinema);
        System.out.println(esp0);
    }
}
