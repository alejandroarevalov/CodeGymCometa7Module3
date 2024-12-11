package com.codegym.httpclient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploClienteHTTP {

    public HttpRequest crearHttpRequestTipoGet() {
        return HttpRequest.newBuilder()
            //.uri(URI.create("https://codegym.cc"))
            .uri(URI.create("https://eltiempo.com/"))
            .version(HttpClient.Version.HTTP_2)
            .timeout(Duration.ofSeconds(10L))
            //.setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
            //.setHeader("accept-encoding","gzip, deflate, br, zstd")
            .setHeader("accept", "text/html,text/plain")
            .setHeader("miencabezado", "valordemiencabezado")
            .GET()
            .build();
    }

    public HttpRequest crearHttpRequestTipoPost() {
        return HttpRequest.newBuilder()
            .uri(URI.create("https://codegym.cc"))
            .version(HttpClient.Version.HTTP_2)
            .timeout(Duration.ofSeconds(5L))
            //.setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
            //.setHeader("accept-encoding","gzip, deflate, br, zstd")
            .setHeader("accept", "text/html,text/plain")
            .setHeader("miencabezado", "valordemiencabezado")
            .setHeader("content-type", "text/plain;charset=UTF-8")
            // .POST(HttpRequest.BodyPublishers.noBody()) --> también se debe hacer con método PUT
            .POST(HttpRequest.BodyPublishers.ofString("Lorem ipsum dot sit amen..."))
            .build();
    }

    public HttpRequest crearHttpRequestTipoPostConArchivoComoTipoDeContenidoAEnviar() throws FileNotFoundException {
        return HttpRequest.newBuilder()
            .uri(URI.create("https://codegym.cc"))
            .version(HttpClient.Version.HTTP_2)
            .timeout(Duration.ofSeconds(5L))
            //.setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
            //.setHeader("accept-encoding","gzip, deflate, br, zstd")
            .setHeader("accept", "text/html,text/plain")
            .setHeader("miencabezado", "valordemiencabezado")
            .setHeader("content-type", "application/pdf")
            // .POST(HttpRequest.BodyPublishers.noBody()) --> también se debe hacer con método PUT
            .POST(HttpRequest.BodyPublishers.ofFile(
                Paths.get("src/main/resources/repertorio.pdf").toAbsolutePath()
            ))
            .build();
    }

    public void generarSolicitudHttpConHttpClient(HttpRequest request) throws IOException, InterruptedException {
        CookieManager cookieManager = new CookieManager();
        cookieManager.getCookieStore().add(
            URI.create("https://codegym.cc"),
            new HttpCookie("MiCookie", "12345")
        );
        HttpClient cliente = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .cookieHandler(cookieManager)
            .build();
        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        List<String> valores = respuesta.headers().map().get("Cookie");
        System.out.println(respuesta.headers());
        System.out.println(respuesta.statusCode());
        System.out.println(respuesta.body());
    }

    public void generarSolicitudHttpAsincronaConHttpClient(HttpRequest request) throws ExecutionException, InterruptedException {
        ExecutorService servicioExecutors = Executors.newFixedThreadPool(3);
        HttpClient cliente = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .executor(servicioExecutors)
            .build();
        // Diferencia
        CompletableFuture<HttpResponse<String>> respuestaFutura = cliente.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        imprimirNumerosPrimos(1000);
        // Diferencia
        HttpResponse<String> respuesta = respuestaFutura.get();
        System.out.println(respuesta.headers());
        System.out.println(respuesta.statusCode());
        System.out.println(respuesta.body());
    }

    private void imprimirNumerosPrimos(int max) {
        boolean esPrimo = true;
        for(int i = 3; i <= max; i++) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        EjemploClienteHTTP ejemplo = new EjemploClienteHTTP();

        var requestTipoGet = ejemplo.crearHttpRequestTipoGet();
        var requestTipoPost = ejemplo.crearHttpRequestTipoPost();
        var requestTipoPostConArchivo = ejemplo.crearHttpRequestTipoPostConArchivoComoTipoDeContenidoAEnviar();

        ejemplo.generarSolicitudHttpConHttpClient(requestTipoGet);
        ejemplo.generarSolicitudHttpAsincronaConHttpClient(requestTipoGet);

        System.out.println("Deteniendo ejecucion para depuracion");
    }
}
