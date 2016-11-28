package strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWord {

	public String reverse(String str){
		char[] src = str.toCharArray();
		int len = src.length;
		char[] dest = new char[len];
		Deque<Character> buffer = new ArrayDeque<Character>();
		int counter=0;
		for(int i =len-1;i>=0;i--){
			char c = src[i];
			if(c == ' '){
				while(!buffer.isEmpty()){
					char tmp=buffer.pop().charValue();
					dest[counter]=tmp;
					counter++;
				}
				dest[counter++]=new Character(' ');
			}else{
				buffer.push(new Character(c));
			}
		}
		while(!buffer.isEmpty()){
			char tmp=buffer.pop().charValue();
			dest[counter]=tmp;
			counter++;
		}
		return new String(dest, 0, len);
	}

	public static void main(String a[]) {
		ReverseWord nr = new ReverseWord();
		System.out.println(nr.reverse(" Hi there , Good morning"));
	}
}
