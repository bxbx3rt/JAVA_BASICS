

public class EdadMinimaNoCumplida extends RuntimeException
{
    public EdadMinimaNoCumplida(String mensaje)
    {
        super(mensaje);
    }
}


public class Alumno
{
    private int edad;
    private String nombre;

    public Alumno(int edad, String nombre)
    {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void Extension(int edad) throws EdadMinimaNoCumplida
    {
        if(edad<18)
            System.out.println("La edad introducida es menor de la esperada");
    }
    

}

public class Main
{
    public static void main(String[] args)
    {
        Alumno al = new Alumno(18, "Roberto");
        try{
            al.Extension(al.getEdad());
        } catch(EdadMinimaNoCumplida e){
            System.out.println("Error de extensión: " + e.getClass() + " " + e.getMessage());
        }
        

    }
}