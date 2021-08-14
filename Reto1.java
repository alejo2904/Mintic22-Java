
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
        // Consumir el metodo read
        String datos = read();

        //  Convetir cadena en una lista 
        String[] lista = datos.split(" ");

        // Parsear los valores de string a double
        double masa = Double.parseDouble(lista[0]);
        double altura = Double.parseDouble(lista[1]);
        int edad = Integer.parseInt(lista[2]);
        String riesgo = "";

        // calculo para indice de masa
        double indiceMasaCorporal = masa / (altura * altura);

        /**
         * Validar los 3 tipos de restriccion validar masa validar altura
         * validar edad
         */
        if (masa >= 0 && masa <= 150) {
            if (altura >= 0.1 && altura <= 2.5) {
                if (edad >= 0 && edad <= 110) {

                    /**
                     * Comparar tabla de riesgos cargar variable riesgo
                     */
                    if (edad <= 45) {
                        if (indiceMasaCorporal <= 22) {
                            riesgo = "Bajo";
                        } else {
                            riesgo = "Medio";
                        }
                    } else {
                        if (indiceMasaCorporal <= 22) {
                            riesgo = "Medio";
                        } else {
                            riesgo = "Alto";
                        }
                    }
                    
                    //   Redondear a dos dijitos el Indice de Masa
                    String IMC = String.format("%.2f", indiceMasaCorporal);
                    System.out.println(IMC+" "+riesgo); //  Mensaje de salida 

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
