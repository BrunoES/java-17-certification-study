package com.topics.topic11.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {

	// Refer�ncia: https://www.baeldung.com/java-resourcebundle
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Locale currentLocale = Locale.getDefault();
		//ResourceBundle myResources = ResourceBundle.getBundle("MyResources", currentLocale);
		
		// Pega arquivo com mensagens em Ingl�s
		// Caso n�o encontre o arquivo, � lan�ado um java.util.MissingResourceException
		System.out.println("\n Pega arquivo com mensagens em Ingl�s");
		
		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);
		String greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		// Muda locale default para PT-BR
		Locale locPT_BR = new Locale("PT", "BR");
		Locale.setDefault(locPT_BR);
		
		// Pega arquivo com mensagens em Portugu�s BR
		System.out.println("\n Pega arquivo com mensagens em Portugu�s BR");
		
		bundle = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
		greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		// Muda locale default para PT de Portugal
		Locale locPT = new Locale("PT");
		Locale.setDefault(locPT);
		
		// Pega arquivo com mensagens em Portugu�s de Portugal
		System.out.println("\n Pega arquivo com mensagens em Portugu�s de Portugal");
		
		bundle = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
		greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		System.out.println(bundle.getKeys().nextElement());
		
		// No Java 9 em diante, j� n�o h� problemas de encoding com arquivos bundle, tudo � lido em UTF-8
		
	}

}
