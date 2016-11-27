package stack;

import java.util.*;

// balance brackets using stack
public class Balance {

	static HashMap<Character,Character> hm =new HashMap<>();

	static {
	   hm.put('{','}');
	   hm.put('[',']');
	   hm.put('(',')');
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		while (sc.hasNext()) {
			boolean flag = false;
			String input = sc.next();
			st.clear();
			char[] c = input.toCharArray();
			int counter=0;
			for (int i = 0; i < c.length; i++) {
				Character t = Character.valueOf(c[i]);
				if (hm.get(t) != null) {
					st.push(t);
					counter++;
				} else {
					counter--;
					if (!st.isEmpty()) {
						Character tmp = st.pop();
						if (t.equals(hm.get(tmp))) {
							flag = true;
						} else {
							flag = false;
							break;
						}
					} else {
						flag = false;
					}
				}
			}
			if (st.size() > 0) {
				flag = false;
			}
			if(counter <0 ){
				System.out.println(false);
			}else{
				System.out.println(flag);
			}
		}
		sc.close();
	}
}
