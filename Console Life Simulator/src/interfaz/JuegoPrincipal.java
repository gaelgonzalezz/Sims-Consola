package interfaz;

import entidades.Personaje;
import util.Utilidades;
import entidades.Personaje;
import util.Utilidades;

public class JuegoPrincipal {
    private Personaje personaje;
    private CheatManager cheatManager;

    public JuegoPrincipal(Personaje personaje) {
        this.personaje = personaje;
        this.cheatManager = new CheatManager(personaje);
    }

    public void juego() {
        boolean continuar = true;
        int turno = 1;

        while (continuar) {
            System.out.println("--------TURNO: " + turno + "--------");
            personaje.mostrarStats();

            System.out.println("""
                    --- MENÚ PRINCIPAL ---
                    1. Ver estado
                    2. Comer
                    3. Dormir
                    4. Bañarse
                    5. Trabajar
                    6. Estudiar
                    7. Ejercitarse
                    8. Apostar
                    9. Salir a pasear
                    10. Robar en la tienda
                    11. Jugar videojuegos
                    12. Salir del juego
                    """);

            int opcion = Utilidades.ingresarEntero(1, 12, cheatManager);

            switch (opcion) {
                case 1:
                	personaje.mostrarStats();
                	break;
                case 2:
                	personaje.comer();
                	break;
                case 3:
                	personaje.dormir();
                	break;
                case 4:
                	personaje.banio();
                	break;
                case 5:
                	personaje.trabajar();
                	break;
                case 6:
                	personaje.estudiar();
                	break;
                case 7:
                	personaje.ejercitarse();
                	break;
                case 8:
                	if (personaje.getDinero() > 0) {
                	personaje.apostar();
                	} else {
                		System.out.println("No tienes suficiente dinero para apostar.");
                	}
                	break;
                case 9:
                	personaje.pasear();
                	break;
                case 10:
                	personaje.robarTienda();
                	break;
                case 11:
                	personaje.jugarVideojuegos();
                	break;
                case 12: {
                    System.out.println("Hasta luego!");
                    continuar = false;
                }
            }

            if (continuar) {
                personaje.limitarTodo();
                personaje.disminuirVida();
                personaje.degradarStatsPorTurno();
                continuar = personaje.getVida() > 0;
                turno++;

                System.out.println("\nPresiona Enter para continuar...");
                try {
                    System.in.read();
                } catch (Exception e) {
                    // nada
                }
            }
        }

        System.out.println("☠️ Tu personaje murió. Fin del juego.");
    }
}
