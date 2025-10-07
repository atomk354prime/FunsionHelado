//Tatiana Ramirez, Yojan Peña
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helpers {

    public static List<Helado> crudHelados(List<Helado> listaHelados) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ CRUD HELADOS =====");
            System.out.println("1. Crear helado");
            System.out.println("2. Ver helados");
            System.out.println("3. Editar helado");
            System.out.println("4. Eliminar helado");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    // Crear
                    System.out.print("Ingrese ID del helado: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Ingrese nombre del helado: ");
                    String nombre = input.nextLine();

                    System.out.print("Ingrese precio del helado: ");
                    float precio = input.nextFloat();
                    input.nextLine();

                    System.out.print("Ingrese sabores (separados por coma): ");
                    String saboresInput = input.nextLine();
                    ArrayList<String> sabores = new ArrayList<>();
                    for (String s : saboresInput.split(",")) {
                        sabores.add(s.trim());
                    }

                    System.out.print("Ingrese tipo de helado (1=cono, 2=vaso, 3=sundae): ");
                    int tipo = input.nextInt();

                    Helado nuevo = new Helado(id, nombre, precio, sabores, tipo);
                    listaHelados.add(nuevo);
                    System.out.println("Helado agregado correctamente.");
                    break;

                case 2:
                    // Ver
                    System.out.println("\n--- Lista de helados ---");
                    if (listaHelados.isEmpty()) {
                        System.out.println("No hay helados registrados.");
                    } else {
                        for (Helado h : listaHelados) {
                            System.out.println(h.toString());
                        }
                    }
                    break;

                case 3:
                    // Editar
                    System.out.print("Ingrese ID del helado que desea editar: ");
                    id = input.nextInt();
                    input.nextLine();
                    boolean encontrado = false;

                    for (Helado h : listaHelados) {
                        if (h.id == id) {
                            encontrado = true;
                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = input.nextLine();
                            h.nombre = nuevoNombre;

                            System.out.print("Nuevo precio: ");
                            float nuevoPrecio = input.nextFloat();
                            h.setPrecio(nuevoPrecio);

                            System.out.println("Helado editado con éxito.");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró el helado.");
                    }
                    break;

                case 4:
                    // Eliminar
                    System.out.print("Ingrese ID del helado a eliminar: ");
                    id = input.nextInt();
                    input.nextLine();

                    Helado heladoAEliminar = null;
                    for (Helado h : listaHelados) {
                        if (h.id == id) {
                            heladoAEliminar = h;
                            break;
                        }
                    }

                    if (heladoAEliminar != null) {
                        listaHelados.remove(heladoAEliminar);
                        System.out.println("Helado eliminado.");
                    } else {
                        System.out.println("No se encontró el helado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del menú...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        return listaHelados;
    }
}
