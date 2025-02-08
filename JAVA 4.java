/* APRENDIENDO JAVA
 * En JAVA 4 se mostrará como hacer diferentes condiciones como switches, bucles, etc.
 * Seguidamente se vera de manera breve los arrays.
 * 
 */


class Main
{
    public  static void main(String[] args)
    {
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
            break;

            case 3:
                System.out.println("Wednesday");
            break:
        
            default:
            System.out.println("Invalid.");
                break;


        }
        /*
         * Cada case representa un valor distinto de la variable, en este caso 'day'.
         * Cuando day es 1, el mensaje "Monday" se imprime. 
         * Si el valor de day fuera otro, corresponderia con el valor de day. Si el valor no fuera invalido, por ejemplo
         * fuera de rango o un valor de tipo no valido, entonces mostrará el mensaje default, siendo "Invalid." 
         * */
        


         //BUCLES


         // BUCLE WHILE
            while (condition) {
                //Cuerpo del bucle.
                //Se ejecuta mientras la condición sea true.
                //Ejemplo:
                int i = 0;
                while (i < 10) {
                    System.out.println("Iteración: " + i);
                    i++;
                }
            }
        
            // BUCLE DO-WHILE
            do {
                //Cuerpo del bucle.
                //Se ejecuta al menos una vez, después de evaluar la condición.
                //Ejemplo:
                int j = 0;
                do {
                    System.out.println("Iteración: " + j);
                    j++;
                } while (j < 10);
            } while (condition);

            //Bucle for
            for (int k = 0; k < 10; k++) {
                System.out.println("Iteración: " + k);
            }

            //Break  y Continue
            /*
             * Break: termina el bucle inmediatamente..
             * Continue: continua con la siguiente iteración del bucle...
             */
            // Ejemplo:
            for (int l = 0; l < 10; l++) {
                if (l == 5) {
                    break;
                }
                System.out.println("Iteración: " + l);
            }
            for (int m = 0; m < 10; m++) {
                if (m == 5) {
                    continue;
                }
                System.out.println("Iteración: " + m);
        
    }
}