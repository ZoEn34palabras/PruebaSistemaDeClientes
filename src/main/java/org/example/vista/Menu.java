package org.example.vista;

import org.example.modelo.CategoriaEnum;
import org.example.modelo.Cliente;
import org.example.servicio.ArchivoServicio;
import org.example.servicio.ClienteServicio;
import org.example.servicio.ExportadorCsv;
import org.example.servicio.ExportadorTxt;
import org.example.utilidades.Utilidad;
import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio = new ClienteServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private ExportadorCsv exportadorCsv = new ExportadorCsv();
    private ExportadorTxt exportadorTxt = new ExportadorTxt();
    private String fileName = "Clientes";
    private String fileName1 = "DBClientes.csv";
    private Scanner sc = new Scanner(System.in);

    public void iniciarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("\n1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    cargarDatos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 6);
    }

    private void listarClientes() {
        if (clienteServicio.getListaClientes().isEmpty()) {
            System.out.println("No hay clientes para mostrar.");
        } else {
            clienteServicio.listarClientes();
        }

        Utilidad.esperar(3);
    }

    private void agregarCliente() {
        System.out.println("\n-------------Crear Cliente-------------");
        System.out.print("\nIngresa RUN del Cliente: ");
        String run = sc.nextLine();
        System.out.print("\nIngresa Nombre del Cliente: ");
        String nombre = sc.nextLine();
        System.out.print("\nIngresa Apellido del Cliente: ");
        String apellido = sc.nextLine();
        System.out.print("\nIngresa años como Cliente: ");
        String anios = sc.nextLine();
        System.out.println("\n--------------------------------------");

        Cliente cliente = new Cliente(run, nombre, apellido, anios, CategoriaEnum.ACTIVO);
        clienteServicio.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente");

        Utilidad.esperar(3);
    }

    private void editarCliente() {
        System.out.println("\n-------------Editar Cliente-------------");
        System.out.println("Seleccione qué desea hacer:");
        System.out.println("1.-Cambiar el estado del Cliente");
        System.out.println("2.-Editar los datos ingresados del Cliente");
        System.out.println("3.-Volver al menú principal");
        System.out.print("\nIngrese una opción: ");
        System.out.println("\n-----------------------------------------");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 3) {
            return;
        }

        System.out.print("Ingrese RUN del Cliente a editar: ");
        String run = sc.nextLine();
        Cliente cliente = clienteServicio.buscarCliente(run);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (opcion == 1) {
            cambiarEstadoCliente(cliente);
        } else if (opcion == 2) {
            editarDatosCliente(cliente);
        } else {
            System.out.println("Opción inválida.");
        }
        Utilidad.esperar(3);
    }

    private void cambiarEstadoCliente(Cliente cliente) {
            System.out.println("\n-----Actualizando estado del Cliente----");
            System.out.println("El estado actual es: " + cliente.getNombreCategoria());
            System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
            System.out.println("2.- Si desea mantener el estado del cliente Activo");
            System.out.print("Ingrese opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

        if (opcion == 1) {
            cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
            System.out.println("Estado del cliente cambiado a Inactivo.");
        } else if (opcion == 2) {
            cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
            System.out.println("Estado del cliente mantenido como Activo.");
        } else {
            System.out.println("Opción no válida.");
        }
        Utilidad.esperar(3);
    }

    private void editarDatosCliente(Cliente cliente) {
            System.out.println("\n----Actualizando datos del Cliente-----");
            System.out.println("1.- El RUN del Cliente es: " + cliente.getRunCliente());
            System.out.println("2.- El Nombre del Cliente es: " + cliente.getNombreCliente());
            System.out.println("3.- El Apellido del Cliente es: " + cliente.getApellidoCliente());
            System.out.println("4.- Los años como Cliente son: " + cliente.getAniosCliente());
            System.out.print("Ingrese opción a editar de los datos del cliente: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nuevo RUN del Cliente: ");
                    cliente.setRunCliente(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Ingrese nuevo Nombre del Cliente: ");
                    cliente.setNombreCliente(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Ingrese nuevo Apellido del Cliente: ");
                    cliente.setApellidoCliente(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Ingrese nuevos años como Cliente: ");
                    cliente.setAniosCliente(sc.nextLine());
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("Datos cambiados con éxito.");

        Utilidad.esperar(3);
    }

    private void cargarDatos() {
        System.out.println("---------Cargar Datos-----------");
        System.out.print("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
        String ruta = sc.nextLine();
        archivoServicio.cargarDatos(ruta);
        System.out.println("Datos cargados correctamente en la lista.");

        Utilidad.esperar(3);
    }

    private void exportarDatos() {
        System.out.println("---------Exportar Datos-----------");
        System.out.println("Seleccione el formato a exportar: ");
        System.out.println("1.- Formato csv");
        System.out.println("2.- Formato txt");
        System.out.print("\nIngrese una opción para exportar: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        System.out.println("---------Exportar Datos en Windows-------------------");
        System.out.print("Ingresa la ruta en donde desea exportar el archivo: ");
        String ruta = sc.nextLine();

        if (opcion == 1) {
            exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
            System.out.println("------------------------------------");
            System.out.println("\nDatos de clientes exportados correctamente en formato csv.");
        } else if (opcion == 2) {
            exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
            System.out.println("\nDatos de clientes exportados correctamente en formato txt.");
        } else {
            System.out.println("Opción inválida.");
        }

        Utilidad.esperar(3);
    }

    private void terminarPrograma() {
        System.out.println("Finalizando el programa...");

        Utilidad.esperar(3);
    }

}
