package classes;

import java.util.ArrayList;
import java.util.Random;

public class Cine {

    private ArrayList<Pelicula> peliculasEstreno = new ArrayList<>();
    private ArrayList<Pelicula> peliculasEstrenoPool = peliculasEstreno;
    private ArrayList<Sala> salas = new ArrayList<>();
    private final double valorEntrada = 5.89;
    private double acumulado = 0;

    public Cine() {
    }

    public double getValorEntrada() {
        return this.valorEntrada;
    }

    public double getAcumulado() {
        return this.acumulado;
    }

    // SALAS
    //// agregar salas al cine
    public void setSala(Sala s) {
        this.salas.add(s);
    }
    //// remove

    //// reservar gente en la sala
    // public void reservarEspectador(Espectador esp, int asientoX, Character asientoY, Sala salaElegida){
    //     // tomar las iniciales, y coordenadas
    //     // Convertir Chatacter a int
    //     int x = asientoX - 1;
    //     int y = salaElegida.alfabeto.indexOf(asientoY);
    //     Pelicula pel = (Pelicula) salaElegida.getPeliculaSala();

    //     // Comprobar si el asiento esta disponible
    //     boolean asientoVacio = salaElegida.getAsiento(x, y).isDisponible();
    //     boolean dineroSuficiente = esp.getDinero() >= this.valorEntrada;
    //     boolean mayorEdad = edadSuficiente(esp, pel);

    //     if (asientoVacio && dineroSuficiente && mayorEdad) {
    //         // Cobrar
    //         this.vender(esp, pel);
    //         // Sentar
    //         String asientoNumero = salaElegida.getAsiento(x, y);
    //         salaElegida.setAsiento(x, y, esp.getIniciales());
    //         System.out.printf("Asiento %s para pelicula %s -> RESERVADO!\n", asientoNumero, salaElegida.getPeliculaSala().getTitulo());
    //         System.out.printf("Se ha reservado con ID %s para Pelicula: %s\n", salaElegida.getAsiento(x, y), salaElegida.getPeliculaSala().getTitulo());
    //     } else if (!mayorEdad) { // no es mayor
    //         System.out.printf("Lo sentimos %s\n", esp.getNombre());
    //         System.out.printf("Tienes %d años para una pelicula de mínimo %d \n", esp.getEdad(), pel.getEdadMinima());
    //     } else if (!asientoVacio) {
    //         System.out.printf("Lo sentimos %s\n", esp.getNombre());
    //         System.out.printf("Asiento [%d-%c] ocupado para %s... Escoje otro!\n", asientoX, asientoY, salaElegida.getPeliculaSala().getTitulo());

    //     } else if (!dineroSuficiente) {
    //         System.out.printf("%s no cuenta con dinero suficiente...\nSolo tiene %.2f€ mientras que la entrada cuesta %.2f€\n",  esp.getNombre(), esp.getDinero(), this.getValorEntrada());
    //     }
    //     System.out.println("-".repeat(60));
    // }

