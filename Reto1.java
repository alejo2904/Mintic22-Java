import java.util.Scanner;
/*
* Recomendaciones Generales:
*
*    -> El método run() funcionará como nuestro método principal
*    -> No declarar objetos de tipo Scanner, utilizar el método read() para solicitar datos al usuario.
*    -> Si requiere utilizar varias clases, estas NO deben ser tipo public.
*/
class Reto1{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        String datos = read();
        
        String[] lista = datos.split(" ");
        
        double masa = Double.parseDouble(lista[0]);
        double altura = Double.parseDouble(lista[1]);
        int edad = Integer.parseInt(lista[2]);
        String riesgo = "";
        
        double indiceMasa = masa / (altura * altura);
        
        if (masa > 0 && masa < 150) {
            if (altura > 0.1 && altura < 2.5) {
                if (edad > 0 && edad < 110) {
                    
                    if (edad <= 45) {
                        if (indiceMasa <= 22) {
                            riesgo = "Bajo";
                        } else if(indiceMasa > 22){
                            riesgo = "Medio";
                        }
                    } else if(edad > 45) {
                        if (indiceMasa <= 22) {
                            riesgo = "Medio";
                        } else if(indiceMasa > 22){
                            riesgo = "Alto";
                        }                   
                    }
                    String redondear = String.format("%.2f", indiceMasa);
                    String mensaje = redondear +" "+ riesgo;
                    
                    System.out.println(mensaje);
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
