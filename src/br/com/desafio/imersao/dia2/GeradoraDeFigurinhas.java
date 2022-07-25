package br.com.desafio.imersao.dia2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		// Padronizar o tamanho
		if (imagemOriginal.getWidth() == imagemOriginal.getHeight()) {
			imagemOriginal = resizeImage(imagemOriginal, 500, 500);
		} else if (imagemOriginal.getWidth() < imagemOriginal.getHeight()) {
			imagemOriginal = resizeImage(imagemOriginal, 720, 1200);
		} else {
			imagemOriginal = resizeImage(imagemOriginal, 1200, 750);
		}

		// cria nova imagem em memoria com transparencia e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// copiar a imagem original pra nova imagem (em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		// configurar fonte
		var fonte = new Font("Impact", Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);

		// escrever uma frase na nova imagem
		
		graphics.drawString("TOPZERA", 210, novaAltura - 100);

		// escrever a nova imagem em um arquivo
		File sticker = new File("saida/" + nomeArquivo);
		if (sticker.mkdir())
			ImageIO.write(novaImagem, "png", sticker);
	}

	private BufferedImage resizeImage(BufferedImage imagemOriginal, int targetWidth, int targetHeight) {
		Image resultingImage = imagemOriginal.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
		return outputImage;
	}

}
