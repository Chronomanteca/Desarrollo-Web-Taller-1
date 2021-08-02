package model;


public class Libro {

    private String titulo;
    private String descripcion;
    private Integer price;
    private Integer publicacion;
    private Integer paginas;

    public Libro() {
    }

    public Libro(String titulo, String descripcion, Integer price, Integer publicacion, Integer paginas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.price = price;
        this.publicacion = publicacion;
        this.paginas = paginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPublicacion(Integer publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return   "\""+titulo + '\"'+"\n"+
                "Sinopsis: \"" + descripcion + '\"' +"\n"+
                "Precio: $" + price +"\n"+
                "Año de publicacion: " + publicacion +"\n"+
                "Numero de paginas: " + paginas ;
    }


    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPublicacion() {
        return publicacion;
    }
}
