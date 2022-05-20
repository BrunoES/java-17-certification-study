package com.java13.certification.overview;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Java13 {

	public static void main(String[] args) throws IOException {
		
		// Os text bloks vieram agora para o Java 13:
		String jsonBlock = """
					greeting: "Hello,
					audience; "World",
					punctuation: "!"
				""";
		
		
		
		// Incrementa��o do switch expression:
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
		
		
		
		// Novos m�todos string:
		String teste1 = "	String teste = \"teste\";";
		String teste2 = "Hey, \\n This is not normally a line break.";
		
		teste1.stripIndent(); // Remove a identa��o dos blocos.
		System.out.println(teste1.translateEscapes()); // * exp�es o comportamento da tradu��o das sequ�ncias de escape nas strings.
		System.out.println(teste2.translateEscapes()); // * exp�es o comportamento da tradu��o das sequ�ncias de escape nas strings.
		"Value: %s".formatted(teste1); // Uma reformula��o do String.format("Value: %s", value);
		
		
		
		// ** ver: Melhorias no NIO **
		// Novos m�todos:
		FileSystems.newFileSystem(Path.of(""));
		FileSystems.newFileSystem(Path.of(""), new HashMap<String, String>());
		FileSystems.newFileSystem(Path.of(""), new HashMap<String, String>(), Java13.class.getClassLoader());
		
		// Files.isHidden should return true for hidden directories on Windows
		Files.isHidden(Path.of(""));
		
		// should use SYMBOLIC_LINK_FLAG_ALLOW_UNPRIVILEGED_CREATE (windows)
		// Files.createSymbolicLink(Path.of(""), Path.of(""), FileAttribute<T>);
		
		// Add absolute bulk put and get methods
		//ByteBuffer ?
		
	}

}
