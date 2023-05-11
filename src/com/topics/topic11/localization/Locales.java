package com.topics.topic11.localization;

import java.util.Locale;

public class Locales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Locale e seu atributos:
		Locale locPT = new Locale("PT", "PT");
		
		System.out.println(locPT);
		System.out.println(locPT.getCountry());
		System.out.println(locPT.getDisplayName());
		System.out.println(locPT.getDisplayLanguage());
		System.out.println(locPT.getDisplayVariant());
		
		Locale locPT_BR = new Locale("PT", "BR", "BR");
		
		System.out.println(locPT_BR);
		System.out.println(locPT_BR.getCountry());
		System.out.println(locPT_BR.getDisplayName());
		System.out.println(locPT_BR.getDisplayLanguage());
		System.out.println(locPT_BR.getDisplayVariant());
		
		
		
		// Default Locale:
		System.out.println(Locale.getDefault());
		
		Locale.setDefault(new Locale("en"));
		
		System.out.println(Locale.getDefault());
	}

}
