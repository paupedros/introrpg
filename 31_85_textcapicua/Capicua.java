
/* En aquest programa demanem un text i indiquem si es capicua o no */

public class Capicua{
	public static void main(String[] args){
		System.out.println("Text?");
		String text = Entrada.readLine();
		String textNou = "";
		
		for (int i=text.length()-1; i>=0; i--){
			char ch = text.charAt(i);
			textNou+=ch;
		}
		
		
		if(text.isBlank()){
			System.out.println("No és capicua");
		}
		else if(text.equals(textNou)){
			System.out.println("És capicua");
		}
		else {
			System.out.println("No és capicua");
		}
		
	}
}



