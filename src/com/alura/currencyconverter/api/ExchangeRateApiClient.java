package com.alura.currencyconverter.api;

import com.alura.currencyconverter.model.ExchangeRateResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;

    public ExchangeRateApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public ExchangeRateResponse  getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String url = API_URL + apiKey + "/latest/" + baseCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200){
            ExchangeRateResponse exchangeRateResponse = new Gson().fromJson(response.body(),ExchangeRateResponse.class);
            if (!"success".equals(exchangeRateResponse.result())){
                throw new IOException("API response error: " + exchangeRateResponse.result());
            }
            return exchangeRateResponse;
        } else {
            throw new IOException("Failed to fetch exchange rates: HTTP Code " + response.statusCode());
        }
    }

}
