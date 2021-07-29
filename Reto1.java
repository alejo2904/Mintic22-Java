
import java.util.Scanner;

/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
 */
class Reto1 {

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
        // Declara variables
        double m, a; // Variables de masa y altura
        int edad; // Variable de edad
        String riesgo = ""; // Variable de Nivel de Riesgo

        // Consumir el metodo read
        String dat = read();

        //  Convetir cadena en una lista      
        String[] list = dat.split(" ");

        // Parsear los valores de string a double        
        m = Double.parseDouble(list[0]);
        a = Double.parseDouble(list[1]);
        edad = Integer.parseInt(list[2]);

        // calculo para indice de masa        
        double indiceM = m / (a * a);
        /**
         * Validar los 3 tipos de restriccion validar masa validar altura
         * validar edad
         */
        if (m > 0 && m < 150) {
            if (a > 0.1 && a < 2.5) {
                if (edad > 0 && edad < 110) {

                    /**
                     * Comparar tabla de riesgos cargar variable riesgo
                     */
                    if (edad <= 45) {
                        if (indiceM <= 22) {
                            riesgo = "Bajo";
                        } else if (indiceM > 22) {
                            riesgo = "Medio";
                        }
                    } else if (edad > 45) {
                        if (indiceM <= 22) {
                            riesgo = "Medio";
                        } else if (indiceM > 22) {
                            riesgo = "Alto";
                        }
                    }

                    //   Redondear a dos dijitos el Indice de Masa                  
                    String red = String.format("%.2f", indiceM);
                    //  Mensaje de salida                   
                    System.out.println(red + " " + riesgo);

                /**
                * En caso de fallar una de las 3 condiciones iniciales
                * (if de masa, altura o edad)
                * Se imprime mensaje "ERROR"
                */
                } else {
                    System.out.println("ERROR");
                }
            } else {
                System.out.println("ERROR");
            }
        } else {
            System.out.println("ERROR");
        }
    }
}
