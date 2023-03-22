package com.topics.topic1.strings;

public class StringBuilders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverse();
		stringBuilderCapacity();
		setCharAt();
		delete();
		deleteCharAt();
		replace();
		append();
		equals();
	}

	// reverse: Inverte o conteúdo do StringBuilder
	public static void reverse() {
		System.out.println("\nreverse:");
		
		StringBuilder sb = new StringBuilder("Teste");
		sb.reverse();
		
		System.out.println(sb);
	}
	
	/*
	 * new StringBuilder(1)
	 * Parametro indica capacity do StringBuilder;
	 */
	public static void stringBuilderCapacity() {
		System.out.println("\nstringBuilderCapacity:");
		
		StringBuilder sb1 = new StringBuilder(1);
		System.out.println(sb1.capacity());
		
		StringBuilder sb2 = new StringBuilder(); // valor default da capacity é 16
		System.out.println(sb2.capacity());
		
		StringBuilder sb3 = new StringBuilder("Teste"); // Quando inicializada com uma String, o capacity será 16 + size da string
		System.out.println(sb3.capacity());
	}
	
	/*
	 * Atribui char à posição especificada
	 */
	public static void setCharAt() {
		System.out.println("\nsetCharAt:");
		
		StringBuilder sb = new StringBuilder("Teste");
		sb.setCharAt(0, 'A');
		System.out.println(sb);
		
		//sb.setCharAt(0, 'A'); // Irá gerar um java.lang.StringIndexOutOfBoundsException
	}
	
	/*
	 * Deleta intervalo, de 0 à n (index)
	 * start: inclusive
	 * end: exclusive
	 */
	public static void delete() {
		System.out.println("\ndelete:");
		
		StringBuilder sb = new StringBuilder("Teste");
		sb.delete(0, 3);
		
		System.out.println(sb);
	}
	
	/*
	 * Deleta char em determinado index.
	 */
	public static void deleteCharAt() {
		System.out.println("\ndelete:");
		
		StringBuilder sb = new StringBuilder("Teste");
		sb.deleteCharAt(4);
		
		System.out.println(sb);
	}
	
	/*
	 * Substitui intervalo por uma String.
	 * start: inclusive
	 * end: exclusive
	 */
	public static void replace() {
		System.out.println("\nreplace:");
		
		StringBuilder sb = new StringBuilder("Teste"); // Repare que de 1 a 3 substitui apenas 'es' por 'ES', pois o end (3) é exclusive.
		sb.replace(1, 3, "ES");
		
		System.out.println(sb);
	}
	
	/*
	 * Concatena conteúdo ao valor do StringBuilder.
	 */
	public static void append() {
		System.out.println("\nappend:");
		
		StringBuilder sb1 = new StringBuilder("Teste");
		sb1.append(" append");
		System.out.println(sb1);
		
		StringBuilder sb2 = new StringBuilder("Teste");
		sb2.append(1);
		System.out.println(sb2);
		
		StringBuilder sb3 = new StringBuilder("Teste");
		sb3.append(true);
		System.out.println(sb3);
		
		StringBuilder sb4 = new StringBuilder("Teste");
		sb4.append(" numero 1", 0, 8); // O intervalor start e end, é relativo ao intervalo da string que de fato será adicionado.
		System.out.println(sb4);
	}
	
	/*
	 * StringBuilder.equals não é o mesmo que String.equals:
	 */
	public static void equals() {
		System.out.println("\nequals:");
		
		String string = "Hey";
		StringBuilder builder = new StringBuilder(string);
		System.out.println(string.equals(builder)); // false
		System.out.println(string.contentEquals(builder)); // true, Valida se o valor é equals, e não o StringBuilder em sí.
	}
	
	
}
