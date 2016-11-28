package strings;

public class RemoveChar {
	public static String removeChar(String str , char c){
		int cnt =0;
		char[] chars= str.toCharArray();
		for(int i =0 ; i < chars.length;i++){
			if(chars[i]==c){
				cnt = cnt+1;
			}else{
				chars[i-cnt]=chars[i];
			}
		}
		return new String(chars,0,chars.length-cnt);
	}

    public static void main(String[] args) {
    	System.out.println(RemoveChar.removeChar(" hi there babay", 'e'));
    }

}
