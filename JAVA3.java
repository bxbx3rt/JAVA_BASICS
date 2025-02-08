//EJERCITANDO JAVA - 3
// CONDICIONES IF/ELSE, SWITCH Y BUCLES Y VALORES EN VECTORES.

public class JAVA3 {

    public static void main(String[] args)
    {
        /* CONDICIONES
         * Las condiciones servirán para la continuidad de los if, else, bucles, etc. 
         * Estas condiciones pueden ser con valores normales (estáticos) y con variables con diferentes datos, haciendo diferentes comprobaciones.
         * Las condiciones para que se cumplan o no, se usarán operadores como ">, <, !=, ==, >=, <=".
         */

         // IF/ IF ELSE
         // La estructura es básicamente la misma que en C++.
         // if(condicion)
         if(20>18)
         System.out.println("20 es más grande que 18");
         //Como se puede observar, si es solo una línea, no neceistaremos el uso de corchetes. Si por algun casual hubieran mas lineas o para garatizar el correcto funcionamiento, emplearemos corchetes.
        if(20<18)
        {
        System.out.println("20 es más grande que 18");
        }else
        System.out.println("20 es más pequeño que 18");

        //Existe la sentencia else if, escribiendose el cuerpo de los if igual que en C++.
        
    }
}
