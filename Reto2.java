import java.util.HashMap;
import java.util.Scanner;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
 */
/**
 * Clase principal para el Reto2
 */
class Reto2 {

    /**
     * Este debe ser el único objeto de tipo Scanner en el código
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     *
     * @return Lectura de la siguiente linea del teclado
     */
    public String read() {
        return this.scanner.nextLine();
    }

    /**
     * método principal
     */
    public void run() {

        /**
         * Consumir el metodo read para almacenar datos
         */
        String accion = read();
        String product = read();
        String[] listadDatos = product.split(" ");

        Producto producto = new Producto(Integer.parseInt(listadDatos[0]), listadDatos[1],
                Double.parseDouble(listadDatos[2]), Integer.parseInt(listadDatos[3])); 
        BaseDatosProductos baseProductos = new BaseDatosProductos(); 

        if (!baseProductos.verificarExistencia(producto) && accion.equals("AGREGAR")) { 
            baseProductos.agregar(producto);
            baseProductos.informe();

        } else if (baseProductos.verificarExistencia(producto) && accion.equals("ACTUALIZAR")) {
            baseProductos.actualizar(producto);
            baseProductos.informe();

        } else if (baseProductos.verificarExistencia(producto) && accion.equals("BORRAR")) {
            baseProductos.borrar(producto);
            baseProductos.informe();
        } else {
            System.out.println("ERROR");
        }
    }
}

/**
 * Clase para producto
 */
class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    
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
}

/**
 * Clase BaseDatosProductos
 */
class BaseDatosProductos {

    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

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

    public boolean verificarExistencia(Producto producto) {
        return listaProductos.containsKey(producto.getCodigo());
    }

    public void agregar(Producto producto) {
        listaProductos.put(producto.getCodigo(), producto);
    }

    public void actualizar(Producto producto) {
        listaProductos.replace(producto.getCodigo(), producto);
    }

    public void borrar(Producto producto) {
        listaProductos.remove(producto.getCodigo());
    }

    public void informe() {
        String nombreMayor = productoMayor();
        String nombreMenor = productoMenor();
        String promedio = promedio();
        String total = total();
        System.out.println(nombreMayor + " " + nombreMenor + " " + promedio + " " + total);
    }

    private String productoMayor() {
        String nombre = "";
        double precioAuxiliar = 0;
        for (Producto productoItems : listaProductos.values()) {
            if (productoItems.getPrecio() > precioAuxiliar) {
                nombre = productoItems.getNombre();
                precioAuxiliar = productoItems.getPrecio();
            }
        }
        return nombre;
    }

    private String productoMenor() {
        String nombre = "";
        double Auxiliar = listaProductos.values().iterator().next().getPrecio();
        for (Producto productoItems : listaProductos.values()) {
            if (productoItems.getPrecio() < Auxiliar) {
                nombre = productoItems.getNombre();
                Auxiliar = productoItems.getPrecio();
            }
        }
        return nombre;
    }

    private String promedio() {
        double acumular = 0;
        double res = 0;
        for (Producto productoItems : listaProductos.values()) {
            acumular += productoItems.getPrecio();
        }
        res = acumular / listaProductos.size();
        return String.format("%.1f", res);
    }

    private String total() {
        double acumular = 0;
        double res = 0;
        for (Producto productoItems : listaProductos.values()) {
            acumular = productoItems.getPrecio() * productoItems.getInventario();
            res += acumular;
        }
        return String.format("%.1f", res);
    }
}
