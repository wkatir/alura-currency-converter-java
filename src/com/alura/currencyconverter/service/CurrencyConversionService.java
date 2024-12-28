package com.alura.currencyconverter.service;

import com.alura.currencyconverter.api.ExchangeRateApiClient;
import com.alura.currencyconverter.model.ExchangeRateResponse;

import java.io.IOException;

public class CurrencyConversionService {
    private final ExchangeRateApiClient apiClient;

    public CurrencyConversionService(ExchangeRateApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String convert(int option, double amount) {
        try {
            ExchangeRateResponse response = apiClient.getExchangeRates("USD");
            switch (option) {
                case 1 -> {
                    double rate = response.conversion_rates().get("ARS");
                    return amount + " USD is " + (amount * rate) + " ARS.";
                }
                case 2 -> {
                    double rate = response.conversion_rates().get("ARS");
                    return amount + " ARS is " + (amount / rate) + " USD.";
                }
                case 3 -> {
                    double rate = response.conversion_rates().get("BRL");
                    return amount + " USD is " + (amount * rate) + " BRL.";
                }
                case 4 -> {
                    double rate = response.conversion_rates().get("BRL");
                    return amount + " BRL is " + (amount / rate) + " USD.";
                }
                case 5 -> {
                    double rate = response.conversion_rates().get("COP");
                    return amount + " USD is " + (amount * rate) + " COP.";
                }
                case 6 -> {
                    double rate = response.conversion_rates().get("COP");
                    return amount + " COP is " + (amount / rate) + " USD.";
                }
                default -> throw new IllegalArgumentException("Invalid option.");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error fetching exchange rates: " + e.getMessage());
        }
    }
}
