package reto2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author yeiimaccdev
 */
public class Reto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String operacion = leer.nextLine();
        String productoCadena = leer.nextLine();
        String[] lista = productoCadena.split(" ");

        int codigo = Integer.parseInt(lista[0]);
        String nombre = lista[1];
        double precio = Double.parseDouble(lista[2]);
        int inventario = Integer.parseInt(lista[3]);

        Producto producto = new Producto(codigo, nombre, precio, inventario);
        BaseDatosProductos bdProductos = new BaseDatosProductos();

        if (!baseProductos.verificarExistencia(producto) && operacion.equals("AGREGAR")) { //Validacion de accion y verificar existencia
            baseProductos.agregar(producto);
            baseProductos.informes();

        } else if (baseProductos.verificarExistencia(producto) && operacion.equals("ACTUALIZAR")) {//Validacion de accion y verificar existencia
            baseProductos.actualizar(producto);
            baseProductos.informes();

        } else if (baseProductos.verificarExistencia(producto) && operacion.equals("BORRAR")) {//Validacion de accion y verificar existencia
            baseProductos.borrar(producto);
            baseProductos.informes();
        } else {//Validacion en caso de error
            System.out.println("ERROR");
        }
    }
       // fin main
} // Fin clase reto2

class Producto {

    //Atributos
    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    // constructor 
    public Producto() {

    }

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
}// Fin clase producto

class BaseDatosProductos {

    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    // Constructor
    public BaseDatosProductos() {
        listaProductos.put(1, new Producto(1, "Manzanas", 8000, 65));
        listaProductos.put(2, new Producto(2, "Limones", 2300, 15));
        listaProductos.put(3, new Producto(3, "Granadilla", 2500, 38));
        listaProductos.put(4, new Producto(4, "Arandanos", 9300, 55));
        listaProductos.put(5, new Producto(5, "Tomates", 2100, 42));
        listaProductos.put(6, new Producto(6, "Fresas", 4100, 3));
        listaProductos.put(7, new Producto(7, "Helado", 4500, 41));
        listaProductos.put(8, new Producto(8, "Galletas", 500, 8));
        listaProductos.put(9, new Producto(9, "Chocolates", 3500, 806));
        listaProductos.put(10, new Producto(10, "Jamon", 15000, 10));
    }

    public boolean verificarExistencia(Producto p) {
        return listaProductos.containsKey(p.getCodigo()); // true - false
    }

    public void agregar(Producto p) {
        listaProductos.put(p.getCodigo(), p);
    }

    public void actualizar(Producto p) {
        listaProductos.replace(p.getCodigo(), p);
    }

    public void borrar(Producto p) {
        listaProductos.remove(p.getCodigo());
    }

    public void generarInforme() {
        String nombreMayor = productoMayor();
        String nombreMenor = productoMenor();
        String promedio = promedio();
        String total = total();
        System.out.println(nombreMayor + " " + nombreMenor + " " + promedio + " " + total);
    }

    private String productoMayor() {
        String nombre = "";
        double precioAux = 0;
        for (Producto p : listaProductos.values()) {
            if (p.getPrecio() > precioAux) {
                nombre = p.getNombre();
                precioAux = p.getPrecio();
            }
        }
        return nombre;
    }

    private String productoMenor() {
        String nombre = "";
        double precioAux = listaProductos.values().iterator().next().getPrecio();
        for (Producto p : listaProductos.values()) {
            if (p.getPrecio() < precioAux) {
                nombre = p.getNombre();
                precioAux = p.getPrecio();
            }
        }
        return nombre;
    }

    private String promedio() {
        double suma = 0;
        double resultado = 0;
        for (Producto p : listaProductos.values()) {
            suma += p.getPrecio();
        }
        resultado = suma / listaProductos.size();
        return String.format("%.1f", resultado);
    }

    private String total() {
        double suma = 0;
        double resultado = 0;
        for (Producto p : listaProductos.values()) {
            suma = p.getPrecio() * p.getInventario();
            resultado += suma;
        }
        return String.format("%.1f", resultado);
    }

} //fin de la clase BaseDatosProductos 
