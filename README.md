# Simulador de Cine en Java

Este proyecto es una aplicación de consola desarrollada en Java que simula el funcionamiento de un cine. El objetivo principal es practicar y demostrar conceptos de **Programación Orientada a Objetos (POO)**, como la creación de clases, la encapsulación, la herencia y la interacción entre objetos.

La simulación consiste en crear un cine con varias salas, asignarles películas y luego procesar la llegada de espectadores que intentan comprar una entrada y ocupar un asiento.

## ✨ Características

- **Modelado de Clases:** Representación de las entidades principales de un cine: `Cine`, `Sala`, `Pelicula`, `Espectador` y `Asiento`.
- **Asignación Dinámica:** Las películas se asignan a las salas de forma aleatoria desde una lista de estrenos disponibles.
- **Reserva de Asientos:** Los espectadores intentan reservar un asiento de forma aleatoria en una sala.
- **Lógica de Validación:** El sistema comprueba automáticamente si un espectador cumple con los requisitos para ver la película:
  - **Edad mínima:** Verifica si el espectador tiene la edad requerida para la película.
  - **Dinero suficiente:** Comprueba si el espectador puede pagar el valor de la entrada.
  - **Disponibilidad de asientos:** Asegura que el asiento seleccionado no esté ya ocupado.
- **Visualización en Consola:** Muestra el estado de las salas, los asientos ocupados y el resultado de cada intento de reserva.

## 🛠️ Tecnologías Utilizadas

- **Java:** El proyecto está escrito puramente en Java, sin frameworks externos.

## 📋 Prerrequisitos

Antes de empezar, asegúrate de tener instalado lo siguiente:

- **JDK 17** o superior.

## 🔧 ¿Cómo funciona?

El flujo principal se define en el método `main` de la clase `App.java`:

1. Se instancia un objeto `Cine`.
2. Se crean varias películas (`Pelicula`) y se añaden a la cartelera del cine.
3. Se crean las salas (`Sala`) y se asocian al cine.
4. A cada sala se le asigna una película de la cartelera.
5. Se crean múltiples espectadores (`Espectador`) con edad y dinero generados aleatoriamente.
6. Se inicia un bucle donde cada espectador intenta reservar un asiento en una sala. El método `reservarEspectador` de la clase `Cine` se encarga de toda la lógica de validación.
7. Finalmente, se imprime el estado final del cine, mostrando las salas con sus asientos ocupados y el total recaudado.
