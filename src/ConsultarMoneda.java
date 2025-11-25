import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public ResultadoConversion convertir(String monedaBase, String monedaObjetivo, double cantidad) {

        //CREANDO LA URL
        String url = "https://v6.exchangerate-api.com/v6/84cc70c7505b4a56ba131142/pair/" + monedaBase + "/" + monedaObjetivo + "/" + cantidad;

        //HACIENDO EL PEDIDO A LA API
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        //OBTENIENDO LA RESPUESTA DE LA API
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //TRASNFORMANDO DE JSON A UN OBJETO TIPO RESULTADOCONVERSION UTILIZANDO GSON
            return new Gson().fromJson(response.body(), ResultadoConversion.class);
        } catch (Exception e) {
            throw new RuntimeException("NO SE ENCONTRO LA MONEDA");
        }
    }
}
