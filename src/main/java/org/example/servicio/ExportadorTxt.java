package org.example.servicio;

import org.example.modelo.Cliente;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportadorTxt extends Exportador{
    @Override

    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName + ".txt"))) {
            listaClientes.forEach(cliente -> pw.println("RUN del Cliente: " + cliente.getRunCliente() + "\n" +
                    "Nombre del Cliente: " + cliente.getNombreCliente() + "\n" +
                    "Apellido del Cliente: " + cliente.getApellidoCliente() + "\n" +
                    "Años como Cliente: " + cliente.getAniosCliente() + "\n" +
                    "Categoría del Cliente: " + cliente.getNombreCategoria() + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
