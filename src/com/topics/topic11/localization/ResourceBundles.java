package com.topics.topic11.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles {

	// Continuar: https://www.baeldung.com/java-resourcebundle
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale currentLocale = Locale.getDefault();
		ResourceBundle myResources = ResourceBundle.getBundle("MyResources", currentLocale);
	}

}
