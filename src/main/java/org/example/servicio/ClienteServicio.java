package org.example.servicio;

import org.example.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private static List<Cliente> listaClientes;

    public ClienteServicio() {
        this.listaClientes = new ArrayList<>();
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes) {
            System.out.println("-------------Datos del Cliente-------------");
            System.out.println("RUN del Cliente: " + cliente.getRunCliente());
            System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
            System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
            System.out.println("Años como Cliente: " + cliente.getAniosCliente() + " años");
            System.out.println("Categoría del Cliente: " + cliente.getNombreCategoria().name());
            System.out.println("-------------------------------------------");
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null) {
            listaClientes.add(cliente);
        }
    }

    public void editarCliente(Cliente cliente) {
        listaClientes.stream()
                .filter(c -> c.getRunCliente().equals(cliente.getRunCliente()))
                .forEach(c -> {
                    c.setNombreCliente(cliente.getNombreCliente());
                    c.setApellidoCliente(cliente.getApellidoCliente());
                    c.setAniosCliente(cliente.getAniosCliente());
                    c.setNombreCategoria(cliente.getNombreCategoria());
                });
    }

    public Cliente buscarCliente(String run) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(run)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}
