package classes;

import java.util.ArrayList;

public class Sala {
    public String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int filasSala = 8;
    private int columnasSala = 9;
    //private int asientosDisponibles = filasSala * columnasSala;
    private int asientosVendidos = 0;
    private String ultimoAsientoVendido = "";
    private int cantidadMaxima = filasSala * columnasSala;
    private Asiento[][] asientos; // crear Asiento[][]
    private Pelicula peliculaSala;
    private ArrayList<Asiento> asientosDisponibles = new ArrayList<>(); // Probanto la clase Asiento
    private ArrayList<Asiento> asientosReservados = new ArrayList<>(); // Probanto la clase Asiento

    // CONSTRUCTOR
    public Sala() {
        asientos = this.crearSala();
    }

    // GETTERS & SETTERS
    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setFilaColumna(int x, int y) {
        this.columnasSala = x;
        this.filasSala = y;
        asientos = this.crearSala();
    }

    public void setAsientoVendido() {
        this.asientosVendidos += 1;
    }

    public int getAsientosVendidos() {
        return this.asientosVendidos;
    }

    // // GETTERS DE LISTAS
    public ArrayList<Asiento> getAsientosDisponibles() {
        return this.asientosDisponibles;
    }

    public ArrayList<Asiento> getAsientosReservados() {
        return asientosReservados;
    }

    public boolean getSalaLlena() {
        return this.asientosVendidos == cantidadMaxima;
    }

    public int getCantidadAsientos() {
        return this.columnasSala * this.filasSala;
    }

    public int getFilasSala() {
        return filasSala;
    }

    public int getColumnasSala() {
        return columnasSala;
    }

    // Singular -> Obtiene el asiento buscado por las coordenadas
    public Asiento getAsiento(int x, int y) {
        return this.asientos[y][x];
    }

    // public void setAsiento(String asiento, String inicial3digitos) {
    //     for (int i = 0; i < asientos.length; i++) {
    //         for (int j = 0; j < asientos[i].length; j++) {
    //             if (this.asientos[i][j] == asiento) {
    //                 String asientoID = "]" + inicial3digitos + "[";
    //                 this.ultimoAsientoVendido = asientos[i][j]; // Almaceno el valor antiguo. Deberia volar
    //                 this.asientos[i][j] = asientoID; // Asigno el nuevo valor. Deberia volar...
    //                 asientosDisponibles.remove(asiento); // Lo quita de la Pool. Deberia volar...
    //                 return;
    //             }
    //         }
    //     }
    // }

    // NUEVO METODO PARA SENTAR GENTE ////////////////////////////////////////////
    public void setAsiento(Espectador esp, Asiento as) {
        int x = as.getCoordenadaX();
        int y = as.getCoordenadaY();
        this.asientos[y][x].reservarAsiento(esp); // ubica el asiento
    }

    public String getUltimoAsientoVendido() {
        return this.ultimoAsientoVendido;
    }


    public Pelicula getPeliculaSala() {
        return peliculaSala;
    }

    public void setPeliculaSala(Pelicula peliculaSala) {
        this.peliculaSala = peliculaSala;
    }

    // IMPLEMENTANDO LOS ASIENTOS /////////////////////////////////////////////////////
    private Asiento [][] crearSala() {
        this.asientos = new Asiento[this.filasSala][this.columnasSala];
        this.asientosDisponibles.clear();
        String str = "";
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                str = String.format("[%d-%c]", (i + 1), alfabeto.charAt(j));
                Asiento a = new Asiento(str, i, j);
                this.asientos[i][j] = a; // Se agrega
                asientosDisponibles.add(a); // se agrega el Asiento al array de asientos
            }
        }
        return asientos;
    }



    @Override
    public String toString() {
        // Esta bien que en el toString, imprima la sala como matriz?? o deberia dejarlo como getSalas ??
        StringBuilder str = new StringBuilder("\n");
        str.append("Sala de película: ").append(peliculaSala == null ? "Sin pelicula asignada" : peliculaSala.getTitulo()).append("\n");

        for (int i = (asientos.length-1); i >= 0; i--) {
            for (Asiento asiento : asientos[i]) {
                str.append(asiento.getAsientoReservadoID());
            }
            str.append("\n");
        }
        return str.toString();
    }

    public String toStringCompleto() {
        // Esta bien que en el toString, imprima la sala como matriz?? o deberia dejarlo como getSalas ??
        StringBuilder str = new StringBuilder("\n");
        str.append("Sala de película: ").append(peliculaSala == null ? "Sin pelicula asignada" : peliculaSala.getTitulo()).append("\n");

        for (int i = (asientos.length-1); i >= 0; i--) {
            for (Asiento asiento : asientos[i]) {
                str.append(asiento.getAsientoReservadoID());
            }
            str.append("\n");
        }
        for (Asiento a : asientosDisponibles) {
            str.append(a).append("\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Sala sala1 = new Sala();
        sala1.setFilaColumna(2, 2);

        System.out.println(sala1);

        System.out.println(sala1.getAsientosVendidos());
        // System.out.println(sala1.getAsientosDisponibles()); // Retorna el ArrayList


    }
}
