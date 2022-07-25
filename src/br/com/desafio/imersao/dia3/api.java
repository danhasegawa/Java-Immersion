package br.com.desafio.imersao.dia3;

import java.io.InputStream;
import java.net.URL;
import java.util.List;




public class api {
	
	//private static String key;

	public static void main(String[] args) throws Exception {

		// fazer uma conexao HTTP e buscar os top 250 filmes

//		Manipulador manipulador = new Manipulador();
//		Properties senha = manipulador.getProp();
//		key =  senha.getProperty("apiKey");
//		String url = "https://imdb-api.com/en/API/Top250Movies/" + key;
//		ExtratorConteudo extrator = new ExtratorConteudoIMDB();
//
		//String url = "https://api.nasa.gov/planetary/apod?api_key=dZOBOhrtJazDzujiXJfoEi4u74hVSGQASPuj6ftastart_date=2022-06-12&end_date=2022-06-14";
//		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
//		ExtratorConteudo extrator = new ExtratorConteudoNasa();
		
//		String url = "http://dihy-linguagens-api.herokuapp.com/linguagens";
//		ExtratorConteudo extrator = new ExtratorLinguagens();
		
		ApiSelector myApi = ApiSelector.NASA;

		var http = new ClienteHttp();
		String json = http.buscaDados(myApi.getUrl());

		List<Conteudo> conteudos = myApi.getExtrator().extrairConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();

		for(int i = 0; i < conteudos.size(); i++) {
			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = conteudo.getTitulo() + ".png";
			float rating = conteudo.getRating();
			String date = conteudo.getDate();

			geradora.cria(inputStream, nomeArquivo, rating, date, myApi.name());

			System.out.println(conteudo.getTitulo());

			System.out.println();
		}

	}

}
