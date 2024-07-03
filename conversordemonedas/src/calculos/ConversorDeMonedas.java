package calculos;

import modelos.Moneda;

public class ConversorDeMonedas {
    public static String conversorDeMoneda(double valor, String divisa, Moneda moneda){
        return  "El valor " + valor + " [" + divisa +"] corresponde al valor final de =>>> " +
                valor * moneda.getTasaDeCambio() + " [" + moneda.getMoneda() + "]";
    }
}
