import java.util.Scanner;

public class App {


    static Scanner scanner = new Scanner (system.in);
    static String [] planetas = {"Mercurio", "Venus", "Marte","Jupiter","Saturno","Urano","Neptuno","Pluton"};
    static Double [] distancia = {91.69, 41.4 ,78.34, 628.73, 1275.0, 2723.0, 4351.0, 5906.0 };

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
                seleccionarDestino();
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

        public static void seleccionarDestino(){

        };

        public static void seleccionarRecursos(){

        };

        public static void imprimirArregloString(String[] arreglo){
            
        }
    }
