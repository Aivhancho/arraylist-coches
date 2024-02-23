import java.util.ArrayList;
import java.util.Scanner;
import Modelo.coche;
public class Main {
    static Scanner sc = new Scanner(System.in);

    //Se crea un ArrayList para guardar objetos de tipo Coche.
    static ArrayList<coche> coches = new ArrayList<>();
    public static void main(String[] args) {
        coche coche1 = new coche();
        coche1.leerCoches();
        System.out.println("\nCoches introducidos:");
        coche1.mostrarCoches();
        coche1.mostrarPorMarca();
        coche1.mostrarPorKm();
        System.out.println("\nCoche con mayor número de Km: " + coche1.mostrarMayorKm());
        System.out.println("\nCoches ordenados de menor a mayor número de Km");
        coche1.mostrarOrdenadosPorKm();
    }
} //fin método main

    //Método para leer coches e introducirlos en el array