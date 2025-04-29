/* Suppose you are building a car inventory system. All cars have a vinNumber, make, model and mileage. But no car is
just a car. Each car is either a Sedan, a UtilityVehicle or a Truck.
Create an abstract class named Car and define the following properties and behaviors:

    vinNumber: a String representing the VIN number of the car
    make: a String representing the make of the car
    model: a String representing the model of the car
    mileage: an int representing the mileage of the car
    getInfo(): a method that returns a String containing all of the car’s properties in a readable format

Create three classes that extend Car: Sedan, UtilityVehicle and Truck.
UtilityVehicle objects should have an additional fourWheelDrive property, a boolean that represents whether the vehicle has four-wheel drive.
Truck objects should have an additional towingCapacity property, a double that represents the towing capacity of the truck */

// Clase abstracta base que representa cualquier tipo de coche
abstract class Car {
    // Atributos comunes para todos los coches
    String vinNumber; // Matrícula del coche
    String make;      // Marca del coche
    String model;     // Modelo del coche
    int mileage;      // Km del coche

    // Constructor para inicializar estos atributos
    Car(String vinNumber, String make, String model, int mileage) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }


    // Metodo que devuelve la información del coche
    String getInfo() {
        return "VIN: " + vinNumber + ", Make: " + make + ", Model: " + model + ", Mileage: " + mileage;
    }
}

// Clase Sedan que hereda de Car (No tiene propiedades adicionales, solo usa lo heredado)
class Sedan extends Car {
    // Constructor que llama al constructor de la clase base
    Sedan(String vinNumber, String make, String model, int mileage) {
        super(vinNumber, make, model, mileage); //Clase super se utiliza para hacer referencia a la clase base (la que se hereda)
    }
}

// Clase UtilityVehicle que hereda de Car
// Tiene una propiedad adicional: tracción en las 4 ruedas
class UtilityVehicle extends Car {
    boolean fourWheelDrive; // true si tiene tracción en las 4 ruedas

    // Constructor que inicializa todos los atributos, incluyendo el nuevo
    UtilityVehicle(String vinNumber, String make, String model, int mileage, boolean fourWheelDrive) {
        super(vinNumber, make, model, mileage); // Llama al constructor base
        this.fourWheelDrive = fourWheelDrive;   // Inicializa su propio atributo
    }

    // Sobrescribe el metodo getInfo para añadir la info de 4WD
    @Override
    String getInfo() {
        return super.getInfo() + ", 4WD: " + fourWheelDrive;
    }
}


// Clase Truck que hereda de Car
// Tiene una propiedad adicional: capacidad de remolque
class Truck extends Car {
    double towingCapacity; // Capacidad de remolque en toneladas

    // Constructor que inicializa todos los atributos
    Truck(String vinNumber, String make, String model, int mileage, double towingCapacity) {
        super(vinNumber, make, model, mileage);  // Constructor de Car
        this.towingCapacity = towingCapacity;    // Atributo adicional
    }

    // Sobrescribe el metodo getInfo para mostrar la capacidad de remolque
    @Override
    String getInfo() {
        return super.getInfo() + ", Towing Capacity: " + towingCapacity + " tons";
    }
}


// Clase principal que sirve para probar las clases anteriores
public class CarInventory {
    public static void main(String[] args) {
        // Crear un coche tipo Sedan
        Sedan s = new Sedan("123ABC", "Toyota", "Camry", 25000);

        // Crear un UtilityVehicle con tracción total
        UtilityVehicle u = new UtilityVehicle("456DEF", "Jeep", "Wrangler", 40000, true);

        // Crear un Truck con capacidad de remolque
        Truck t = new Truck("789GHI", "Ford", "F-150", 60000, 5.0);

        // Mostrar la información de cada coche en pantalla
        System.out.println(s.getInfo());
        System.out.println(u.getInfo());
        System.out.println(t.getInfo());
    }
}

