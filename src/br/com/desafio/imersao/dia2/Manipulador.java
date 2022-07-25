package br.com.desafio.imersao.dia2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {
	
	
		public Properties getProp() throws IOException{
			Properties props = new Properties();
			FileInputStream file  = new FileInputStream("./key/apiKey.properties");
			props.load(file);
			return props;
		}

		
}
