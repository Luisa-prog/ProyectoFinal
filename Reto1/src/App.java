import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Mercurio.", "Venus.", "Marte.", "Jupiter.", "Saturno.", "Urano.", "Neptuno.",
            "Pluton." };
    static Double[] distancias = { 91.69, 41.4, 78.34, 628.73, 1275.0, 2723.0, 4351.0, 5906.0 };
    // se realiza la composicion y detalle de cada planeta
    static String[] composicion = {
            "Rocoso, sin atmosfera.",
            "Rocoso, atmosfera densa.",
            "rocoso, atmosfera delgada.",
            "Gaseoso, compuesto principalmente de nitrogeno y helio.",
            "Gaseoso, conocido por sus anillos.",
            "Gaseoso, atmosfera de hidrogeno y helio",
            "Gaseoso, Atmosfera de hidrogeno, helio y metano.",
            "Rocoso, compuesto de hielo y roca."
    };
    // feat: luisa Leon: agrego array consumo recursos a naves
    static String[] naves = { "Exploradora.", "Recolectora.", "Carga Pesada.", "Velocidad Maxima." };
    static Double[] Velocidades = { 1000.0, 400.0, 200.0, 1500.0 };
    static Double[] consumoDeCombustible = { 0.05, 0.1, 0.2, 0.3 };
    static Double[] consumoDeOxigeno = { 0.1, 0.15, 0.20, 0.25 };

    // feat: Nathalia agrega array con eventos aleatorios
    static String[] eventos = {
            "Lluvia de meteoritos.",
            "Fallo el sistema de propulsion. ",
            "Desvio del planeta destino.",
            "Tormenta de polvo.",
            "Agujero negro.",
    };

    static String planetaEscogido;
    static int seleccionPlaneta;
    static String naveElegida;
    static int pasajeros;
    static double DistanciaPlaneta;
    static Double combustibleNecesario;
    static Double oxigenoNecesario;
    static Double combustibleDisponible;
    static Double oxigenoDisponible;
    static Random random = new Random();
    static String eventoAleatorio;

    public static void main(String[] args) throws Exception {
        System.out.println("#########################################");
        System.out.println(" Bienvenido a su viaje interplanetario ");
        System.out.println("#########################################");
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    imprimirInfoPlanetas();
                    break;
                case 2:
                    planetaEscogido = seleccionarPlaneta(planetas, scanner);
                    break;
                case 3:
                    naveElegida = seleccionarNave(naves, scanner);
                    break;
                case 4:
                    // docs: Nathalia Bravo, llamo la funcion iniciar la simulacion del viaje por
                    // seleccionar pasajeros
                    iniciarViaje();
                    break;
                case 5:
                    System.out.println("programa finalizado con exito!");
                    break;
                // fix: Luisa Leon: Se agrega caso 4 por menu

                default:
                    System.out.println("Debe elegir una opcion entre 1 y 4.");
                    break;
            }

        } while (opcion != 4);
    }

    public static void mostrarMenu() {
        // fea: Nathalia Bravo, creacion del menu
        System.out.println("\n ---------Menu Principal----------");
        System.out.println("1.Imprimir informacion de planetas");
        System.out.println("2.Seleccionar un planeta de destino.");
        System.out.println("3.Seleccionar una nave espacial.");
        System.out.println("4.Iniciar la simulación del viaje interplanetario. ");
        System.out.println("5.Salir");
        System.out.println("Seleccione una opcion entre 1 y 4. \n");
    }

    public static String seleccionarPlaneta(String[] planetas, Scanner escanner) {
        // feat: Nathalia Bravo, agrego la funcion seleccionar el planeta
        System.out.println("Los planetas disponibles son: ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.print((i + 1) + "." + planetas[i] + " " + "\n");
        }
        System.out.println();
        // Eleccion de planeta
        System.out.println("Elige tu planeta, introduce un numero entre (1 - 8) \n");
        seleccionPlaneta = scanner.nextInt();
        if (seleccionPlaneta > 0 && seleccionPlaneta <= planetas.length) {
            planetaEscogido = planetas[seleccionPlaneta - 1];
            System.out.println("Planeta escogido: " + planetaEscogido);
            detallesEleccion();
            seleccionarPasajeros();// fix: se agrega variable pasajero1

        } else {
            System.out.println("Debe escoger una opcion entre 1 y 8. \n ");
            seleccionarPlaneta(planetas, escanner);
        }

        return planetaEscogido;
    }

    public static String seleccionarNave(String[] naves, Scanner scanner) {
        // feat: Nahalia Bravo, agrego la funcion seleccionar nave
        System.out.println("Las naves disponibles para su viaje a " + planetaEscogido + " son: ");
        for (int i = 0; i < naves.length; i++) {
            System.out.print((i + 1) + "." + naves[i] + " " + "\n"); // fix: Luisa Leon: se quita el espacio (se deja
                                                                     // como comentario) " " + "\n"// Mostrar lista de
                                                                     // naves
        }
        // fix Luisa leon: se elimina sout (se deja comentario) System.out.println();
        // Eleccion de nave
        // feat: se realiza nueva variable
        int seleccion = 0;
        boolean entradaValida = false;
        // feat: se agrega un while
        while (!entradaValida) {
            System.out.println("Elige una nave, introduce un numero entre 1 y 4 \n");
            if (scanner.hasNextInt()) {
                seleccion = scanner.nextInt();
                if (seleccion > 0 && seleccion <= naves.length) {
                    entradaValida = true;

                } else {
                    System.out.println("Debe escoger una opcion entre 1 y 4.");
                }
            } else {
                System.out.println("Entrada invalida, introduzca un numero entero. ");
                scanner.next();
            }
        }
        naveElegida = naves[seleccion - 1];
        System.out.println("La nave escogida es: " + naveElegida + "\n");
        calcularRecursos();
        seleccionarRecursos();
        System.out.println("\n Ahora debes escojer la opcion de iniciar viaje. ");
        return naveElegida;
        
    }

    // feat: Luisa Leon se agrega iniciar viaje
    public static void iniciarViaje() {
        System.out.println("Iniciando simulacion de viaje... \n ");
        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Error: no ha seleccionado planeta o nave. ");
            return;
        }
        //calcularRecursos(); fix: Nathalia, llamo las funciones desde la funcion seleccionar nave
        //calcularViaje(); // feat: Luisa Leon se agrega funcion
        //seleccionarRecursos(); // fiat: Luisa Leon se agrega funcion
        System.out.println("El viaje a " + planetaEscogido + " ha comenzado! \n");
        seleccionEventoAleatorio();
        System.exit(0); // Feat: Luisa Leon cierre de ciclo
    }

    public static void seleccionarPasajeros() {
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Por favor, ingrese la cantidad de pasajeros: ");
            if (scanner.hasNextInt()) {
                pasajeros = scanner.nextInt();
                if (pasajeros > 0) {
                    entradaValida = true;
                    System.out.print("la cantidad de pasajeros es: " + pasajeros + "\n");
                    System.out.println("\nAhora debes escogert tu nave. \n");
                } else {
                    System.out.println("el numero ingresado debe ser un numero positivo");
                }
            } else {
                scanner.next();
            }

        }
    }
    // feat:Luisa Leon se agrega calcular recursos

    public static void calcularRecursos() {
        DistanciaPlaneta = distancias[seleccionPlaneta - 1];
        int indiceNave = java.util.Arrays.asList(naves).indexOf(naveElegida);
        combustibleNecesario = DistanciaPlaneta * pasajeros * consumoDeCombustible[indiceNave];
        oxigenoNecesario = DistanciaPlaneta * pasajeros * consumoDeOxigeno[indiceNave];

        System.out.println("Recursos necesarios de viaje:");
        System.out.println("_____________________");
        // fix: Nathalia borra mostrar indice y distancia

        System.out.println("_____________________");
        System.out.println("Combustible Necesario: " + combustibleNecesario + " Litros");
        System.out.println("Oxigeno Necesario: " + oxigenoNecesario + " Litros");

        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Elija un planeta y una nave primero");
            return;
        }
    }
    // feat:luisa Leon seleccionar recursos

    // fix: Natalia, corrige la funcion de seleccionnar recursos
    public static void seleccionarRecursos() {
        System.out.println("\nPor favor, introduzca los recursos disponibles: ");
        System.out.println("_____________________");
        System.out.println("Ingrese el combustible disponible:  ");
        combustibleDisponible = scanner.nextDouble();

        System.out.println("Ingrese el oxigeno disponible:  ");
        oxigenoDisponible = scanner.nextDouble();
        System.out.println("_____________________");
        if (combustibleDisponible >= combustibleNecesario && oxigenoDisponible >= oxigenoNecesario) {
            System.out.println("Los recursos son suficientes para el viaje");
        } else {
            System.out.println("\nLos recursos son insuficientes, Ingrese los datos nuevamente ");

            if (combustibleDisponible < combustibleNecesario) {
                System.out.println("Debe aumentar el combustible ");
                combustibleDisponible = scanner.nextDouble();
            }
            if (oxigenoDisponible < oxigenoNecesario) {
                System.out.println("Debe aumentar el oxigeno ");
                oxigenoDisponible = scanner.nextDouble();
            }
        }
    }

    // metodos auxiliares

    public static void detallesEleccion() {
        // feat: Nathalia Bravo, Agrego la funcion de mostrar la descripcion del planeta
        // escogido
        String detallePlaneta = "";
        double distancia = 0;
        for (int i = 0; i < composicion.length; i++) {
            if (seleccionPlaneta > 0 && seleccionPlaneta <= composicion.length) {
                detallePlaneta = composicion[seleccionPlaneta - 1];
            }
            if (seleccionPlaneta > 0 && seleccionPlaneta <= distancias.length) {
                distancia = distancias[seleccionPlaneta - 1];
            }
        }
        System.out.println(planetaEscogido + " es un planeta " + detallePlaneta + " Con una distancia de " + distancia
                + " kilometros.\n ");

    }

    // feat: Luisa Leon se agrega una nueva funcion
    // fix: Nathalia ajusta la funcion calcular viaje
    public static void calcularViaje() {
        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Primero debe elegir un planeta y nave");
        }
        double duracionHoras = DistanciaPlaneta / Velocidades[0];
        System.out.println("Duracion horas " + duracionHoras);
    }

    public static void imprimirInfoPlanetas() {
        // feat: Nathalia Bravo, Agrego la funcion de mostrar info de todos los planetas
        System.out.println("Descripcion de planetas: \n ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println("El planeta " + planetas[i] + " esta a una distancia de la tierra de " + distancias[i]
                    + " y es un planeta " + composicion[i]);
        }
        System.out.println();

        System.out.println("Ahora debes escoger tu planeta destino. \n");
    }

    public static void seleccionEventoAleatorio() {
        System.out.println("¡¡¡UN EVENTO EXTRAORDINARIO HA OCURRIDO!!! \n ");
        int indiceEvento = random.nextInt(eventos.length);
        eventoAleatorio = eventos[indiceEvento];

        switch (indiceEvento) {
            case 0:
                System.out.println("La " + eventoAleatorio + " esta afectando el combistible");
                combustibleDisponible -= 50;
                System.out.println("Queda disponible " + combustibleDisponible
                        + " litros y se necesita " + combustibleNecesario + " litros");
                System.out.println("Debe aumentar el combustible ");
                combustibleDisponible += scanner.nextDouble();
                if (combustibleDisponible > combustibleNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                }else{
                    System.out.println("Se agoto el combustible, no se pudo llegar al destino ");
                }
                break;

            case 1:
                System.out.println( eventoAleatorio + " Puede haber una pérdida de potencia, se necesita mas combustible, ");
                combustibleDisponible -= 50;
                System.out.println("Debe aumentar el combustible queda " + combustibleDisponible + 
                " litros y se necesita " +  combustibleNecesario);
                combustibleDisponible += scanner.nextDouble();
                if (combustibleDisponible > combustibleNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                }else {
                    System.out.println("Se agoto el combustible, no se pudo llegar al destino ");
                }
                break;

            case 2:
                System.out.println(eventoAleatorio + " Avisar a la torre de control, pulse 1 para confirmar ");
                 int confirmacion = scanner.nextInt();
                 if (confirmacion == 1 ) {
                    System.out.println("Problema resuelto, siga su viaje.");
                 }else{
                    System.out.println("Su nave de dirige a la tierra nuevamente, no se pudo llegar a su destino");
                 }
                break;

            case 3:
                System.out.println("La " + eventoAleatorio + 
                " esta afectando la vision de la nave, debe activar los ventiladores, presione 1 para confirmar ");
                confirmacion = scanner.nextInt();
                System.out.println("Debe aumentar el oxigeno, se agota, oxigeno disponible: " + (oxigenoDisponible - 30) + 
                " litros. y se necesita " + oxigenoNecesario + " litros.");
                oxigenoDisponible += scanner.nextDouble();
                if (confirmacion == 1 & oxigenoDisponible > oxigenoNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                 }else if (oxigenoDisponible < oxigenoNecesario) {
                    System.out.println("Su nave se quedo sin oxigeno, no se puedo completar el viaje");
                 } else{
                    System.out.println("Su nave no tiene visibilidad, se perdio el rumbo y quedo a la deriva");
                 }
                
                if (oxigenoDisponible < oxigenoNecesario) {
                    System.out.println("Se agoto el oxigeno, no se pudo llegar al destino ");
                }
                break;

            case 4:
                System.out.println("Peligro!!  " + eventoAleatorio + " Cambiar direccion de la nave y activar modo potencia, presione 1 ");
                confirmacion = scanner.nextInt();
                if (confirmacion == 1) {
                    System.out.println("Problema resuelto, siga su viaje.");
                }

                break;
           
        }

    }

}
