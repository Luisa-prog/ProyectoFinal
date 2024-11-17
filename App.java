import java.util.Scanner;

public class App {


    static Scanner scanner = new Scanner (System.in);
    static String [] planetas = {"Mercurio", "Venus", "Marte","Jupiter","Saturno","Urano","Neptuno","Pluton"};
    static Double [] distancia = {91.69, 41.4 ,78.34,  628.73, 1275.0, 2723.0, 4351.0, 5906.0 };
    //se realiza la composicion y detalle de cada planeta 
    static String [] composicion = {
                "Rocoso, sin atmosfera",
                "Rocoso, atmosfera densa", 
                "rocoso, atmosfera delgada", 
                "Gaseoso, compuesto principalmente de nitrogeno y helio", 
                "Gaseoso, conocido por sus anillos",
                "Gaseoso, atmosfera de hidrogeno y helio", 
                "Gaseoso, Atmosfera de hidrogeno, helio y metano", 
                "Rocoso, compuesto de hielo y roca"
            };

    static String [] naves ={"exploradora", "recolectora", "carga pesada", "velocidad maxima"};
    static Double [] Velocidad = {1000.0, 400.0 ,200.0, 1500.0 };


    public static void main (String []args) throws Exception{
        int opcion;
        do{
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    seleccionarPlaneta();
                    break;
                case 2:
                    seleccionarNave();
                    break;
                case 3:
                    seleccionarPasajeros();
                    break;
                case 4:
                    seleccionarRecursos();
                    default:
                break;
            }
            
            
        }while (opcion !=4);
    }
        public static void mostrarMenu(){


        };
        public static void seleccionarPlaneta(){


        };

        public static void seleccionarNave(){


        };

        public static void seleccionarPasajeros(){
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("por favor, ingrese la cantidad de pasajeros: ");
                if (scanner.hasNextInt()) {
                    int cantidadPasajeros = scanner.nextInt();
                    if (cantidadPasajeros > 0){
                        entradaValida = true;
                        System.out.println("la cantidad de pasajeros es: "+ cantidadPasajeros );
                        } else {
                            System.out.println("el numero ingresado debe ser un numero positivo");
                        }
                }else{
                    System.out.println("el numero ingresado debe ser un numero entero");
                    scanner.next();

                }
            }

            }

        };

        public static void seleccionarRecursos(){

        };

        //metodos auxiliares
        public static void detalles (String[] arreglo){


        }
        public static void eventosAleatorios (String[] arreglo){

        }
    
