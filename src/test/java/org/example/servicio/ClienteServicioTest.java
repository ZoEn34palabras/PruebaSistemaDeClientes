package org.example.servicio;

import org.example.modelo.CategoriaEnum;
import org.example.modelo.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteServicioTest {

    @Test
    public void agregarCliente() {
        ClienteServicio cliente2 = new ClienteServicio();
        Cliente cliente = new Cliente("11122233-4","Peter","Rocha", "3", CategoriaEnum.ACTIVO);
        cliente2.agregarCliente(cliente);

        assertEquals(1, cliente2.getListaClientes().size());
        assertEquals("Peter", cliente2.getListaClientes().get(0).getNombreCliente());
    }

    @Test
    public void agregarClienteNullTest() {
        ClienteServicio cliente2 = new ClienteServicio();
        Cliente cliente = null;
        cliente2.agregarCliente(cliente);

        assertEquals(0, cliente2.getListaClientes().size());
    }

}