import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno",
            "Pluton." };
            //Listas que almacenan los planetas disponibles, sus distancias desde la Tierra y sus características.
    static Double[] distancias = { 777000.000, 41000.400, 78000.340, 628000.730, 1275000.000, 2723000.000, 4351000.000, 5906000.000 };
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
    // Información sobre las naves espaciales, sus velocidades y el consumo de recursos.
    static String[] naves = { "Exploradora", "Recolectora", "Carga Pesada", "Velocidad Maxima" };
    static Double[] Velocidades = { 1000.0, 400.0, 200.0, 1500.0 };
    static Double[] consumoDeCombustible = { 0.05, 0.1, 0.2, 0.3 };
    static Double[] consumoDeOxigeno = { 0.1, 0.15, 0.20, 0.25 };

    // Lista de eventos aleatorios que pueden ocurrir durante el viaje.
    static String[] eventos = {
            "Lluvia de meteoritos",
            "Fallo el sistema de propulsion",
            "Desvio del planeta destino",
            "Tormenta de polvo",
            "Agujero negro",
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
    static int seleccion;

    //Utiliza un bucle do-while para continuar mostrando el menú hasta que el usuario elija salir.
    public static void main(String[] args) throws Exception {
        System.out.println("╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣");
        System.out.println(" Bienvenido a su viaje interplanetario ");
        System.out.println("╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣╣");
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
        // Mostrar información de planetas.
        // Seleccionar un planeta de destino.
        // Seleccionar una nave.
        // Iniciar la simulación del viaje.
        // Salir del programa.
        System.out.println("\n ------ MENU PRINCIPAL--------"); 
        System.out.println("1.Imprimir informacion de planetas");
        System.out.println("2.Seleccionar un planeta de destino.");
        System.out.println("3.Seleccionar una nave espacial.");
        System.out.println("4.Iniciar la simulación del viaje interplanetario. ");
        System.out.println("5.Salir");
        System.out.println("Seleccione una opcion entre 1 y 4. \n");
    }

    public static String seleccionarPlaneta(String[] planetas, Scanner escanner) {
        // funcion seleccionar el planeta
        System.out.println("Los planetas disponibles son: ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.print((i + 1) + "." + planetas[i] + ". " + "\n");
        }
        System.out.println();
        // Eleccion de planeta
        System.out.println("Elige tu planeta, introduce un numero entre (1 - 8) \n");
        seleccionPlaneta = scanner.nextInt();
        if (seleccionPlaneta > 0 && seleccionPlaneta <= planetas.length) {
            planetaEscogido = planetas[seleccionPlaneta - 1];
            System.out.println("Planeta escogido: " + planetaEscogido);
            detallesEleccion();
            seleccionarPasajeros();//  se agrega variable pasajero1

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
            System.out.print((i + 1) + "." + naves[i] + ", Su velocidad es : "+ Velocidades[i]  + " KM/H  "+ "\n"); 
                                                                  
        }
       
        seleccion = 0;
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

        System.out.println("\n Ahora debes escojer la opcion de iniciar viaje. ");
        return naveElegida;

    }

    //  se agrega iniciar viaje para inicio de simulacion
    public static void iniciarViaje() {
        System.out.println("Iniciando simulacion de viaje... \n ");
        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Error: no ha seleccionado planeta o nave. ");
            return;
        }
        calcularRecursos();// se realiza el calculo de recursos al inciar viaje
        calcularViaje();// se imprime la distancia a dias de pendiendo los km
        seleccionarRecursos();// se pide al usuario seleccionar recursos
        realizarSimulacion(); // para inciar simulacion
        
    
        
        System.exit(0); // para cerrar ciclo al simular viaje
    }

    public static void seleccionarPasajeros() {
        boolean entradaValida = false;
        //se realiza whie para seleccionar pasajeros
        while (!entradaValida) {
            System.out.println("Por favor, ingrese la cantidad de pasajeros: ");
            if (scanner.hasNextInt()) {
                pasajeros = scanner.nextInt();
                if (pasajeros > 0) {
                    entradaValida = true;
                    System.out.print("la cantidad de pasajeros es: " + pasajeros + "\n");
                    System.out.println("\nAhora debes escogert tu nave. \n");
                    //condicion de numero positivo
                } else {
                    System.out.println("el numero ingresado debe ser un numero positivo");
                }
            } else {
                scanner.next();
            }

        }
    }
    //  se agrega calcular recursos

    public static void calcularRecursos() {
        DistanciaPlaneta = distancias[seleccionPlaneta - 1];
        int indiceNave = java.util.Arrays.asList(naves).indexOf(naveElegida);
        combustibleNecesario = DistanciaPlaneta * pasajeros * consumoDeCombustible[indiceNave];
        oxigenoNecesario = DistanciaPlaneta * pasajeros * consumoDeOxigeno[indiceNave];

        System.out.println("Recursos necesarios de viaje:");
        System.out.println("_____________________");
        // se imprime los recursos necesarios para el viaje

        System.out.println("_____________________");
        System.out.println("Combustible Necesario: " + combustibleNecesario + " Litros");
        System.out.println("Oxigeno Necesario: " + oxigenoNecesario + " Litros");

        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Elija un planeta y una nave primero");
            return;
        }
    }
    // condicion de no realizar el calculo de recursos sin haber elegido planeta y nave primero

     //funcion seleccionar recursos
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
        // se Agrego la funcion de mostrar la descripcion del planeta
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

    //  se agrega una nueva funcion de calcular viaje
    public static void calcularViaje() {
        if (planetaEscogido == null || naveElegida == null) {
            System.out.println("Primero debe elegir un planeta y nave");
        }
        double duracionHoras = (DistanciaPlaneta / Velocidades[seleccion -1 ]);
        double dias = duracionHoras /24;
        double diascompletos=Math.round(dias);
        System.out.println("Duracion del viaje:  " + diascompletos +" dias.");
        
    }

    public static void realizarSimulacion() {
        double duracionHoras = DistanciaPlaneta / Velocidades[seleccion -1];
        int diasCompletos = (int) Math.ceil( duracionHoras /24 );
        int eventosOcurridos = 0;
        for (int dia =1; dia <= diasCompletos; dia++) {
            double progreso = (double) dia / diasCompletos * 100;
            if (dia ==1){
                System.out.println("Dia " + dia + ": Inicio del viaje");
                
            }else if (dia == diasCompletos /2) {
                    System.out.println( "Dia " + dia + ": Mitad del viaje");

                } else if (dia  == diasCompletos){
                    System.out.println( "dias " + dia + ": LLeegada al destino");

                }
                if (eventosOcurridos < 2 && random.nextInt(diasCompletos)==dia -1){
                    seleccionEventoAleatorio();
                    eventosOcurridos++;
                }
                mostrarBarra(progreso);
                try {
                    Thread.sleep(200); //pausa para visualizar barra
                } catch (InterruptedException e){
                    e.printStackTrace();

                }
            }
            System.out.println("______________________________");

            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("\n ¡¡¡ viaje completado!!!");

            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        }
        public static void mostrarBarra(double progreso) {
            int longitudBarra =50;
            int completado = (int) (longitudBarra * progreso /100);
            int restante = longitudBarra -  completado;

            String barra = "[" + "▄".repeat(completado) + " ".repeat(restante) + "]";
            System.out.println("\r" + barra + " " + String.format("%.2f", progreso) + "%");

        }

    public static void imprimirInfoPlanetas() {
        // feat: Nathalia Bravo, Agrego la funcion de mostrar info de todos los planetas
        System.out.println("Descripcion de planetas: \n ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.println("El planeta " + planetas[i] + " esta a una distancia de la tierra de " + distancias[i]
                    + " KM y es un planeta " + composicion[i]);
        }
        System.out.println();
        System.out.println("Ahora debes escoger tu planeta destino. \n");
    }

    //feat: Nathalia agrga la funcion de crear un evento
    public static void seleccionEventoAleatorio() {
        System.out.println("¡¡¡UN EVENTO EXTRAORDINARIO HA OCURRIDO!!! \n ");
        int indiceEvento = random.nextInt(eventos.length);
        eventoAleatorio = eventos[indiceEvento];
        switch (indiceEvento) {
            case 0:
                System.out.println("La " + eventoAleatorio + " esta afectando el combistible.");
                combustibleDisponible -= 50000;
                System.out.println("Queda disponible " + combustibleDisponible
                        + " litros y se necesita " + combustibleNecesario + " litros.");
                System.out.println("Debe aumentar el combustible. ");
                combustibleDisponible += scanner.nextDouble();
                if (combustibleDisponible > combustibleNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                } else {
                    System.out.println("Se agoto el combustible, no se pudo llegar al destino. ");
                }
                break;

            case 1:
                System.out.println(
                        eventoAleatorio + ", Puede haber una pérdida de potencial, se necesita mas combustible, ");
                combustibleDisponible -= 50000;
                if (combustibleDisponible < 0) {
                    combustibleDisponible = 0.0;
                }
                System.out.println("Debe aumentar el combustible, queda " + combustibleDisponible +
                        " litros y se necesita " + combustibleNecesario + " litros.");
                combustibleDisponible += scanner.nextDouble();
                if (combustibleDisponible > combustibleNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                } else {
                    System.out.println("Se agoto el combustible, no se pudo llegar al destino. ");
                }
                break;

            case 2:
                System.out.println(eventoAleatorio + ", debe avisar a la torre de control, pulse 1 para confirmar. ");
                int confirmacion = scanner.nextInt();
                if (confirmacion == 1) {
                    System.out.println("Problema resuelto, siga su viaje.");
                } else {
                    System.out.println("Su nave de dirige a la tierra nuevamente, no se pudo llegar a su destino.");
                }
                break;

            case 3:
                System.out.println("La " + eventoAleatorio +
                        " esta afectando la vision de la nave, debe activar los ventiladores, presione 1 para confirmar. ");
                confirmacion = scanner.nextInt();
                oxigenoDisponible -= 10000;
                if (oxigenoDisponible < 0) {
                    oxigenoDisponible = 0.0;
                }
                System.out.println("Debe aumentar el oxigeno, se agota, oxigeno disponible: " +oxigenoDisponible  +
                                " litros. y se necesita " + oxigenoNecesario + " litros.");
                oxigenoDisponible += scanner.nextDouble();
                if (confirmacion == 1 & oxigenoDisponible > oxigenoNecesario) {
                    System.out.println("Problema resuelto, siga su viaje.");
                } else if (oxigenoDisponible < oxigenoNecesario) {
                    System.out.println("Su nave se quedo sin oxigeno, no se puedo completar el viaje.");
                } else {
                    System.out.println("Su nave no tiene visibilidad, se perdio el rumbo y quedo a la deriva.");
                }
                if (oxigenoDisponible < oxigenoNecesario) {
                    System.out.println("Se agoto el oxigeno, no se pudo llegar al destino. ");
                }
                break;

            case 4:
                System.out.println("Peligro!!  " + eventoAleatorio
                        + ", debe cambiar direccion de la nave y activar modo potencia, presione 1.");
                confirmacion = scanner.nextInt();
                if (confirmacion == 1) {
                    System.out.println("Problema resuelto, siga su viaje.");
                } else {
                    System.out.println("Su nave se perdio en el agujeo negro.");
                }

                break;

        }

    }

}
