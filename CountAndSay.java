public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here

		// TODO Auto-generated method stub
		String s = "1";
		StringBuilder builder = new StringBuilder(s);
		
		while(n > 1){
			n--;
			String cur = builder.toString();
			char[] array = cur.toCharArray();
			builder = new StringBuilder();
			int count = 1, l = 0;
			for(int i = 0; i < array.length; i++){
				int m = Integer.parseInt(array[i]+"");
				if(m == l){
					count ++;
				}
				if((m != l && l != 0)){
					builder.append(count+""+l+"");
					count = 1;
				} 
				if(i == array.length-1){
				    builder.append(count+""+m+"");
				}
				l = m;
			}
		}
		return builder.toString();
	
    }
}