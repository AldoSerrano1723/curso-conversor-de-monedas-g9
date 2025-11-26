import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        //VARIABLES
        var menuPrincipal = new InterfazUsuario();
        var consulta = new ConsultarMoneda();
        Scanner sc = new Scanner(System.in);
        double cantidad = 0;
        int opcionMenu = 0;

        //EMPEZANDO PROGRAMA
        while (opcionMenu != 7){
            String monedaBase = null;
            String monedaObjetivo = null;
            menuPrincipal.iniciarMenu();
            try{
                opcionMenu = sc.nextInt();
                switch (opcionMenu){
                    //MXN ➔ USD (Dólar)
                    case 1:
                        monedaBase = "MXN";
                        monedaObjetivo = "USD";
                        break;

                    //MXN ➔ EUR (Euro)
                    case 2:
                        monedaBase = "MXN";
                        monedaObjetivo = "EUR";
                        break;

                    //MXN ➔ GBP (Libra Esterlina)
                    case 3:
                        monedaBase = "MXN";
                        monedaObjetivo = "GBP";
                        break;

                    //USD ➔ MXN (Peso Mexicano)
                    case 4:
                        monedaBase = "USD";
                        monedaObjetivo = "MXN";
                        break;

                    //USD ➔ BRL (Real Brasileño)
                    case 5:
                        monedaBase = "USD";
                        monedaObjetivo = "BRL";
                        break;

                    //USD ➔ COP (Peso Colombiano)
                    case 6:
                        monedaBase = "USD";
                        monedaObjetivo = "COP";
                        break;

                    //SALIR
                    case 7:
                        System.out.println("SALIENDO");
                        opcionMenu = 7;
                        break;

                    default:
                        System.out.println("OPCION NO VALIDA");
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR: INGRESA SOLO NUMEROS, NO LETRAS");
                sc.next();
            }

            if (monedaBase != null && monedaObjetivo != null){
                try {
                    System.out.println("INGRESE LA CANTIDAD A CONVERTIR DE " + monedaBase + " A " + monedaObjetivo);
                    cantidad = sc.nextDouble();
                    ResultadoConversion resultadoConversion = consulta.convertir(monedaBase, monedaObjetivo, cantidad);
                    System.out.println("--------CONVERSION REALIZADA--------\n");
                    System.out.println("$ " + cantidad + " [" + monedaBase + "]  ──➜   $ " +  resultadoConversion.conversion_result() + " [" + monedaObjetivo + "]");
                    System.out.println("\n-----------------------------------\n");

                }catch (InputMismatchException e){
                    System.out.println("ERROR: INGRESA SOLO NUMEROS, NO LETRAS");
                    sc.next();
                }catch (Exception e){
                    System.out.println("OCURRIO UN PROBLEMA INESPERADO");
                }
            }
        }
        System.out.println("GRACIAS POR USAR 'CONVERT3000, HASTA LUEGO'");
    }
}
