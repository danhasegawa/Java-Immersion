package br.com.desafio.imersao.dia2;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import br.com.desafio.imersao.dia1.Manipulador;

public class api {

	private static String key;

	public static void main(String[] args) throws Exception {

		// fazer uma conexao HTTP e buscar os top 250 filmes

		Manipulador manipulador = new Manipulador();
		Properties senha = manipulador.getProp();
		key =  senha.getProperty("apiKey");
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250Movies/" + key);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String json = response.body();
		

		// extrair (parsear) so os dados que interessam (titulo, poster, clissificacao)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(json);

		// exibir e manipular os dado
		var geradora = new GeradoraDeFigurinhas();

		for (int i = 0; i < 3; i++) {
			Map<String, String> filme = listaDeFilmes.get(i);

			String urlImage = filme.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
			String titulo = filme.get("title");

			InputStream inputStream = new URL(urlImage).openStream();
			String nomeArquivo = titulo + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(titulo);

			System.out.println();
		}

	}

}
