package org.example.servicio;

import org.example.modelo.Cliente;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportadorCsv extends Exportador {

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName + ".csv"))) {
            listaClientes.forEach(cliente -> pw.println(cliente.getRunCliente() + "," +
                    cliente.getNombreCliente() + "," +
                    cliente.getApellidoCliente() + "," +
                    cliente.getAniosCliente() + "," +
                    cliente.getNombreCategoria()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
