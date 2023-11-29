package src;

import java.util.ArrayList;
import java.util.Scanner;

public class index{
    public static void main(String[] args) {
         ListaDoble listaDoble = new ListaDoble();
        Scanner scanner = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Mostrar Lista Ascendente");
            System.out.println("2. Mostrar Lista Descendente");
            System.out.println("3. Insertar al Inicio");
            System.out.println("4. Insertar al Final");
            System.out.println("5. Eliminar Elemento");
            System.out.println("6. Buscar Elemento");
            System.out.println("7. Modificar elemento");
            System.out.println("8. Inicializar / Borra lista");
            System.out.println("9. Creditos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
               case 1:
                System.out.println("\n----- Mostrar Lista Ascendente -----");
                ArrayList<String> listaAscendente = listaDoble.mostrarAD(1);
                System.out.println("Lista Ascendente: " + listaAscendente);
                break;
            case 2:
                System.out.println("\n----- Mostrar Lista Descendente -----");
                ArrayList<String> listaDescendente = listaDoble.mostrarAD(2);
                System.out.println("Lista Descendente: " + listaDescendente);
                break;
                case 3:
                    System.out.print("Ingrese el dato a insertar al inicio: ");
                    scanner.nextLine();  
                    String datoInicio = scanner.nextLine();
                    listaDoble.insertI(datoInicio);
                    break;
                case 4:
                    System.out.print("Ingrese el dato a insertar al final: ");
                    scanner.nextLine();  
                    String datoFinal = scanner.nextLine();
                    listaDoble.insertF(datoFinal);
                    break;
                case 5:
                    System.out.print("Ingrese el dato a eliminar: ");
                    scanner.nextLine();  
                    String datoEliminar = scanner.nextLine();
                    listaDoble.eliminar(datoEliminar);
                    break;
                    case 6:
                    System.out.print("Ingrese el dato a buscar: ");
                    scanner.nextLine();  
                    String datoBuscar = scanner.nextLine();
                    
                    System.out.println("Orden de búsqueda: ");
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    System.out.print("Seleccione una opción: ");
                    int orden = scanner.nextInt();
                    scanner.nextLine();  
                
                    int posicion = listaDoble.buscaOptimizada(datoBuscar, orden);
                    
                    if (posicion != -1) {
                        System.out.println("El dato se encuentra en la posición: " + posicion);
                    } else {
                        System.out.println("El dato no se encuentra en la lista.");
                    }
                    break;
                
                case 7:
                    System.out.print("Ingrese el dato a modificar: ");
                    scanner.nextLine(); 
                    String datoModificar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo dato: ");
                    String nuevoDato = scanner.nextLine();
                    listaDoble.modificar(datoModificar, nuevoDato);
                    System.out.println("Dato modificado");
                    break;

                case 8:
                    listaDoble.inicializar();
                    System.out.println("Lista inicializada");
                
                case 9:
                    System.out.println("----- Creditos -----");
                    System.out.println("Nombres: Marco Antonio Chavez Baltierrez | Jesus Alberto Ramirez Gonzalez");
                    System.out.println("Matriculas: 22170149 | 22170147");
                    System.out.println("Curso: Estructura de Datos");
                    System.out.println("Sección: 4-C");
                    break;
                    case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}