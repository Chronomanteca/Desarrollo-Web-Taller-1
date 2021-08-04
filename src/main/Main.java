package main;

import control.ControlInterfaz;
import control.ControlLibreria;
import java.util.Calendar;
import java.util.Scanner;

/*
  Autor: Daniel Santiago Morales Alvarado
*/
public class Main {

   public static void main(String[] args) {
       ControlLibreria control = new ControlLibreria();
       ControlInterfaz controlI = new ControlInterfaz();
       Scanner input = new Scanner(System.in);
       String entrada;
       do{
           controlI.mensajeInicio();
           entrada = input.next();
           switch (entrada) {
               case "crear" -> control.agregarRegistro(control.crearAutor());
               case "listar" -> control.buscarAutor();
               case "detallar" -> control.detallar();
               case "ayuda" -> controlI.ayuda();
               case "salir" -> controlI.despedida();
               default -> controlI.error();
           }
       }while(!entrada.equalsIgnoreCase("salir"));



   }
}
