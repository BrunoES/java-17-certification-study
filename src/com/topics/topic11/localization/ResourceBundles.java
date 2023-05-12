package com.topics.topic11.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {

	// Referência: https://www.baeldung.com/java-resourcebundle
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Locale currentLocale = Locale.getDefault();
		//ResourceBundle myResources = ResourceBundle.getBundle("MyResources", currentLocale);
		
		// Pega arquivo com mensagens em Inglês
		// Caso não encontre o arquivo, é lançado um java.util.MissingResourceException
		System.out.println("\n Pega arquivo com mensagens em Inglês");
		
		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);
		String greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		// Muda locale default para PT-BR
		Locale locPT_BR = new Locale("PT", "BR");
		Locale.setDefault(locPT_BR);
		
		// Pega arquivo com mensagens em Português BR
		System.out.println("\n Pega arquivo com mensagens em Português BR");
		
		bundle = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
		greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		// Muda locale default para PT de Portugal
		Locale locPT = new Locale("PT");
		Locale.setDefault(locPT);
		
		// Pega arquivo com mensagens em Português de Portugal
		System.out.println("\n Pega arquivo com mensagens em Português de Portugal");
		
		bundle = ResourceBundle.getBundle("MessageBundle", Locale.getDefault());
		greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
		System.out.println(bundle.getKeys().nextElement());
		
		// No Java 9 em diante, já não há problemas de encoding com arquivos bundle, tudo é lido em UTF-8
		
	}

}
