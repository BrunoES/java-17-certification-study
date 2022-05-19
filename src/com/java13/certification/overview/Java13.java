package com.java13.certification.overview;

public class Java13 {

	public static void main(String[] args) {
		
		// Os text bloks vieram agora para o Java 13:
		String jsonBlock = """
					greeting: "Hello,
					audience; "World",
					punctuation: "!"
				""";
		
		// Incrementação do switch expression:
		// exemplo:
		int i = 0;
		int numero = switch(i) {
			case 0 -> 1;
			case 1 -> 2;
			case 2 -> 3;
			case 3 -> {
				int x = 10;
				yield(x);
			}
			default -> 0;
		};
		
		// Novos métodos string:
		String teste1 = "	String teste = \"teste\";";
		String teste2 = "Hey, \\n This is not normally a line break.";
		
		teste1.stripIndent(); // Remove a identação dos blocos.
		System.out.println(teste1.translateEscapes()); // * expões o comportamento da tradução das sequências de escape nas strings.
		System.out.println(teste2.translateEscapes()); // * expões o comportamento da tradução das sequências de escape nas strings.
		"Value: %s".formatted(teste1); // Uma reformulação do String.format("Value: %s", value);
		
		
		// ** ver: Melhorias no NIO **
		
		
		
	}

}
