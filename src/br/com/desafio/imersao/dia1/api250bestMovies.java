package br.com.desafio.imersao.dia1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class api250bestMovies {

	private static String key;
	
	public static void main(String[] args) throws IOException, Exception {

		// fazer uma conexao HTTP e buscar os filmes mais populares

		Manipulador manipulador = new Manipulador();
		Properties senha = manipulador.getProp();
		key =  senha.getProperty("apiKey");
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/MostpopularMovies/" + key);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String json = response.body();

		// extrair (parsear) so os dados que interessam (titulo, poster, clissificacao)
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(json);

		// exibir e manipular os dado
		for (int i = 0; i < 10; i++) {
			Map<String, String> filme = listaDeFilmes.get(i);
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println("Rating " + filme.get("imDbRating"));
			System.out.println();
		}

	}

}
