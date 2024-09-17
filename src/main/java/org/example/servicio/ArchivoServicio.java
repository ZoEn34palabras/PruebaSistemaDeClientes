package org.example.servicio;

import org.example.modelo.CategoriaEnum;
import org.example.modelo.Cliente;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio extends Exportador {

    private ClienteServicio clienteServicio;

    public ArchivoServicio() {
        this.clienteServicio = new ClienteServicio();
    }

    public void cargarDatos(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String run = data[0];
                String nombre = data[1];
                String apellido= data[2];
                String anios = data[3];
                CategoriaEnum categoria = CategoriaEnum.valueOf(data[4].toUpperCase());

                Cliente cliente = new Cliente(run, nombre, apellido, anios, categoria);
                clienteServicio.agregarCliente(cliente);
            }
            System.out.println("Datos cargados correctamente en la lista.");
        } catch (IOException e) {
            System.err.println("Error cargando datos: " + e.getMessage());
        }
    }


    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {

    }
}
