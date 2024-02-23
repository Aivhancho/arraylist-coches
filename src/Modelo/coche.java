package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class coche {
    Scanner sc = new Scanner(System.in);
    private String matricula;
    private String marca;
    private String modelo;
    private int Km;
    static ArrayList<coche> coches = new ArrayList<>();
    public int getKm() {
        return Km;
    }

    public void setKm(int Km) {
        this.Km = Km;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void leerCoches(){

        //Declaración de variables para leer los datos de los coches
        String matricula;
        String marca;
        String modelo;
        int Km;

        //Variable auxiliar que contendrá la referencia a cada coche nuevo.
        coche aux;
        int i, N;

        //se pide por teclado el número de coches a leer
        do {
            System.out.print("Número de coches? ");
            N = sc.nextInt();
        } while (N < 0);
        sc.nextLine(); //limpiar el intro

        //lectura de N coches
        for (i = 1; i <= N; i++) {
            //leer datos de cada coche
            System.out.println("Coche " + i);
            System.out.print("Matrícula: ");
            matricula = sc.nextLine();
            System.out.print("Marca: ");
            marca = sc.nextLine();
            System.out.print("Modelo: ");
            modelo = sc.nextLine();
            System.out.print("Número de Kilómetros: ");
            Km = sc.nextInt();
            sc.nextLine(); //limpiar el intro

            aux = new coche(); //Se crea un objeto Coche y se asigna su referencia a aux

            //se asignan valores a los atributos del nuevo objeto
            aux.setMatricula(matricula);
            aux.setMarca(marca);
            aux.setModelo(modelo);
            aux.setKm(Km);

            //se añade el objeto al final del array
            coches.add(aux);
        }
    } //fin método leerCoches()
    //Método para mostrar todos los coches
    public void mostrarCoches(){
        for(int i = 0; i< coches.size(); i++)
            System.out.println(coches.get(i));  //se invoca el método toString de la clase Coche
    }
    public void mostrarPorMarca(){
        String marca;
        System.out.print("Introduce marca: ");
        marca = sc.nextLine();
        System.out.println("Coches de la marca " + marca);
        for(int i = 0; i < coches.size(); i++){
            if(coches.get(i).getMarca().equalsIgnoreCase(marca))
                System.out.println(coches.get(i));
        }
    }
    //Método para mostrar todos los coches con un número de Km inferior
    //al número de Km que se pide por teclado
    public void mostrarPorKm(){
        int Km;
        System.out.print("Introduce número de kilómetros: ");
        Km = sc.nextInt();
        System.out.println("Coches con menos de " + Km + " Km");
        for(int i = 0; i < coches.size(); i++){
            if(coches.get(i).getKm() < Km)
                System.out.println(coches.get(i));
        }
    }
    //Método que devuelve el Coche con mayor número de Km
    public coche mostrarMayorKm(){
        coche mayor = coches.get(0);
        for(int i = 0; i < coches.size(); i++){
            if(coches.get(i).getKm() > mayor.getKm())
                mayor = coches.get(i);
        }
        return mayor;
    }
    //Método que muestra los coches ordenados por número de Km de menor a mayor
    public void mostrarOrdenadosPorKm(){
        int i, j;
        coche aux;
        for(i = 0; i < coches.size()-1; i++)
            for(j=0; j < coches.size()-i-1; j++)
                if(coches.get(j+1).getKm() < coches.get(j).getKm()){
                    aux = coches.get(j+1);
                    coches.set(j+1, coches.get(j));
                    coches.set(j, aux);
                }
        mostrarCoches();
    }
} //fin de la clase principal
