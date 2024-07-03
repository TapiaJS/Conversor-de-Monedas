package consumodeapi;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public static Divisa buscarTasaDeCambioDeLaMoneda(String moneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/62a31b8bea8b6cead7828586/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda." + e.getMessage());
        }
    }
}
