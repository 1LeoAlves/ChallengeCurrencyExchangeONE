package ConversorDeMoedas.Principal;

import ConversorDeMoedas.Services.ExchangeAPIService;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        SystemController systemController = new SystemController();
        systemController.Initialize();
    }
}