package control;

/*
Clase ControlInterfaz.
---descripcion---
Clase que contiene mensajes basicos para imprimir en la consola
---parametros---
N.A
---metodos relevantes---
N.A
 */

public class ControlInterfaz {

    public void ayuda(){
        System.out.println("\ncrear ------ permite crear un libro agregando la informacion basica del mismo"+"\n"+
                "detallar ------ permite obtener la informacion detallada de un libro especificado"+"\n"+
                "listar ------ despliega la lista de libros guardada en el registro de la libreria"+ "\n"+
                "salir ------ cierra el programa de la libreria");
    }

    public void mensajeInicio(){
        System.out.println("\nEscriba un comando (escriba 'ayuda' para obtener informacion de los comandos)"+"\n"+
                "Comandos disponibles: \n crear \n listar \n detallar \n ayuda \n salir \n");
    }

    public void error(){
        System.out.println("El comando ingresado no pudo ser reconocido, intente nuevamente \n");
    }

    public void despedida(){
        System.out.println("Adios c:");
    }

}
