package br.com.desafio.imersao.dia3;

public enum ApiSelector {

//	static Manipulador manipulador = new Manipulador();
//	static Properties senha = manipulador.getProp();
//	static String key = senha.getProperty("apiKey");

	IMDB("https://imdb-api.com/en/API/Top250Movies/", new ExtratorConteudoIMDB()),
	NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json", new ExtratorConteudoNasa()),
	LOCAL("https://dihy-linguagens-api.herokuapp.com/linguagens", new ExtratorLinguagens());

	private String url;
	private ExtratorConteudo extrator;

	ApiSelector(String url, ExtratorConteudo extrator) {
		this.url = url;
		this.extrator = extrator;
	}

	public String getUrl() {
		return url;
	}

	public ExtratorConteudo getExtrator() {
		return extrator;
	}
}
