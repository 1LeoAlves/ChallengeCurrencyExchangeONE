package ConversorDeMoedas.Services;

import ConversorDeMoedas.Modelos.ExchangeAPIResponse;
import ConversorDeMoedas.Shared.Enums.CURRENCY_TYPE;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeAPIService {
    String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    String API_KEY = "COLOCAR SUA CHAVE AQUI";
    String PARAM = "/pair/";

    public Double RequestPairExchange(CURRENCY_TYPE typeOfExchange, CURRENCY_TYPE typeToExchange, Double amount)
    {
        try {
            String PAIR_AMOUNT_PARAM = String.join("/",typeOfExchange.name(), typeToExchange.name(), amount.toString());

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + API_KEY + PARAM + PAIR_AMOUNT_PARAM))
                    .build();
            HttpResponse<String> rawResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeAPIResponse response = gson.fromJson(rawResponse.body(), ExchangeAPIResponse.class);
            return response.conversion_result();
        } catch (Exception e) {
            System.out.println("Erro na requisição a API!");
            throw new RuntimeException(e);
        }
    }
}
