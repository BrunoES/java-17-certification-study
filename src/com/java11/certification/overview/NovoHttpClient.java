package com.java11.certification.overview;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NovoHttpClient {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		//get();
		post();
	}
	
	public static void get() throws IOException, InterruptedException, ExecutionException, TimeoutException {
		// Representa todos os dados de conexão
		HttpRequest request = HttpRequest.newBuilder()
				//.POST(null)
				.GET()
				.uri(URI.create("https://www.getpostman.com"))
				.header("Accept", "application/json")
				.timeout(Duration.ofSeconds(5))
				.build();
		
		// Cliente representa a conexão
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(3)) // Timeout depois de conectado ao servidor
				.followRedirects(Redirect.NORMAL) // Permite que seja redirecionado, caso retorne um 301 com uma location no header
				.build();

		// Request Síncrona
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
		System.out.println(response.statusCode());
		System.out.println(response.headers());
		System.out.println(response.version());
		
		// Request Assíncrona
		CompletableFuture<HttpResponse<String>> futureResponse = httpClient.sendAsync(request, BodyHandlers.ofString());
			futureResponse.thenApply(HttpResponse::body)
				.thenApply(String::toUpperCase)
					.thenAccept(System.out::println)
						.get(5L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
							
	}
	
	public static void post() throws IOException, InterruptedException, ExecutionException, TimeoutException {
		HttpRequest request = HttpRequest.newBuilder()
				.POST(BodyPublishers.ofString("{teste_k}"))
				// .POST(BodyPublishers.ofFile(null); passando Path do arquivo, consegue fazer uma requisição com o conteúdo do arquivo.
				// .POST(BodyPublishers.ofByteArray(Files.readAllBytes(null))) passando Path do arquivo que contêm estes bytes.
				/* Com Input Stream:
				.POST(BodyPublishers.ofInputStream(() -> {
					try {
						return new FileInputStream(Path.of("").toFile());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					return null;
				})
				)*/
				// Obs: Todas estas opções acima são disponíeis para POST e PUT.
				.uri(URI.create("https://www.getpostman.com"))
				.header("Accept", "application/json")
				.timeout(Duration.ofSeconds(5))
				.build();
		
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(3)) // Timeout depois de conectado ao servidor
				.followRedirects(Redirect.NORMAL) // Permite que seja redirecionado, caso retorne um 301 com uma location no header
				.proxy(ProxySelector.of(new InetSocketAddress("186.148.172.110", 8181))) // Exemplo para setar um proxy fixo.
				.executor(Executors.newCachedThreadPool()) // Apenas para chamadas assíncrona (geralmente seta-se o executor do framework em questão) Setar qual o executor, caso exista um gerenciador de Threads ou algo assim.
				.build();

		// Request Assíncrona
		CompletableFuture<HttpResponse<String>> futureResponse1 = httpClient.sendAsync(request, BodyHandlers.ofString());
		futureResponse1.thenApply(HttpResponse::body)
				.thenApply(String::toUpperCase)
					.thenAccept(System.out::println)
						.get(10L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
	
		// Request Assíncrona Salvando a resposta em um Array de Bytes
		CompletableFuture<HttpResponse<byte[]>> futureResponse2 = httpClient.sendAsync(request, BodyHandlers.ofByteArray());
		futureResponse2.thenApply(HttpResponse::body)
			.thenApply(String::new)
				.thenApply(String::toUpperCase)
					.thenAccept(System.out::println)
						.get(10L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
			
		// Request Assíncrona - Salvando a resposta em um InputStream
		CompletableFuture<HttpResponse<InputStream>> futureResponse3 = httpClient.sendAsync(request, BodyHandlers.ofInputStream());
		futureResponse3.thenApply(HttpResponse::body)
			.thenApply(t -> {
				try {
					return t.readAllBytes();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			})
			.thenAccept(System.out::println)
				.get(10L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
		
		// Request Assíncrona - Salvando a resposta dentro de um arquivo
		CompletableFuture<HttpResponse<Path>> futureResponse5 = httpClient.sendAsync(request, BodyHandlers.ofFile(Path.of("path")));
		futureResponse5.thenApply(HttpResponse::body)
					.thenAccept(System.out::println)
						.get(10L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
		
		
		// Request Assíncrona - Fazendo Download de um arquivo
		// Considerando uma URL dando um GET em uma URL
		CompletableFuture<HttpResponse<Path>> futureResponse6 = httpClient.sendAsync(request, BodyHandlers.ofFileDownload(Path.of("path"), StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		futureResponse5.get(10L, TimeUnit.SECONDS); // Sem isso a execução termina sem executar;
			

	}

}