    //// reserva aleatoria
    public void reservarEspectador(Espectador esp, Sala salaElegida) {
        StringBuilder str = new StringBuilder("");
        Random rnd = new Random();
        Pelicula pel = salaElegida.getPeliculaSala();
        Asiento asientoEscogido;
        int indiceRandom;

        // Corrobora si el asiento esta disponible
        if (salaElegida.getAsientosDisponibles().size() != salaElegida.getAsientosReservados().size()) {
            indiceRandom = rnd.nextInt(salaElegida.getAsientosDisponibles().size());
            asientoEscogido = salaElegida.getAsientosDisponibles().get(indiceRandom);
        } else {
            String fraseLarga = "Sala " + pel.getTitulo() + "\n";
            str.append("~".repeat(fraseLarga.length()) + "\n");
            str.append("Lo siento " + esp.getNombre() + "\n");
            str.append(fraseLarga);
            str.append("COMPLETA\n");
            str.append("~".repeat(fraseLarga.length()) + "\n");
            System.out.println(str);
            return;
        }
        
        salaElegida.setAsientoVendido();
        boolean dineroSuficiente = esp.getDinero() >= this.valorEntrada;
        boolean mayorEdad = edadSuficiente(esp, pel);
        
        if (dineroSuficiente && mayorEdad) {
            // Cobrar
            this.vender(esp, pel);
            // Obteniendo la frase más larga
            String fraseLarga = String.format("%s paga su entrada de %.2f€ con %.2f€\n",  esp.getNombre(), getValorEntrada(), esp.getDinero());
            str.append("~".repeat(fraseLarga.length()) + "\n");
            // Sentar
            str.append("Boleto\n");
            str.append(fraseLarga);
            str.append(String.format("Vuelto: %.2f€\n", esp.getDinero()));

            salaElegida.setAsiento(esp, asientoEscogido);
            str.append(String.format("Asiento %s -> RESERVADO!\n", asientoEscogido));
            str.append("Para película: " + salaElegida.getPeliculaSala().getTitulo() + "\n");
            str.append(String.format("Se ha reservado con ID [%s]\n", esp.getIniciales()));
            str.append("~".repeat(fraseLarga.length()) + "\n");
        } else if (!mayorEdad) {
            String fraseLarga = " - Pelicula: " + pel.getTitulo();
            str.append("~".repeat(fraseLarga.length()) + "\n");
            str.append("Lo sentimos " + esp.getNombre() + "\n");
            str.append("Tu edad es: " + esp.getEdad() + " años\n");
            str.append(fraseLarga);
            str.append(" - Edad mínima: " + pel.getEdadMinima() + " años\n");
            str.append("~".repeat(fraseLarga.length()) + "\n");
        } else if (!dineroSuficiente) {
            String fraseLarga = esp.getNombre() + " no cuenta con dinero suficiente...\n";
            str.append("~".repeat(fraseLarga.length()) + "\n");
            str.append(fraseLarga);
            str.append(String.format("Solo tiene %.2f\n", esp.getDinero()));
            str.append(" - Valor entrada: " + getValorEntrada() + "\n");
            str.append("~".repeat(fraseLarga.length()) + "\n");
        }
        System.out.println(str);
    }


    // PELICULAS
    //// agregar pelicula al cine
    public void setPeliculasEstreno(Pelicula nombre) {
        peliculasEstreno.add(nombre);
    }
    // obtiene una pelicula aleatorea de la Pool, luego la quita e la lista y la retorna
    public Pelicula getPeliculasEstrenoPool() {
        Random alea = new Random();
        int randomInt = alea.nextInt(peliculasEstrenoPool.size());
        Pelicula peliculaReturn = peliculasEstrenoPool.get(randomInt);
        peliculasEstrenoPool.remove(randomInt);
        return peliculaReturn;
    }
    // remove

    // MÉTODOS
    //// Ver peliculas disponibles
    public void verCartelera() {
        for (Pelicula pelicula : peliculasEstreno) {
            System.out.println(pelicula);
        }
    }

    //// Comprobar edad
    private boolean edadSuficiente(Espectador esp, Pelicula pel) {
        return esp.getEdad() >= pel.getEdadMinima();
    }

    //// Comprobar saldo
    private boolean dineroSuficiente(Espectador esp) {
        return esp.getDinero() >= valorEntrada;
    }

    //// Vender entrada
    private void vender(Espectador esp, Pelicula pel) {

        if (dineroSuficiente(esp)) {
            esp.pagar(valorEntrada);
            this.acumulado += valorEntrada;
        }
        // System.out.println("~-".repeat(25));
    }


    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("\n");
        strB.append("Cine\n");
        strB.append(String.format("Valor de la entrada: %.2f€\n",valorEntrada));
        strB.append("\nCartelera:\n");
        for (Sala s : salas) {
            strB.append(s.getPeliculaSala()).append("\n");
        }
        strB.append("\n");
        strB.append("Salas:\n");
        for (Sala s : salas) {
            strB.append(s).append("\n");
        }
        strB.append(String.format("Total recaudado: %.2f€", acumulado));
        strB.append("\n");
        return strB.toString();
    }


}
