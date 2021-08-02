package main;

import control.ControlLibreria;
import java.util.Calendar;
import java.util.Scanner;

/*
  Autor: Daniel Santiago Morales Alvarado
*/
public class Main {

   public static void main(String[] args) {
       ControlLibreria control = new ControlLibreria();
       Scanner input = new Scanner(System.in);
       String entrada;
       do{
           System.out.println("Ingrese un comando (escriba 'ayuda' para obtener informacion de los comandos)");
           entrada = input.next();
           switch (entrada) {
               case "crear" -> control.agregarRegistro(control.crearAutor());
               case "listar" -> control.buscarAutor();
               case "detallar" -> control.detallar();
           }
       }while(!entrada.equalsIgnoreCase("salir"));
       System.out.println("Adios c:");

   }
}
