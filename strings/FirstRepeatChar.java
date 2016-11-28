package strings;

import java.util.LinkedList;

public class FirstRepeatChar {

	public char getFirstNonRepeat(String str){
		LinkedList<Character> result = new LinkedList<>();
		boolean b[] = new boolean[256];
		char[] chars = str.toCharArray();
		for(char c : chars){
			if(b[c]==false){
				result.add(c);
				b[c]=true;
			}else if(b[c]==true){
				result.remove(new Character(c));
			}
		}
		return result.get(0);
	}



	public static void main(String a[]) {
		FirstRepeatChar nr = new FirstRepeatChar();
		System.out.println(nr.getFirstNonRepeat("rzzaavibbrttv"));
	}

}
