import javax.management.RuntimeErrorException;

// Ejemplo Hilos - Programacion Concurrente


// Crear hilos usando la clase Thread y sobrecargando el método run()
/*
 * Es importante tener en cuenta las siguientes cosas:
 * Si usamos la clase Thread (importante la T mayúscula), al ser una clase es extend.
 * Al ser una clase, deberemos sobrecargar el método run, implementando lo que nosotros deseemos que el hilo haga.
 * Es importante que a la hora de crear hilos, debemos crear objetos de la clase que creemos no de Thread.
 * Nautralmente podemos crear objetos de tipo Thread, pero no ejecutarán el método run que hemos reeimplementado, sino el por defecto.
 */

class Miclase extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i<5; i++)
        System.out.println("Hilo[" + i + "] tiene un valor de: " + i+1 + ".");
    }
}


public class Main
{
    public static void main(String[] args)
    {
        Miclase hilo1 = new Miclase();
        Miclase hilo2 = new Miclase();

        hilo1.start();
        hilo2.start();
    }
}

// Crear hilos con la interfaz runnable, sobrecarando el método run.
/*
 * Este es parecido al anterior, pero ya no usamos una clase que extiende a otra sino una interfaz.
 * Al ser una interfaz la clase Miclase implementará a la interfaz runnable.
 * Al ejecutar el código main deberemos crear objetos de tipo Thread pero con ligeros cambios.
 * Estos cambios asegurarán que se ejecute el código del método sobrecargado run().
 */

 class miHilo implements Runnable{
    @Override
    public void run()
    {
        for (int i = 0; i <= 5; i++)
        {
            System.out.println(Tread.currentThread().getName()+ " - Iteración " + i);
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                System.out.println("Hilo interrumpido" + e.getName);
            }
        }
    }
 }


 public class Principal
{
    public static void main(String[] args)
    {
        Thread hilo1 = new Thread(new miHilo()); // Crea el hilo
        Thread hilo2 = new Thread(new miHilo());

        hilo1.start(); // Inicia el Hilo.
        hilo2.start();
    }   
}


/*
 * Asímismo se puede asignar prioridades a los Hilos.
 * Por ejemplo: MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY.
 * Todos ellos precedidos por la palabra reservada "Thread."
 */

 public class PrioridadHilos
 {
    public static void main(String[] args) {
        
        Thread hilo1 = new Thread(); // Este hilo no tendría mas que el comportamiento predeterminado.
        /*
         * Si queremos crear un hilo que tenga un funcionamiento que nosotros queramos
         * deberemos emplear una expresión lambda.
         * 
         * Esto se hace para ahorrar la sobrecarga del método run, y para poder darle un funcionamiento distinto a cada hilo si se deseara.
         */
        Thread hilo2 = new Thread (() -> {for(int i=0; i<=5; i++) System.out.println("Hilo2");});

        // Para establecer prioridad tenemos que utilizar el método 
        // setPriority(Thread.PRIORIDAD)

           
        hilo1.setPriority(Thread.MIN_PRIORITY); // Baja prioridad
        hilo2.setPriority(Thread.MAX_PRIORITY); // Alta prioridad

        hilo1.start();
        hilo2.start();
 

        /*
         * Cabe aclarar que establecer la prioridad no garantiza que el hilo 
         * con mayor prioridad se ejecute antes que uno con menor prioridad.
         * En el caso que vemos, el hilo1 se inicia antes que el hilo2, ¿Qué pasará?
         * Se ejecutará claramente primero el hilo1, pero el planificador de procesos podrá ceder el control a mitad
         * de ejecución del hilo1, asumiendo el hilo2 la ejecución y luego el hilo1.
         * hilo1 retomará la ejecución desde donde lo dejó, no volverá a empezar.
         */
    } 
 }


 /*
  * Sincronización de hilos. Palabra reservada: synchronized.
  * Existen dos maneras de sincronizar hilos:
  * 1. Sincronizando Métodos.
  * 2. Sincronizando bloques de código.
  */

  class CuentaBancaria {
    private int saldo = 100;
// En este caso sincroniza el método depositar.
/*
 * Se realiza la sincronización para evitar que ambos hilos accedan
 * de manera simultánea y alteren el valor incorrectamente y la salida sea errónea.
 */
    public synchronized void depositar(int monto) {
        int nuevoSaldo = saldo + monto;
        System.out.println(Thread.currentThread().getName() + " depositó: " + monto);
        saldo = nuevoSaldo;
        System.out.println("Saldo después del depósito: " + saldo);
    }

    public int getSaldo() {
        return saldo;
    }
}

public class ConSincronizacion {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        Thread hilo1 = new Thread(() -> cuenta.depositar(50), "Hilo 1");
        Thread hilo2 = new Thread(() -> cuenta.depositar(30), "Hilo 2");

        hilo1.start();
        hilo2.start();
    }
}

class CuentaBancaria {
    private int saldo = 100;

    public void depositar(int monto) {
        synchronized (this) { // Bloque sincronizado
            int nuevoSaldo = saldo + monto;
            System.out.println(Thread.currentThread().getName() + " depositó: " + monto);
            saldo = nuevoSaldo;
            System.out.println("Saldo después del depósito: " + saldo);
        }
    }

    public int getSaldo() {
        return saldo;
    }
}

/*
 * El efecto en ambos ejemplos es el mismo, solamente que el segundo es más efectivo
 * ya que realiza más control sobre el código al que sincroniza.
 */


 /*
  * El sincronizar bloques de codigo (metodos o no) incluye usar unos operadores
  * especiales para la sincronización de hilos conocidos como: wait y notify.
  * wait básicamente espera a que la condición finalice para que el hilo pueda acceder.
  * notify notifica al hilo que puede acceder ya al método.

  Notify  tiene cierto "rango", si fuera NotifyAll() notifica a todos los hilos que estuvieran esperando.
  Notify puede ser a un hilo en específico Ejemplo: objeto.notify.
  */

  class Cola{
    private int dato;
    private boolean disponible = false;

    public synchronized void producir(int valor) {
        while (disponible) {
            try {
                wait(); // Espera si el dato ya está disponible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dato = valor;
        disponible = true;
        System.out.println("Producido: " + valor);
        notify(); // Notifica al consumidor
    }

    public synchronized int consumir() {
        while (!disponible) {
            try {
                wait(); // Espera si no hay dato disponible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false;
        System.out.println("Consumido: " + dato);
        notify(); // Notifica al productor
        return dato;
    }
}

public class ProductorConsumidor {
    public static void main(String[] args) {
        Cola cola = new Cola();

        // Productor
        Thread productor = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                cola.producir(i);
                try {
                    Thread.sleep(500); // Simula tiempo de producción
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Productor");

        // Consumidor
        Thread consumidor = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                cola.consumir();
                try {
                    Thread.sleep(800); // Simula tiempo de consumo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumidor");

        productor.start();
        consumidor.start();
    }
}


/*
 * Estados de un hilo:
 * Nuevo: Creado, pero no iniciado (new Thread())
 * Ejecutable: Listo para ejecutarse (start()).
 * Corriendo: Actualmente ejecutándose.
 * En espero: Pausado temporalmente (sleep o wait).
 * Terminado: Finalizó su ejecución.
 * 
 * Para consultar el estado hilo.getState().
 */
