//Tatiana Ramirez, Yojan Peña
import java.util.ArrayList;

public class Helado {
    public int id;
    public String nombre;
    public float precio;
    private float precioTopping;
    private ArrayList<String> sabores;
    private ArrayList<String> toppings;
    private int tipo; // 1=cono, 2=vaso, 3=sundae, etc.

    // Constructor
    public Helado(int id, String nombre, float precio, ArrayList<String> sabores, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.sabores = sabores;
        this.tipo = tipo;
        this.toppings = new ArrayList<String>();
        this.precioTopping = 500; // precio fijo por topping
    }

    // Método para calcular el precio total (precio base + toppings)
    public float calcularPrecio() {
        float total = this.precio + (this.toppings.size() * this.precioTopping);
        return total;
    }

    // Métodos para agregar toppings
    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    // Getters y Setters básicos
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    // Mostrar datos del helado
    public String toString() {
        return "ID: " + id + 
               " | Nombre: " + nombre + 
               " | Precio: " + precio + 
               " | Sabores: " + sabores + 
               " | Toppings: " + toppings + 
               " | Tipo: " + tipo;
    }
}
