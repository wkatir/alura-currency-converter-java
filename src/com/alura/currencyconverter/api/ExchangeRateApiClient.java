package com.alura.currencyconverter.api;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;

    public ExchangeRateApiClient(String apiKey) {
        this.apiKey = apiKey;
    }


}
