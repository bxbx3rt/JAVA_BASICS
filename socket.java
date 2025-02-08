import java.net.*;

public class Ej_pag10_tema4 {
    public static void main(String[] args) {
        try {
            // Si la longitud del array args es mayor que 0, significa que se ha pasado al menos un argumento
            if (args.length > 0) {
                // Almacenamos en una variable auxiliar de tipo String el contenido de args[0],
                // que puede ser un nombre de host (como "google.com") o una dirección IP (como "8.8.8.8").
                String host = args[0];
                
                // Obtenemos todas las direcciones IP asociadas al host o dirección IP pasada como argumento.
                InetAddress[] direcciones = InetAddress.getAllByName(host);
                
                // Recorremos el array de direcciones y las imprimimos una a una.
                for (int i = 0; i < direcciones.length; i++) {
                    System.out.println(direcciones[i]);
                }
            } 
            // Si no se pasa ningún argumento, obtenemos la dirección IP de la máquina local.
            else {
                // InetAddress.getLocalHost() devuelve la dirección IP de la máquina local, 
                // que puede ser una dirección de red como "192.168.x.x" o "127.0.0.1" si no hay red disponible.
                InetAddress direccion = InetAddress.getLocalHost();
                
                // Imprimimos la dirección local.
                System.out.println(direccion);
            }
        } catch (Exception e) {
            // Si ocurre algún error, como un host desconocido, imprimimos el stack trace para depuración.
            e.printStackTrace();
        }
    }
}
