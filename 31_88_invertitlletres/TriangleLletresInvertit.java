
/* En aquest programa demanem un text i farem un triangle invertit a partir dels seus caracters */

public class TriangleLletresInvertit{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		
		for (int linia=text.length(); linia>=1; linia--){
		
			for (int i=text.length()-1; i>=linia; i--){
				char ch = text.charAt(i);
				if (i == 0){
					System.out.print(ch);
				}
				else {
					System.out.print(ch + ", ");
				}
			
			}
			System.out.println();
		}
	}
}



