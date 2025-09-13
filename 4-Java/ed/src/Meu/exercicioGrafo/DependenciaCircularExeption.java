package Meu.exercicioGrafo;

public class DependenciaCircularExeption extends RuntimeException {
    public DependenciaCircularExeption(String message) {
        super(message);
    }
}
