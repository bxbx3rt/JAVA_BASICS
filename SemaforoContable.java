/*
 * Los semáforos sirven para sincronicar el acceso de múltiples hilos a un recurso
 * compartido. Funciona utilizando permisos.
 * Un semáforo puede tener un permiso o más, y los hilos deben adquirir un permiso
 * antes de usar el recurso.
 * Una vez que terminan, deben liberar el permiso.
 */

 /*
  * Existen dos tipos de semáforos:
  * 1. Semáforo binario: Solo permite un permiso, similar al syncronized.
  * 2. Semáforo contable: Permite más de un permiso, útil cuando quieres permitir
  * que varios hilos accedan al recurso al mismo tiempo.
  */


  /*
   * Los métodos principales de un semáforo:
   * acquire() -> El hilo intenta obtener un permiso. Si no hay permisos disponibles, se bloquea hasta que otro hilo libere uno.
   * release() -> Libera un permiso, permitiendo que otros hilos lo adquieran.
   * Constructores:
   * new Semaphore(n): Crea un semáfoto con n permisos disponibles.
   * new Semaphore(n, true): Crea un semáforo justo(fair), donde los permisos se asignan en el orden en que se solicitan(FIFO).
   */


   //Semáforo Binario
   //Hay que utiizar un import (en todos los tipos)

   import java.util.concurrent.Semaphore;

   class ArchivoCompartido
   {
    private Semaphore semaforo = new Semaphore(1);

    public void escribir(String mensaje)
    {
        try{
        semaforo.acquire(); //Intenta adquirir el permiso
        System.out.println(Thread.currentThread().getName()+ " escribiendo: " + mensaje);
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " terminó de escribir.");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            semaforo.release();
        }
    }
   }


public class SemaforoBinario
{
    boolean ok = false;
    
    public static void main(String[] args)
    {
        ArchivoCompartido archivo = new ArchivoCompartido();

        Thread hilo1 = new Thread(() -> archivo.escribir("Mensaje del Hilo1"), "Hilo1");
        Thread hilo2 =  new Thread(() -> archivo.escribir("Mensaje del Hilo2"), "Hilo2");
        hilo1.setPriority(Thread.MIN_PRIORITY);
        hilo2.setPriority(Thread.MAX_PRIORITY);
      
            hilo2.start();
            hilo1.start();
    
    }
}

// Semáfoto Contable

class ImpresorasCompartidas
{
    private Semaphore semaforo;
    private int numImpresoras;

    public ImpresorasCompartidas(int numImpresoras)
    {
        this.semaforo = new Semaphore(numImpresoras);
    }

    public void Imprimir(String documento)
    {
        try{
            semaforo.acquire();
            System.out.println(Thread.currentThread().getName() + " Se está iniciando");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " terminado.");
        }catch (InterruptedException e)
        {
            System.out.println("Se ha interrumpido el hilo en ejecución");
        }finally{
            semaforo.release();
        }
    }
}

public class SemaforoContable
{
    public static void main(String[] args)
    {
        ImpresorasCompartidas impresoras = new ImpresorasCompartidas(3);

        for(int i=0; i<= 6; i++)
        {
            String documento =  "Documento" + i;
            Thread hilo = new Thread(() -> impresoras.Imprimir(documento), "Usuario" + i);
            hilo.start();
        }
    }
}







class prueba
{
    private Semaphore sem1 = new Semaphore(5);

    public String MiString (String mensaje)
    {
        try{
            sem1.acquire();
            mensaje += "Escribiendo";
            Thread.sleep(100);
            mensaje += " ha finalizado de escribir";
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }finally{
          sem1.release();
        }
        return mensaje;

    }
}


class princpial{
    public static void main(String[] args)
    {
        

        prueba prueba1 = new prueba();
        Thread hilo1 = new Thread(() -> System.out.println(prueba1.MiString("Proceso 1")), "hilo1");
        Thread hilo2 = new Thread(() -> System.out.println(prueba1.MiString("Proceso 2")), "hilo2");

        hilo1.start();
        hilo2.start();

    }
}