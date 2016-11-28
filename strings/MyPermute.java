package strings;

public class MyPermute {

	public static void main(String[] args) {
		MyPermute.perm("ABC");
	}

    public static void perm(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        perm(a, 0, n);
    }

    private static void perm(char[] a, int k, int m) {
    	if(k==(m-1)){
    		System.out.println(new String(a));
    	}
        for (int j = k ; j < m; j++) {
            swap(a, k, j);
            perm(a, k+1 , m);
            swap(a, k, j);
        }

    }

    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

}