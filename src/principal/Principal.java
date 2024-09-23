package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.ConversionResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {

    private Double conectar(String url, Double valorAConvertir) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse = response.body();

            ConversionResponse conversionResponse = gson.fromJson(jsonResponse, ConversionResponse.class);

            Double conversionRate = conversionResponse.getConversion_rate();
            if (conversionRate != null) {
                return valorAConvertir * conversionRate;
            } else {
                System.out.println("No se pudo obtener la tasa de conversión.");
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        String menu = """
                Bienvenido al coversor de moneda
                1. Dolar => Peso Argentino
                2. Peso Argentino => Dolar
                3. Dolar => Real Brasilenio
                4. Real Brasilenio => Dolar
                5. Dolar => Peso Colombiano
                6. Peso Colombiano => Dolar
                7. SALIR
                Escoger una OPCION valida :""";
        String espaciado = "**************************************************";
        String numero = "";
        Scanner sc = new Scanner(System.in);
        String ingreso = "Ingresa el valor que deseas convertir";
        String url = "";

        while (!numero.equals("7")) {
            System.out.println(espaciado);
            System.out.println(menu);
            numero = sc.nextLine();
            Double valorAConvertir = null;
            Double total = null;

            switch (numero) {
                case "1":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/USD/ARS/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Dolares a Pesos argentinos es " + total);
                    break;
                case "2":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/ARS/USD/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Pesos Argentinos a Dolares es " + total);
                    break;
                case "3":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/USD/BRL/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Dolares a Reales Brasilenios es " + total);
                    break;
                case "4":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/BRL/USD/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Reales Brasilenios a Dolares es " + total);
                    break;
                case "5":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/USD/COP/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Dolares a Pesos Colombianos es " + total);
                    break;
                case "6":
                    System.out.println(ingreso);
                    valorAConvertir = sc.nextDouble();
                    sc.nextLine();
                    url = "https://v6.exchangerate-api.com/v6/5e2d2798d706e28ee6cb4ed7/pair/COP/USD/";
                    total = principal.conectar(url, valorAConvertir);
                    System.out.println("Su conversion de Pesos Colombianos a Dolares es " + total);
                    break;
                case "7":
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese otra opcion");
                    break;
            }
        }
    }
}
