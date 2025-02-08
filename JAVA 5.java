/* JAVA 5 - ARRAYS
 *  Vamos a ver cómo se crean, inicializan y manipulan arrays en Java.
 */

class Main
{
    public static void main(String[] args)
    {
        // Creación de un array de enteros
        int[] numbers = new int[5];

        // Inicialización de valores en el array
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Recorrer un array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Valor en la posición " + i + " es: " + numbers[i]);
        }
        
        // Array vacío
        int[] emptyArray = new int[0];
        System.out.println("Array vacío: " + java.util.Arrays.toString(emptyArray));
        
        // Array con valores predefinidos
        int[] predefinedArray = { 1, 2, 3, 4, 5 };
        System.out.println("Array predefinido: " + java.util.Arrays.toString(predefinedArray));
        
        // Array con valores de diferentes tipos
        String[] stringArray = { "Uno", "Dos", "Tres", "Cuatro", "Cinco" };
        System.out.println("Array de strings: " + java.util.Arrays.toString(stringArray));
        
        // Array con valores de objetos
        Object[] objectArray = { 1, "Dos", 3.0, true };
        System.out.println("Array de objetos: " + java.util.Arrays.toString(objectArray));
        
        // Array con valores de objetos que implementan la interfaz Comparable
        Comparable[] comparableArray = { new Integer(10), new Double(20.5), new String("Hola") };
        System.out.println("Array de objetos comparable: " + java.util.Arrays.toString(comparableArray));
        
        // Ordenar un array
        java.util.Arrays.sort(numbers);
        System.out.println("Array ordenado: " + java.util.Arrays.toString(numbers));
        
        // Buscar un valor en un array
        int searchValue = 30;
        int index = java.util.Arrays.binarySearch(numbers, searchValue);
        if (index >= 0) {
            System.out.println("El valor " + searchValue + " se encuentra en la posición " + index);
        } else {
            System.out.println("El valor " + searchValue + " no se encuentra en el array");
        }
        
        // Añadir un valor al array
        java.util.Arrays.sort(numbers); // Ordenamos el array para poder insertar el nuevo valor
        numbers = java.util.Arrays.copyOf(numbers, numbers.length + 1); // Aumentamos el tamaño del array
        numbers[numbers.length - 1] = 60; // Añadimos el nuevo valor al final del array
        java.util.Arrays.sort(numbers); // Ordenamos el array para mostrar los valores correctamente
        System.out.println("Array modificado con nuevo valor añadido: " + java.util.Arrays.toString(numbers));
        
        // Eliminar un valor del array
        java.util.Arrays.sort(numbers); // Ordenamos el array para poder eliminar el valor
        numbers = java.util.Arrays.copyOf(numbers, numbers.length - 1); // Disminuimos el tamaño del array
        numbers[numbers.length - 1] = numbers[numbers.length - 2]; // Sustituimos el último valor con el penúltimo
        numbers = java.util.Arrays.copyOf(numbers, numbers.length - 1); // Disminuimos el tamaño del array de nuevo
        System.out.println("Array modificado con valor eliminado: " + java.util.Arrays.toString(numbers));
        
        // Array multidimensional
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        

        // Mostrar los valores del array
        System.out.println("Array inicial: " + java.util.Arrays.toString(numbers));

        // Modificación de un valor en el array
        numbers[2] = 60;

        // Mostrar los valores del array modificado
        System.out.println("Array modificado: " + java.util.Arrays.toString(numbers));

        // Array multidimensional
        int[][] matrix = new int[3][4]

        /* Propieades:
        * las propiedades del array son iguales a las de C++.
         *  Si quisieramos saber el tamaño del array, utilizamos la propiedad length.
         * Ejemplo: matrix.length
         * Si quisieramos saber el tamaño de una dimensión del array, utilizamos la propiedad length del array.
         * Ejemplo: matrix[0].length
         * 
         */
        // Recorrer un array multidimensional
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Valor en la posición [" + i + "][" + j + "] es: " + matrix[i][j]);
            }
        }
    }
}