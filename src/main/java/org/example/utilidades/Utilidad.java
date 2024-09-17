package org.example.utilidades;

import java.io.IOException;

public class Utilidad {
        public static void limpiarPantalla() {
            for (int i = 0; i <= 10; i++) {
                System.out.println("");
            }
        }

        public static void esperar(int seconds) {
            try {
                for (int i = seconds; i > 0; i--) {
                    System.out.println("\nLimpiando pantalla en " + i + " segundos...");
                    long startTime = System.currentTimeMillis();
                    while (System.currentTimeMillis() - startTime < 3000) {
                        if (System.in.available() > 0 && System.in.read() == '\n') {
                            limpiarPantalla();
                            return;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR: en manejo de condicion de cuenta regresiva: " + e);
            }

            limpiarPantalla();
        }

        public static void mostrarMensaje(String mensaje) {
            System.out.println(mensaje);
            pausar();
        }

        public static void pausar() {
            System.out.println("Presione Enter para continuar...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






