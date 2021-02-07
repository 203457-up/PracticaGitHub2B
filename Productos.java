public class Productos {
    private int numero;
    private String nombre;
    private double precio;
    private double abono;

    public void setProducto(int numero, String nombre, double precio, double abono) {
        this.numero = numero;
        this.nombre = nombre;
        this.precio = precio;
        this.abono = abono;

    }

    public int getNumeroProducto() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Double abono() {
        return abono;
    }

}
