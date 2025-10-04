package classes;

import java.util.ArrayList;
import java.util.Random;

public class Espectador {

    private String nombre;
    private String iniciales;
    private int edad;
    private double dinero;
    private ArrayList<String> nombres = new ArrayList<>();
    private String asiento = null;

    public Espectador() {
        this.cargarNombres();
        this.asignarNombre();
        this.asignarEdad();
        this.asignarDinero();
        this.asignarIniciales();
    }
    
    // GETTER & SETTER
    
    //// Nombres
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //// Edad
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //// Dinero
    public double getDinero() {
        return dinero;
    }
    
    public void setDinero(double dinero) {
        this.dinero += dinero;
    }

    //// asiento
    public String getAsiento() {
        return this.asiento;
    }

    public void setAsiento(String a) {
        this.asiento = a;
    }
    
    //// Nombres
    public ArrayList<String> getNombres() {
        return nombres;
    }
    
    public void addNombres(String nombre) {
        nombres.add(nombre);
    }
    
    public void removeNombres(String nombre) {
        nombres.remove(nombre);
    }

    public String getIniciales() {
        return this.iniciales;
    }

    // MÉTODODS
    //// Cargar nombres
    private void cargarNombres() {
        nombres.add("Jimmy");
        nombres.add("Mara");
        nombres.add("Ikigai");
        nombres.add("Manuel");
        nombres.add("Luisa");
        nombres.add("Camila");
        nombres.add("Felipe");
        nombres.add("Vane");
        nombres.add("Bildad");
    }
    //// Asignar nombre aleatorio
    private void asignarNombre() {
        Random alea = new Random();
        int numeroRandom = alea.nextInt(nombres.size());
        this.nombre = this.nombres.get(numeroRandom);
    }

    //// Asignar edad aleatoria
    private void asignarEdad() {
        Random alea = new Random();
        int numeroRandom = alea.nextInt(10, 60);
        this.edad = numeroRandom;
    }

    //// Asignar dinero aleatorio
    private void asignarDinero() {
        Random alea = new Random();
        double numeroRandom = alea.nextDouble(0, 100);
        this.dinero =  Math.round(numeroRandom*100.00)/100.00;
    }

    //// AsignarIniciales
    private void asignarIniciales() {
        this.iniciales = Character.toString((this.nombre.charAt(0))) + this.getEdad();
    }

    //// pagar
    public double pagar(double monto){
        this.dinero -= monto;
        return this.getDinero();
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n");
        str.append("Espectador: " + nombre + "\n");
        str.append("\t  - Id: " + iniciales + "\n");
        str.append("\t  - Edad: " + edad + "\n");
        str.append(String.format("\t  - Dispone de: %.2f€\n", dinero));
        return str.toString();
    }

    public static void main(String[] args) {
        Espectador e1 = new Espectador();
        Espectador e2 = new Espectador();
        Espectador e3 = new Espectador();
        Espectador e4 = new Espectador();
        Espectador e5 = new Espectador();
        Espectador e6 = new Espectador();
        Espectador e7 = new Espectador();
        Espectador e8 = new Espectador();
        Espectador e9 = new Espectador();
        Espectador e0 = new Espectador();
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
        System.out.println(e6);
        System.out.println(e7);
        System.out.println(e8);
        System.out.println(e9);
        System.out.println(e0);

    }
}
