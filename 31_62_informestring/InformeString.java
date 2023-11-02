
/* En aquest programa introduirem dos strings i un nombre positiu, amb aquests farem proves amb les
	diferents comandes que tenim per manipular els strings i ho ensenyarem
	 el seu resultat per pantalla */

public class InformeString{
	public static void main(String[] args){
		System.out.println("Text principal?");
		String text1 = Entrada.readLine();
		System.out.println("Text secundari?");
		String text2 = Entrada.readLine();
		System.out.println("Número positiu?");
		int num = Integer.parseInt(Entrada.readLine());
		
		System.out.println("\"" + text1 + "\".length(): " + text1.length());
		System.out.println("\"" + text1 + "\".startsWith(\"" + text2 + "\"): " + text1.startsWith(text2));
		System.out.println("\"" + text1 + "\".endsWith(\"" + text2 + "\"): " + text1.endsWith(text2));
		System.out.println("\"" + text1 + "\".equals(\"" + text2 + "\"): " + text1.equals(text2));
		System.out.println("\"" + text1 + "\".equalsIgnoreCase(\"" + text2 + "\"): " + text1.equalsIgnoreCase(text2));
		System.out.println("\"" + text1 + "\".isBlank(): " + text1.isBlank());
		System.out.println("\"" + text1 + "\".isEmpty(): " + text1.isEmpty());
		System.out.println("\"" + text1 + "\".charAt(" + num + "): " + text1.charAt(num));
		System.out.println("\"" + text1 + "\".concat(\"" + text2 + "\"): " + text1.concat(text2));
		System.out.println("\"" + text1 + "\".repeat(" + num + "): " + text1.repeat(num));
		System.out.println("\"" + text1 + "\".toUpperCase(): " + text1.toUpperCase());
		System.out.println("\"" + text1 + "\".toLowerCase(): " + text1.toLowerCase());
	}
}
