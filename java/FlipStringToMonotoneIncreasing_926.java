class Solution {
    public int minFlipsMonoIncr(String S) {
    	char[] array = S.toCharArray();
    	int[] counts = new int[array.length+1];
    	for(int i=1; i<=array.length; i++){
    		counts[i] = counts[i-1] + array[i-1] - '0';
    	}
    	int result = array.length;
    	int length = array.length;
    	for(int i=0; i<=length; i++){
    		int count = counts[length - i] + (i) - (counts[length] - counts[length - i]);
    		result = Math.min(count, result);
    	}
    	return result;
    }
}