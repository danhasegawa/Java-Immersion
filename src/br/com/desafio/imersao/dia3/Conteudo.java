package br.com.desafio.imersao.dia3;

public class Conteudo {
	
	private final String titulo;
	private final String urlImagem;
	private final float rating;
	private final String date;
	
	
	public Conteudo(String titulo, String urlImagem, float rating, String date) {
		this.titulo = titulo;
		this.urlImagem = urlImagem;
		this.rating = rating;
		this.date = date;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getUrlImagem() {
		return urlImagem;
	}

	public float getRating() {
		return rating;
	}
	public String getDate() {
		return date;
	}
}
