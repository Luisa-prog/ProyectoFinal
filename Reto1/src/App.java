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

    static String[] naves = { "Exploradora", "Recolectora", "Carga Pesada", "Velocidad Maxima" };
    static Double[] Velocidad = { 1000.0, 400.0, 200.0, 1500.0 };
    static String planetaEscogido;
    static int seleccionPlaneta;
    static String naveElegida;


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
                    iniciarVijae();
                    break;
                case 4:
                    break;
                default:
                System.out.println("Debe elegir una opcion entre 1 y 4.");
                    break;
            }

        } while (opcion != 4);
        System.out.println("¿Programa finalizado con exito!");
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
            System.out.print( (i+1 ) + "." + planetas[i]+ " " + "\n"); // Mostrar lista de planetas 
        }
        System.out.println();
        //Eleccion de planeta
        System.out.println("Elige tu planeta, introduce un numero entre (1 - 8) \n");
             seleccionPlaneta = scanner.nextInt();
            if (seleccionPlaneta > 0 && seleccionPlaneta <= planetas.length) {
                planetaEscogido = planetas[seleccionPlaneta-1];
                System.out.println("Planeta escogido: " + planetaEscogido);
                detalles(composicion);// llama la funcion que muestra los detalles del planeta
            } else{
                System.out.println("Debe escoger una opcion entre 1 y 8.");
                seleccionarPlaneta(planetas, escanner);
            }
           //docs: Nathalia Bravo, llamo la funcion seleccionarPasajeros();
            seleccionarPasajeros();
            return planetaEscogido;
    }

    public static String seleccionarNave(String[] naves, Scanner scanner) {
        //feat: Nahalia Bravo, agrego la funcion seleccionar nave
        System.out.println("Las naves disponibles para su viaje a "+ planetaEscogido + " son: " );
        for (int i = 0; i < naves.length; i++) {
            System.out.print( (i+1 ) + "." + naves[i]+ " " + "\n");  // Mostrar lista de naves
        }
        System.out.println();
        //Eleccion de nave
        System.out.println("Elige una nave, introduce un numero entre 1 y 4 \n");
        int seleccion = scanner.nextInt();
        if (seleccion >= 0 && seleccion <= naves.length) {
            naveElegida = naves[seleccion-1];
            System.out.println("La nave escogida es: " + naveElegida);
        }else{
            System.out.println("Debe escoger una opcion entre 1 y 4.");
            seleccionarNave(naves, scanner);
        }
        seleccionarRecursos(); // docs: Nathalia bravo llamo la funcion desde el metodo selecionar nave
        return naveElegida;
    }


    public static void iniciarVijae(){

    }

    public static void seleccionarRecursos() {

    }

    // metodos auxiliares
    public static void seleccionarPasajeros() {
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("Por favor, ingrese la cantidad de pasajeros: ");
            if (scanner.hasNextInt()) {
                int cantidadPasajeros = scanner.nextInt();
                if (cantidadPasajeros > 0) {
                    entradaValida = true;
                    System.out.print("la cantidad de pasajeros es: " + cantidadPasajeros + "\n"); 
                } else {
                    System.out.println("el numero ingresado debe ser un numero positivo");
                }
            } else {
                System.out.println("el numero ingresado debe ser un numero entero");
                scanner.next();

            }
        }
    }

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
