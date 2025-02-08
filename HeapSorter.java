public class HeapSorter <T extends  Comparable<T>>{
    private static Comparable[] a;
    private static int n;

    public static <T extends Comparable<T>> void sort(T [] datos) {
        a = datos;
        n = datos.length;
        heapsort();
    }

    private static void heapsort() {
        buildheap();
        while (n > 1) {
            n--;
            exchange(0, n);
            downheap(0);
        }
    }

    private static void buildheap() {
        for (int v = n / 2 - 1; v >= 0; v--) {
            downheap(v);
        }
    }

    private static void downheap(int v) {
        int w = 2 * v + 1; // First descendant of v
        while (w < n) {
            if (w + 1 < n) { // Is there a second descendant?
                if (a[w + 1].compareTo(a[w])>0) {
                    w++;
                }
            }
            // w is the descendant of v with maximum label
            if (a[v].compareTo(a[w]) >=0) {
                return; // v has heap property
            }
            exchange(v, w); // Exchange labels of v and w
            v = w; // Continue
            w = 2 * v + 1;
        }
    }

    private static void exchange(int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
