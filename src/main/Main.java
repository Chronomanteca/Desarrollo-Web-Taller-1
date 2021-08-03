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
           System.out.println("\nEscriba un comando (escriba 'ayuda' para obtener informacion de los comandos)"+"\n"+
                   "Comandos disponibles: \n crear \n listar \n detallar \n ayuda \n salir \n");
           entrada = input.next();
           switch (entrada) {
               case "crear" -> control.agregarRegistro(control.crearAutor());
               case "listar" -> control.buscarAutor();
               case "detallar" -> control.detallar();
               case "ayuda" -> control.ayuda();
               default -> System.out.println("El comando ingresado no pudo ser reconocido, intente nuevamente \n");
           }
       }while(!entrada.equalsIgnoreCase("salir"));
       System.out.println("Adios c:");

   }
}
