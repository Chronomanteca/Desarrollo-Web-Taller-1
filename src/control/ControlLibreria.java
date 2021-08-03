package control;
import model.*;

import java.util.*;

public class ControlLibreria {

    private Libro libros;
    private Autor autores;

    private HashMap<String, ArrayList<Libro>> registro = new HashMap<String, ArrayList<Libro>>();

    public ControlLibreria() {
    }

    public ControlLibreria(Libro libros, Autor autores, HashMap<String, ArrayList<Libro>> registro) {
        this.libros = libros;
        this.autores = autores;
        this.registro = registro;
    }

    public Libro getLibros() {
        return libros;
    }

    public void setLibros(Libro libros) {
        this.libros = libros;
    }

    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    public HashMap<String, ArrayList<Libro>> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<String, ArrayList<Libro>> registro) {
        this.registro = registro;
    }

    public Libro crearLibro(){
        Scanner input = new Scanner(System.in);
        String entrada;
        Integer valor;

        Libro lib = new Libro();

        System.out.println("AGREGAR LIBRO");
        do{
            System.out.println("Ingrese el titulo del libro");
            entrada = input.nextLine();
        }while(!verificarLongitudCadena(100,5,entrada));
        lib.setTitulo(entrada);

        do{
            System.out.println("Ingrese la descripcion del libro");
            entrada = input.nextLine();
        }while(!verificarLongitudCadena(200,0,entrada));
        lib.setDescripcion(entrada);

        do{
            System.out.println("Ingrese el precio del libro");
            valor = input.nextInt();
        }while(!verificarValor(valor, 10000, "pesos"));
        lib.setPrice(valor);

        do{
            System.out.println("Ingrese la fecha de publicacion del libro del libro");
            valor = input.nextInt();
        }while(!verificarFecha(valor));
        lib.setPublicacion(valor);

        do{
            System.out.println("Ingrese el numero de paginas del libro");
            valor = input.nextInt();
        }while(!verificarValor(valor, 1500, "paginas"));
        lib.setPaginas(valor);
        return lib;
    }

    public Autor crearAutor(){

        Libro l  = crearLibro();

        Scanner input = new Scanner(System.in);
        String entrada;
        Autor aut =  new Autor();

        System.out.println("Ingrese el nombre del autor");
        entrada = input.next();
        aut.setNombre(entrada);

        System.out.println("Ingrese el apellido del autor");
        entrada = input.next();
        aut.setApellido(entrada);

        if(this.registro.containsKey(aut.toString())){
            aut.setLibro(this.registro.get(aut.toString()));
        }

        aut.agregarLibro(l);

        return aut;
    }

    public boolean verificarFecha(Integer fecha){

        Integer actual = Calendar.getInstance().get(Calendar.YEAR);
        if(String.valueOf(fecha).length()==4&&fecha<actual){
            return true;
        }
        System.out.println("ERROR: la fecha ingresada no es valida\n");
        return false;
    }


    public boolean verificarValor(Integer precio, Integer maximo, String adjetivo){

        if(precio>maximo){
            return true;
        }
        System.out.println("ERROR: la cantidad de "+adjetivo+" debe ser mayor a "+maximo+"\n");
        return false;
    }

    public boolean verificarLongitudCadena(Integer maximo, Integer minimo, String cadena){

        if(cadena.length()>=minimo && cadena.length()<=maximo){
            return true;
        }
        System.out.println("ERROR: la entrada debe tener entre: "+minimo+" y "+maximo+"caracteres\n");
        return false;
    }


    public void agregarRegistro(Autor aut){

        this.registro.put(aut.toString(),aut.getLibro());
    }

    public void listarLibros(){

        for(Map.Entry<String,ArrayList<Libro>> m : this.registro.entrySet()){
            System.out.println("Autor: "+ m.getKey().toString());
            System.out.println("size: "+m.getValue().size());
            for(Libro l: m.getValue()){
                System.out.println( l.getTitulo());
            }
        }
    }

    public boolean buscarAutor(){

        Scanner input = new Scanner(System.in);
        Autor aut = new Autor();
        String entrada;

        System.out.println("\nIngrese el nombre completo del autor");
        entrada = input.nextLine();
        aut.setNombre(entrada);

        if(!this.registro.containsKey(entrada)){
            System.out.println("\nl autor ingresado no tiene titulos registrados\n");
            return false;
        }
        listarLibrosAutor(entrada);
        return true;
    }

    public void listarLibrosAutor(String aut){
            int i = 0;
            System.out.println("----------AUTOR----------\n"+ aut+"\n----------TITULOS----------");
            for(Libro l: this.registro.get(aut)){
                i++;
                System.out.println(i+"."+l.getTitulo());
            }
    }

    public boolean buscarLibro(String titulo){

        for(Map.Entry<String,ArrayList<Libro>> m : this.registro.entrySet()){
            for(Libro l: m.getValue()){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    System.out.println(l.toString());
                    return true;
                }
            }
        }
        return false;
    }

    public void detallar(){
        Scanner input = new Scanner(System.in);
        String entrada;

        System.out.println("\nIngrese el titulo del libro a buscar");
        entrada = input.nextLine();

        if(!buscarLibro(entrada)){
            System.out.println("\nNo se encontro el libro ingresado en los registros\n");
        }
    }

    public void ayuda(){
        System.out.println("\ncrear ------ permite crear un libro agregando la informacion basica del mismo"+"\n"+
                "detallar ------ permite obtener la informacion detallada de un libro especificado"+"\n"+
                "listar ------ despliega la lista de libros guardada en el registro de la libreria"+ "\n"+
                "salir ------ cierra el programa de la libreria");
    }


}
