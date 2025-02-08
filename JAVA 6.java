/* JAVA 6 - MÉTODOS
 *  Vamos a ver como se definen los metodos, los parámetros, los argumentos, retornos, recursividad y sobrecarga de funciones.
 * Suceden de igual manera que en C++.
 */


 

 class Main
{
    public static void main(String[] args)
    {
        static void factorial()
        {
            int result = 1;
            for (int i = 1; i <= 5; i++) {
                result *= i;
            }
            System.out.println("El factorial de 5 es: " + result);
        }
        static void sumaConRetorno(int d, int c)
        {
            return d + c; // RETORNO
        }

        static void suma(int a, int b) // PARAMETROS
        {
            System.out.println("La suma de " + a + " y " + b + " es: " + (a + b));
        }
     
        suma(); // ARGUMENTOS || Error: No se puede llamar a un método sin argumentos si la definition tiene parámetros.
        suma(5, 10); // ARGUMENTOS
        
        /* ¿Qué es la sobrecarga de funciones?
         *  Imaginemos que tenemos dos funciones con el mismo nombre pero con diferentes parámetros.
         *  En este caso, la sobrecarga de funciones nos permite utilizar ambas funciones sin tener que cambiar el nombre de la función.
         *  Si por ejemplo, una funcion tiene parametros enteros (int) y otra tiene parametros double (double), ambas funciones podrían ser llamadas
         * por ejemplo suma.
         * Si yo introduzco suma(1,2) estouy llamado a la funcion suma (int) y otra tiene parametros double (1.2, 2.1) para la función double.
         */

    }
}