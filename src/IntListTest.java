/* Create an IntList interface with the following methods:
    add(int number): a method that adds a new number to the list
    get(int id): a method that retrieves an element by its ID
Create two implementations of IntList: IntArrayList and IntVector.
IntArrayList should store numbers in an array with a length of 10 by default. When the add method is called, you must
first determine if the array is full. If it is, create a new array that is 50% larger, move all elements over to the
new array and add the new element. (For example, an array of length 10 would be increased to 15.)
IntVector should store numbers in an array with a length of 20 by default. When the add method is called, you must first
determine if the array is full. If it is, create a new array that is double the size of the current array, move all elements
over to the new array and add the new element. (For example, an array of length 10 would be increased to 20.)
In your README.md, include an example of when IntArrayList would be more efficient and when IntVector would be more efficient */

// Interfaz con los métodos requeridos para la lista de enteros
// Esta interfaz define los métodos que cualquier clase que implemente IntList debe tener.
// Los métodos son: add() para añadir un número a la lista, y get() para obtener un número dado su índice.
interface IntList {
    // Metodo para añadir un número a la lista
    void add(int number);

    // Metodo para obtener un número de la lista dado su índice
    int get(int id);
}

// Implementación de la interfaz IntList usando un array con tamaño inicial de 10
// Esta clase maneja una lista de enteros y aumenta su tamaño cuando es necesario (crece al 150%)
class IntArrayList implements IntList {
    // Array donde se almacenan los números de la lista. Empieza con un tamaño de 10
    private int[] data = new int[10];

    // Variable que guarda la cantidad actual de elementos en la lista
    private int size = 0;

    // Metodo para añadir un número a la lista
    @Override
    public void add(int number) {
        // Si el array está lleno, debemos redimensionarlo
        if (size == data.length) {
            // Calcular el nuevo tamaño: 150% del tamaño actual
            int newLength = data.length + data.length / 2; // Crece al 150%

            // Crear un nuevo array con el nuevo tamaño
            int[] newData = new int[newLength];

            // Copiar los elementos existentes del array antiguo al nuevo
            for (int i = 0; i < size; i++) newData[i] = data[i];

            // Reemplazar el array viejo por el nuevo
            data = newData;
        }

        // Añadir el nuevo número al final de la lista
        data[size++] = number; // Aumenta size después de añadir el número
    }

    // Metodo para obtener un número en una posición específica (índice)
    @Override
    public int get(int id) {
        // Si el índice está fuera de los límites, lanzar una excepción
        if (id < 0 || id >= size) {
            throw new IndexOutOfBoundsException("Index " + id + " is out of bounds.");
        }

        // Devolver el número en la posición indicada
        return data[id];
    }
}

// Implementación de la interfaz IntList usando un array con tamaño inicial de 20
// Esta clase maneja una lista de enteros y aumenta su tamaño cuando es necesario (crece al 200%)
class IntVector implements IntList {
    // Array donde se almacenan los números de la lista. Empieza con un tamaño de 20
    private int[] data = new int[20];

    // Variable que guarda la cantidad actual de elementos en la lista
    private int size = 0;

    // Metodo para añadir un número a la lista
    @Override
    public void add(int number) {
        // Si el array está lleno, debemos redimensionarlo
        if (size == data.length) {
            // Calcular el nuevo tamaño: 200% del tamaño actual
            int newLength = data.length * 2; // Crece al 200%

            // Crear un nuevo array con el nuevo tamaño
            int[] newData = new int[newLength];

            // Copiar los elementos existentes del array antiguo al nuevo
            for (int i = 0; i < size; i++) newData[i] = data[i];

            // Reemplazar el array viejo por el nuevo
            data = newData;
        }

        // Añadir el nuevo número al final de la lista
        data[size++] = number; // Aumenta size después de añadir el número
    }

    // Metodo para obtener un número en una posición específica (índice)
    @Override
    public int get(int id) {
        // Si el índice está fuera de los límites, lanzar una excepción
        if (id < 0 || id >= size) {
            throw new IndexOutOfBoundsException("Index " + id + " is out of bounds.");
        }

        // Devolver el número en la posición indicada
        return data[id];
    }
}

// Clase principal para probar las implementaciones de IntList
public class IntListTest {
    public static void main(String[] args) {
        // Crear una lista de tipo IntArrayList
        IntList list1 = new IntArrayList();

        // Crear una lista de tipo IntVector
        IntList list2 = new IntVector();

        // Añadir 25 elementos a ambas listas (para probar la expansión del array)
        for (int i = 0; i < 25; i++) {
            list1.add(i);    // Añadir el número i a la lista list1 (IntArrayList)
            list2.add(i * 10); // Añadir el número i*10 a la lista list2 (IntVector)
        }

        // Imprimir el valor en la posición 10 de ambas listas
        System.out.println("IntArrayList: " + list1.get(10));  // Debería imprimir 10 (ya que añadimos números del 0 al 24)
        System.out.println("IntVector: " + list2.get(10));     // Debería imprimir 100 (porque añadimos 10, 20, 30, ..., 240)
    }
}
