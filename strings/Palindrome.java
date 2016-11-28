package strings;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		  int n = s.length();
		  for (int i=0;i<(n / 2);i++) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		}

	public static void main(String a[]) {
		System.out.println(isPalindrome("mary"));
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("abcba"));
		System.out.println(isPalindrome("34543"));
	}
}
