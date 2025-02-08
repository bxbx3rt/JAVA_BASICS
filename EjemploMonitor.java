public class Monitores {
    //CODIGO QUE NO HAY JAJA
}


/*
 * Los monitores sirven para garantizar que solo un hilo a la vez puede acceder a una sección
 * crítica del código. En Java, los monitores están estrechamete relacionados con el concepto de
 * synchronized.
 */

 
 /*¿Qué es la sección crítica?
  * Es la parte que es susceptible de generar errores de sincronización si dos o más procesos(hilos)
  * están intentando acceder al mismo recurso.
  */

  // Contador seguro con monitores
  class ContadorSeguro {
    private int contador = 0;

    // Método sincronizado: solo un hilo puede acceder a la vez
    public synchronized void incrementar() {
        contador++;
        System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + contador);
    }

    // Método sincronizado para leer el valor
    public synchronized int obtenerValor() {
        return contador;
    }
}

public class EjemploMonitor {
    public static void main(String[] args) {
        ContadorSeguro contador = new ContadorSeguro();

        // Crear varios hilos que incrementan el contador
        for (int i = 0; i < 5; i++) {
            Thread hilo = new Thread(() -> {
                for (int j = 0; j < 3; j++) { // Cada hilo incrementa 3 veces
                    contador.incrementar();
                    try {
                        Thread.sleep(100); // Simula un tiempo de procesamiento
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Hilo-" + i);
            hilo.start();
        }
    }
}


// Monitores con bloques sincronizados

class ContadorSeguroBloque {
    private int contador = 0;

    public void incrementar() {
        // Bloque sincronizado para proteger la sección crítica
        synchronized (this) {
            contador++;
            System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + contador);
        }
    }

    public int obtenerValor() {
        synchronized (this) {
            return contador;
        }
    }
}

// Monitores con wait, notify, etc.

class Almacen {
    private int producto = -1; // Producto inicial vacío
    private boolean disponible = false; // Indica si hay un producto listo

    public synchronized void producir(int valor) throws InterruptedException {
        while (disponible) { // Espera si ya hay un producto
            wait();
        }
        producto = valor;
        disponible = true;
        System.out.println("Producido: " + producto);
        notify(); // Notifica al consumidor que hay un producto listo
    }

    public synchronized int consumir() throws InterruptedException {
        while (!disponible) { // Espera si no hay un producto
            wait();
        }
        disponible = false;
        System.out.println("Consumido: " + producto);
        notify(); // Notifica al productor que puede producir otro producto
        return producto;
    }
}

public class ProductorConsumidor {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Thread productor = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    almacen.producir(i);
                    Thread.sleep(500); // Simula tiempo de producción
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Productor");

        Thread consumidor = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    almacen.consumir();
                    Thread.sleep(1000); // Simula tiempo de consumo
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumidor");

        productor.start();
        consumidor.start();
    }
}


/*
 * Diferencias principales entre:
 * Monitores                ||              Semáforos
 * Bloquean automáticamente
 * el acceso al monitor asociado.           Necesitas controlar manualmente los permisos.
 * 
 * Usan el monitor intrínseco.              Usan un objeto interno (Semaphore)
 * 
 * Solo permiten exclusión mutua.           Más flexibles: pueden manejar varios permisos
 * 
 * Solo un hilo puede entrar a una          Varios hilos pueden acceder, dependiendo de los permisos.
 * sección sincronizada.
 * 
 * 
 * Para evitar problemas como el deadlock, se recomienda usasr semáforos. Los monitores no garantizan
 * una mayor flexibilidad (de hecho todo lo contrario), ya que son para casos muy específicos.
 */