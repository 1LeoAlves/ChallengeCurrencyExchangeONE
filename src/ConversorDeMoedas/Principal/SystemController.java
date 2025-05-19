package ConversorDeMoedas.Principal;

import ConversorDeMoedas.Services.ExchangeAPIService;
import ConversorDeMoedas.Shared.Enums.CURRENCY_TYPE;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class SystemController {
    CURRENCY_TYPE typeOf, typeTo;
    Scanner optionScanner = new Scanner(System.in);
    Scanner amoutScanner = new Scanner(System.in);
    ExchangeAPIService apiService = new ExchangeAPIService();
    Boolean isOn;

    public void Initialize(){
        isOn = true;
        System.out.println("-----------------------------------");
        System.out.println("Seja Bem-vindo/a ao Conversor de Moedas!\n");
        while (isOn) {
            System.out.println("[1] Dólar ==>> Peso argentino");
            System.out.println("[2] Peso argentino ==>> Dólar");
            System.out.println("[3] Dólar ==>> Real Brasileiro");
            System.out.println("[4] Real Brasileiro ==>> Dólar");
            System.out.println("[5] Dólar ==>> Peso colombiano");
            System.out.println("[6] Peso colombiano ==>> Dólar");
            System.out.println("[7] Sair");
            System.out.print("Escolha uma opção válida: ");

            int option = Integer.parseInt(optionScanner.nextLine());
            isOn = ChoiceOption(option);
            if(!isOn) break;

            System.out.println("-----------------------------------\n");
            System.out.print("Digite o valor em " +  typeOf.name() + " que deseja converter para " + typeTo.name() +  " : ");
            Double amount = Double.valueOf(amoutScanner.nextLine());
            Double result = apiService.RequestPairExchange(typeOf, typeTo, amount);
            System.out.print("O valor " + amount + " [" + typeOf.name() + "] " + " equivale à " + result + " [" + typeTo.name() +  "]");
            System.out.println("-----------------------------------\n");
        }
        System.out.println("Conversor Finalizado!");
    }

    public boolean ChoiceOption(int value){
        switch (value){
            case 1:
                typeOf = CURRENCY_TYPE.USD;
                typeTo = CURRENCY_TYPE.ARS;
                break;
            case 2:
                typeOf = CURRENCY_TYPE.ARS;
                typeTo = CURRENCY_TYPE.USD;
                break;
            case 3:
                typeOf = CURRENCY_TYPE.USD;
                typeTo = CURRENCY_TYPE.BRL;
                break;
            case 4:
                typeOf = CURRENCY_TYPE.BRL;
                typeTo = CURRENCY_TYPE.USD;
                break;
            case 5:
                typeOf = CURRENCY_TYPE.USD;
                typeTo = CURRENCY_TYPE.COP;
                break;
            case 6:
                typeOf = CURRENCY_TYPE.COP;
                typeTo = CURRENCY_TYPE.USD;
                break;
            case 7:
                System.out.println("Finalizando Conversor.");
                return false;
            default:
                System.out.println("Opção Inválida! Tente Novamente.");
                break;
        }
        return true;
    }
}
