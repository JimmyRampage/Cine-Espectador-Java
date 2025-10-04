package classes;

import java.util.ArrayList;

public class Asiento {

    // ATRIBUTOS
    protected String asientoOriginal;
    protected String asientoReservadoID;
    protected Espectador espectador;
    // // Preserva la posicion en la matriz
    protected int coordenadaX;
    protected int coordenadaY;
    // // Atributo disponibilidad
    private Boolean isDisponible; // puede tener el mismo nombre que el metodo?

    // // Valores default
    private final Boolean DF_DISPONIBILIDAD = true;

    // CONSTRUCTOR
    public Asiento(String asientoNuevo, int x, int y) {
        this.asientoOriginal = asientoNuevo;
        setCoordenadas(x, y);
        this.isDisponible = DF_DISPONIBILIDAD;
    }

    // GETTERS Y SETTERS
    // // Cordenadas
    public int getCoordenadaX() {
        return coordenadaX;
    }
    public int getCoordenadaY() {
        return coordenadaY;
    }
    private void setCoordenadas(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    // Devuelve el valor del asiento original [%s-%d]
    public String getAsientoOriginal() {
        return asientoOriginal;
    }

    public void setAsientoOriginal(String asientoOriginal) {
        this.asientoOriginal = asientoOriginal;
    }

    // Devuelve el valor del ID
    public String getAsientoReservadoID() {
        return asientoReservadoID == null? asientoOriginal : asientoReservadoID;
    }

    public void setAsientoReservadoID(String asientoReservadoID) {
        this.asientoReservadoID = asientoReservadoID;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    // MÉTODOS
    // // Reservar asiento
    /**
     * @param 
     */
    public void reservarAsiento(Espectador esp) {
        if (isDisponible()) {
            this.isDisponible = false;
            this.asientoReservadoID = "]" + esp.getIniciales() + "[";
            this.espectador = esp;
            System.out.println("Asiento " + asientoOriginal  + " reservado!");
            System.out.println("Asiento con ID:  " + asientoReservadoID);
        } else {
            System.out.println("Lo sentimos, el asiento " + asientoOriginal + " no esta disponible");
        }
    }
    // // Liberar asiento
    public void liberarAsiento() {
        if (!isDisponible()) {
            System.out.println("Asiento con ID: " + asientoReservadoID);
            System.out.println("Ubicación: " + asientoOriginal);
            this.espectador = null;
            this.isDisponible = true;
            this.asientoReservadoID = asientoOriginal;
            System.out.println("Liberado!");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n");
        str.append("Asiento numero " + asientoOriginal + "\n");
        str.append(" - Disponible: " + (isDisponible()? "Sí" : "No") + "\n");
        if (!isDisponible()) {
            str.append("Reservado con ID: " + getAsientoReservadoID() + "\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // Creando asientos
        ArrayList<Asiento> asientos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String seatID = String.format("[%d-%d]", i, j);
                asientos.add(new Asiento(seatID, i, j));
            }
        }
        System.out.println(asientos);
    }
}
