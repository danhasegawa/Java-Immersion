package br.com.desafio.imersao.dia3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo{
	
	@Override
	public List<Conteudo> extrairConteudos(String json) {

		// extrair so os dados que interessam
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		List<Conteudo> conteudos = new ArrayList<>();

		// popular a lista de coteudos

		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("url");
			float rating = 0F;
			String date = atributos.get("date");
			var conteudo = new Conteudo(titulo, urlImagem, rating, date);

			conteudos.add(conteudo);
		}

		return conteudos;
	}
}



