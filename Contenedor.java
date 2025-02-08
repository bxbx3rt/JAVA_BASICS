// Se pide generalizar este algoritmo
public class Contenedor <T extends Comparable<T>>{
    private T[] datos;
    private int pos;
    /*
     * ¿Porqué usamos T y no Comparable para definir los atributos?
     * Porque T es un tipo genérico que extiende de Comparable, por lo que podemos usar los métodos de Comparable
     * Y además hemos generado un requisito, que cualquier tipo (T) tenga que emplear a Comparable.
     */
    public void Contenedor()
    {
        datos = new Comparable[10];
        pos = 0;
    }
    public void add(T dato)
    {
        if (pos < datos.length)
        {
            datos[pos] = dato;
            pos++;
        }
    }
    public int getNegativos()
    {
        int numNegativos = 0;
        for(int i=0; i<datos.length; i++)
        {
            if (datos[i].compareTo(Integer.valueOf(0)) < 0)
            {
                numNegativos++;
            }
        }
        return numNegativos;
    }
}
