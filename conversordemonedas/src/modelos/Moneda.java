package modelos;

import consumodeapi.Divisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Moneda {
    private String moneda;
    private double tasaDeCambio;

    private static List<String> monedasDisponibles = new ArrayList<>();

    public Moneda(String moneda, double tasaDeCambio) {
        this.moneda = moneda;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public static void agregarMonedasIniciales(){
        monedasDisponibles.add("USD");
        monedasDisponibles.add("ARS");
        monedasDisponibles.add("BRL");
        monedasDisponibles.add("COP");
    }

    public static List<Moneda> generarListaDeMonedas(Divisa divisa) {
        List<Moneda> monedas = new ArrayList<>();
        for (Map.Entry<String, Double> entry : divisa.conversion_rates().entrySet()) {
            agregarMonedasIniciales();
            for (String posibleMoneda : monedasDisponibles){
                if(entry.getKey().equals(posibleMoneda)){
                    Moneda moneda = new Moneda(entry.getKey(), entry.getValue());
                    monedas.add(moneda);
                    break;
                }
            }
        }
        return monedas;
    }

    @Override
    public String toString() {
        return "(Moneda = " + moneda + ", Tasa De Cambio = " + tasaDeCambio + ")";
    }
}