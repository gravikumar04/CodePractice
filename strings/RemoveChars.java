package strings;

// removes char from string
public class RemoveChars {

	public String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		boolean[] flags = new boolean[128]; // assumes ASCII!
		int len = s.length;
		int src, dst;
		// Set flags for characters to be removed
		for (int i = 0; i < r.length; i++) {
			flags[(int)r[i]] = true;
		}

		src = 0;
		dst = 0;
		// Now loop through all the characters,
		// copying only if they aren’t flagged
		while (src < len) {
			if (!flags[(int) s[src]]) {
				s[dst++] = s[src];
			}
			++src;
		}
		return new String(s, 0, dst);
	}

	public static void main(String a[]) {
		RemoveChars nr = new RemoveChars();
		System.out.println(nr.removeChars("yetuyqeutiyqeiutyeizxcbgaetel", "gl"));
	}

}
