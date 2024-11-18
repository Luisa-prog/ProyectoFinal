import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = { "Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno", "Pluton" };
    static Double[] distancia = { 91.69, 41.4, 78.34, 628.73, 1275.0, 2723.0, 4351.0, 5906.0 };
    // se realiza la composicion y detalle de cada planeta
    static String[] composicion = {
            "Rocoso, sin atmosfera",
            "Rocoso, atmosfera densa",
            "rocoso, atmosfera delgada",
            "Gaseoso, compuesto principalmente de nitrogeno y helio",
            "Gaseoso, conocido por sus anillos",
            "Gaseoso, atmosfera de hidrogeno y helio",
            "Gaseoso, Atmosfera de hidrogeno, helio y metano",
            "Rocoso, compuesto de hielo y roca"
    };
    // feat: luisa Leon: agrego array consumo recursos a naves
    static String[] naves = { "Exploradora", "Recolectora", "Carga Pesada", "Velocidad Maxima" };
    static Double[] Velocidad = { 1000.0, 400.0, 200.0, 1500.0 };
    static Double[] consumoDeCombustible ={0.5, 1.0, 2.0, 2.5};
    static Double[] consumoDeOxigeno ={1.0, 1.0, 1.5, 2.0};

    static String planetaEscogido;
    static int seleccionPlaneta;
    static String naveElegida;
    static int pasajeros;


    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido a su viaje interplanetario");
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    planetaEscogido = seleccionarPlaneta(planetas,scanner);
                    break;
                case 2:
                    naveElegida = seleccionarNave(naves, scanner);
                    break;
                case 3:
                   // docs: Nathalia Bravo, llamo la funcion iniciar la simulacion del viaje por seleccionar pasajeros
                    iniciarViaje();
                    break;
                case 4:
                System.out.println("programa finalizado con exito!");
                    break;
                //fix: Luisa Leon: Se agrega caso 4 por menu
            
                default:
                System.out.println("Debe elegir una opcion entre 1 y 4.");
                    break;
            }

        } while (opcion != 4);
        }

    public static void mostrarMenu() {
        //fea: Nathalia Bravo, creacion del menu
        System.out.println("\n ---------Menu Principal----------");
        System.out.println("1.Seleccionar un planeta de destino.");
        System.out.println("2.Seleccionar una nave espacial.");
        System.out.println("3.Iniciar la simulación del viaje interplanetario. ");
        System.out.println("4.Salir");
        System.out.println("Seleccione una opcion entre 1 y 4. \n");
    }

    public static String seleccionarPlaneta(String[] planetas, Scanner escanner) {
        //feat: Nathalia Bravo, agrego la funcion seleccionar el planeta
        System.out.println("Los planetas disponibles son: ");
        for (int i = 0; i < planetas.length; i++) {
            System.out.print( (i+1 ) + "." + planetas[i] + " " + "\n" );
        }
        System.out.println();
        //Eleccion de planeta
        System.out.println("Elige tu planeta, introduce un numero entre (1 - 8) \n");
            seleccionPlaneta = scanner.nextInt();
            if (seleccionPlaneta > 0 && seleccionPlaneta <= planetas.length) {
                planetaEscogido = planetas[seleccionPlaneta-1];
                System.out.println("Planeta escogido: " + planetaEscogido);
                detalles(composicion);
                seleccionarPasajeros();//fix: se agrega variable pasajero1


            } else{
                System.out.println("Debe escoger una opcion entre 1 y 8.");
                seleccionarPlaneta(planetas, escanner);
            }
            
            return planetaEscogido;
    }

    public static String seleccionarNave(String[] naves, Scanner scanner) {
        //feat: Nahalia Bravo, agrego la funcion seleccionar nave
        System.out.println("Las naves disponibles para su viaje a "+ planetaEscogido + " son: " );
        for (int i = 0; i < naves.length; i++) {
            System.out.print( (i+1 ) + "." + naves[i] + " " + "\n" ); //fix: Luisa Leon: se quita el espacio (se deja como comentario) " " + "\n"// Mostrar lista de naves
        }
        //fix Luisa leon: se elimina sout (se deja comentario) System.out.println();
        //Eleccion de nave
        //feat: se realiza nueva variable
        int seleccion = 0;
        boolean entradaValida = false;
        // feat: se agrega un while
        while (!entradaValida) {
            System.out.println("Elige una nave, introduce un numero entre 1 y 4 \n");
            if (scanner.hasNextInt()) {
                seleccion=scanner.nextInt();
                if (seleccion > 0 && seleccion <=naves.length) {
                    entradaValida = true;
                    
                } else {
                    System.out.println("Debe escoger una opcion entre 1 y 4.");
                }
        }else {
                System.out.println("entrada invalida, introduzca un numero entero. ");
                scanner.next();
        }
        }
        naveElegida=naves[seleccion-1];
        System.out.println("la nave escogida es: " + naveElegida);
        return naveElegida;
        }


     //feat: Luisa Leon se agrega iniciar viaje
    public static void iniciarViaje(){
        System.out.println("Iniciando simulacion de viaje...");
        if (planetaEscogido == null || naveElegida == null){
            System.out.println("error: no ha seleccionado planeta o nave. ");
        return;
        }
        calcularRecursos();
        System.out.println("el viaje a " + planetaEscogido + "ha comenzado!");

    }
    public static void seleccionarPasajeros() {
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Por favor, ingrese la cantidad de pasajeros: ");
            if (scanner.hasNextInt()) {
                double cantidadPasajeros = scanner.nextDouble();
                if (cantidadPasajeros > 0) {
                    entradaValida = true;
                    System.out.print("la cantidad de pasajeros es: " + cantidadPasajeros + "\n");
                } else {
                    System.out.println("el numero ingresado debe ser un numero positivo");
                }
            } else {
                scanner.next();

            }
        }
        }
    //feat:Luisa Leon se agrega calcular recursos

    public static void calcularRecursos() {
        double DistanciaViaje = distancia [seleccionPlaneta- 1];
        int indiceNave = java.util.Arrays.asList(naves).indexOf(naveElegida);
        Double combustibleNecesario = DistanciaViaje * pasajeros *consumoDeCombustible [indiceNave];
        Double oxigenoNecesario = DistanciaViaje * pasajeros * consumoDeOxigeno [indiceNave];
        
        System.out.println("recursos necesarios:");
        System.out.println("indice: " + indiceNave);
        System.out.println("distancia: "+ DistanciaViaje );
        System.out.println("combustible: "+ combustibleNecesario + "Litros");
        System.out.println("oxigeno: " + oxigenoNecesario + "Litros");
        
    if(planetaEscogido==null||naveElegida == null){
        System.out.println("elija un planeta y una nave primero");
    return;
    }
    }
    //feat:luisa Leon seleccionar recursos

    public static void seleccionarRecursos (){
        System.out.println("por favor, seleccione los recursos dsiponibles: ");

        System.out.println("ingrese el combustible:  ");
        Double combustibleDisponible = scanner.nextDouble ();

        System.out.println("ingrese el oxigeno:  ");
        Double oxigenoDisponible = scanner.nextDouble ();

        System.out.println("\n Cluclando los recursos necesarios para el viaje...  ");

    }

    
    // metodos auxiliares
    
    

    public static void detalles(String[] composicion) {
        // feat: Nathalia Bravo, Agrego la funcion de mostrar la descripcion del planeta escogido
        String detallePlaneta="";
        for (int i = 0; i < composicion.length; i++) {
            if (seleccionPlaneta > 0 && seleccionPlaneta <= composicion.length) {
                detallePlaneta = composicion[seleccionPlaneta-1];
            }
        }
        System.out.println(planetaEscogido + " es un planeta " + detallePlaneta +"\n ");

    }

    public static void eventosAleatorios(String[] arreglo) {

    }
}
