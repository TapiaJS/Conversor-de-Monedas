import calculos.ConversorDeMonedas;
import colors.Colors;
import consumodeapi.ConsultaDivisa;
import consumodeapi.Divisa;
import modelos.Moneda;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner m = new Scanner(System.in);

    public static double getDouble(String mensaje, String error, double min, double max) {

        double valor;

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (m.hasNextDouble()) {
                valor = m.nextDouble();
                if (valor < min || valor > max) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return valor;
                }
            } else {
                m.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static int getInt(String mensaje, String error, int min, int max) {
        int valor;

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (m.hasNextInt()) {
                valor = m.nextInt();

                if (valor < min || max < valor) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return valor;
                }
            } else {
                m.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static void conversorDeDivisa(String divisa,double valor ,String divisaAConvertir){
        Divisa divisasDeLaMoneda = ConsultaDivisa.buscarTasaDeCambioDeLaMoneda(divisa);
        List<Moneda> monedas = Moneda.generarListaDeMonedas(divisasDeLaMoneda);

        for (Moneda moneda : monedas){
            if(moneda.getMoneda().equals(divisaAConvertir)){
                String resultado = ConversorDeMonedas.conversorDeMoneda(valor, divisa, moneda);
                Colors.println(resultado, Colors.HIGH_INTENSITY);
                break;
            }
        }
    }

    public static void main(String[] args) {

        StringBuilder menu = new StringBuilder();
        menu.append("******************************************************\n");
        menu.append("Sea bienvenido/a al Conversor de Moneda\n\n");
        menu.append("1) Dólar ===> Peso argentino\n");
        menu.append("2) Peso argentino ===> Dólar\n");
        menu.append("3) Dólar ===> Real brasileño\n");
        menu.append("4) Real brasileño ===> Dólar\n");
        menu.append("5) Dólar ===> Peso colombiano\n");
        menu.append("6) Peso colombiano ===> Dólar\n");
        menu.append("7) Salir\n");
        menu.append("Elija una opción válida:\n");
        menu.append("******************************************************\n");

        int opcion;
        String error = "Por favor ingresa una opcion valida.";
        String mensajeParaConvertir = "Ingrese el valor que deseas convertir:";
        double min = -Double.MAX_VALUE;
        double max = Double.MAX_VALUE;

        do {
            opcion = getInt(menu.toString(),error , 1, 7);
            double valor;
            switch (opcion){
                case 1:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("USD",valor , "ARS");
                    break;
                case 2:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("ARS", valor, "USD");
                    break;
                case 3:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("USD", valor, "BRL");
                    break;
                case 4:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("BRL", valor, "USD");
                    break;
                case 5:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("USD", valor, "COP");
                    break;
                case 6:
                    valor = getDouble(mensajeParaConvertir, error, min, max);
                    conversorDeDivisa("COP", valor, "USD");
                    break;
                case 7:
                    Colors.println("¡Hasta luego!", Colors.BLUE);
                    break;
                default:
                    Colors.println("Opción no válida. Inténtalo de nuevo.", Colors.RED);
                    break;
            }
        } while (opcion != 7);
    }
}