//EJERCITANDO JAVA - 2
// TRABAJANDO CON LAS VARIABLES Y EMPLEANDO OPERADORES

public class JAVA2 {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        /* FUNCION DE ENSANCHAMIENTO
         *  Esta función nos sirve para cambiar el tipo de dato de una variable. Por ejemplo, si tenemos un int y queremos pasarlo a un numero decimal, deberemos emplear un double o float.
         *  Sirve de ejemplo la siguiente funcion:
         */
        int NumPrueba = 9;
        System.out.println(NumPrueba); // Muestra 9
        double DecPrueba = NumPrueba;
        System.out.println(DecPrueba); // Muestra 9.0

        /* FUNCION DE ESTRECHAMIENTO
         *  Esta función realiza el trabajo contrario a la funcion de ensanchamiento. Cambia el tipo de dato por uno más pequeño, pasando de un decimal a un entero (por ejemplo.)
         *  Cambia simplemente una cosa en diferencia a la otra funcion: Hay que indicar a que tipo queremos cambiarlo, sino el cambio no es posible.
         *  Sirve de ejemplo la siguiente función:
         */
        double DecPrueba1 = 8.9;
        System.out.println(DecPrueba1); // Muestra 8.9
        int NumPrueba1 = (int) DecPrueba1; //Convertimos el valor de manera manual, ya que si no emplearamos el (int) no indicariamos el valor que queremos cambiar y no funcionaria.
        System.out.println(NumPrueba1); // Muestra 8
        // La funcion de estrechamiento sirve para cambiar el valor, podemos realizar el ejemplo primero con estrechamento y saldria lo mismo:
        int NumPrueba2 = 9;
        System.out.println(NumPrueba2); // Muestra 9
        double DecPrueba2 = (double) NumPrueba2;
        System.out.println(DecPrueba2); // Muestra 9.0


        /* OPERADORES
         *  Existen operadores para realizar operaciones:
         *  + ADICIÓN: AÑADE DOS VALORES.
         *  - SUSTRACCIÓN: SUSTRAE UN VALOR DE OTRO.
         *  * MULTIPLICACIÓN: MULTIPLICA DOS VALORES.
         *  / DIVISIÓN: DIVIDE UN VALOR POR OTRO.
         *  e EXPONENTE: HACE COMO EXP O 10^.
         *  % MODULO: DA COMO VALOR DE RETORNO EL RESTO DE LA DIVISIÓN.
         *  ++ INCREMENTO: INCREMENTA EL VALOR EN 1.
         *  -- DECREMENTO: DECREMENTA EL VALOR EN 1.
         */

         //Tamaño de los strings
         String txt = "HOLA ROBERTO";
         System.out.println("El tamaño del archivo es: " + txt.length()); // .length indica el tamaño del string (como en c++).
         //Display de los strings
         System.out.println(txt.toUpperCase()); // Muestra el contenido de la variable txt pero en mayúsculas.
         System.out.println(txt.toLowerCase()); // Muestra el contenido de la variable txt pero en minúsculas.
         // Encontrar una palabra en un string
         String txt2 = "Soy Roberto y tengo 20 años, soy ingeniero.";
         System.out.println(txt2.indexOf("ingeniero")); // Devuelve el valor (la posicion) donde se encuentre la palabra buscada en el string. [Empezando desde 0]
         //Concatenación de strings
         System.out.println(txt + ", " + txt2);
         System.out.println(txt.concat(txt2));
         /*
          * Hay que prestar atencion que con el operador + con valores numericos suma, pero con valores de string u otros, concatena.
          * Además hay que tener en cuenta que como el texto viene introducido por "" si debieramos emplear comillas simples deberemos:
          * It's alright (incorrecto), It\'s alright (correcto).
          * El caracter \\ se llama barra (saldrá solo '\').
          */

          /* Método MATH
           *  Sirve para emplear diferentes acciones sobre las variables numéricas.
           * 
           */
          Math.max(5,10); // Saca el valor máximo de x e y.
          Math.min(5,10); // Saca el valor mínimo entre x e y.
          Math.sqrt(64); // Saca la raíz cuadrada de x.
          Math.abs(-4.7); // Saca el valor absoluto de x.
          Math.random(); //Saca un valor aleatorio desde 0 (incluido) hasta 1 (excluido).
          // Si quisieramos sacar un valor aleatorio desde 0 a otro numero hariamos:
          int randomNum = (int)(Math.random() * 101); //de 0 a 100

          /* Métodos BOOLEANOS
           *  Si nosotros establecemos un valor de x y de y, podemos hacer que muestre verdadero o falso, o yes o no, etc si la condicion de este print se cumple o no
           */
          int x= 10;
          int y = 9;
          System.out.println(x > y);
          System.out.println(x < y);
          System.out.println(x == 10);
          System.out.println(10==15);
      


    }
}
