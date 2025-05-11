package Actividad_01;

//Excepción personalizada que se lanza cuando se intenta operar sobre una pila vacía
public class ExceptionIsEmpty extends Exception { 
    public ExceptionIsEmpty(String message) {
        super(message); // Llama al constructor de la clase base (Exception) con el mensaje recibido
    }
}
