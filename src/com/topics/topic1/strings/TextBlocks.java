package com.topics.topic1.strings;

public class TextBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Os text bloks vieram agora para o Java 13:
		// Text Blocks: Incluido definitivamente na JDK 15.
		String jsonBlock = """
				greeting: "Hello,
					audience; "World",
					punctuation: "!"
				""";
		
		System.out.println(jsonBlock);

		
		
		
		
		// Text block equal an another String with the same content
		
		// Using a literal string
		String text1 = "Geeks For Geeks";
		  
		// Using a text block
		String text2 = """
		                Geeks For Geeks""";
		
		System.out.println(text1.equals(text2));
		
		
		

		// ORIGINAL
		String message1 = "A-143, 9th Floor, Sovereign Corporate Tower,\n" +
		      "Sector-136, Noida,\n" +
		      "Uttar Pradesh - 201305";
		  
		// BETTER : Using text blocks 
		// gets rid of lots of the clutter
		String message2 = """
		    A-143, 9th Floor, Sovereign Corporate Tower,
		    Sector-136, Noida,
		    Uttar Pradesh - 201305""";
		
		System.out.println(message1);
		System.out.println(message2);
	}

}
