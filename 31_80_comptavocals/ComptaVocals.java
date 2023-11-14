
/* En aquest programa demanem un text i comptarem el nombre de vocals que hi ha */

public class ComptaVocals{
	public static void main(String[] args){
		String vocals = "aeiouàéèíïóòúü";
		int num = 0;
		System.out.println("Text?");
		String text = Entrada.readLine();
		text = text.toLowerCase();
		for (int i=0; i<text.length(); i++){
			char ch = text.charAt(i);
			
			boolean vocal = false;
			for (int n=0; n<vocals.length(); n++){
				if (ch == vocals.charAt(n)){
					vocal = true;
					num++;
					break;
				}
			}
		}
		
		System.out.println(num);
		
	}
}


