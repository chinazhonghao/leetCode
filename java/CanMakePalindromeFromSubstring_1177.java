class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int[][] map = new int[s.length()][26];
        map[0][s.charAt(0) - 'a']++;
        for(int i=1; i<s.length(); i++){
        	for(int j=0; j<26; j++){
        		map[i][j] = map[i-1][j];
        	}
        	map[i][s.charAt(i)-'a']++;
        }
        int length = queries.length;
        for(int i=0; i<length; i++){
        	result.add(_palindrome(map, queries[i][0], queries[i][1], queries[i][2]));
        }
        return result;
    }

    private Boolean _palindrome(int[][] map, int left, int right, int k){
    	int[] line = new int[26];
    	if(left < 1){
    		line = map[right];
    	}
    	else {
    		for(int i=0; i<26; i++){
    			line[i] = map[right][i] - map[left-1][i];
    		}
    	}
    	int oddNum = 0;
    	for(int i=0; i<26; i++){
    		oddNum += line[i] & 1;
    	}
    	oddNum -= (right - left + 1) & 1;
    	return oddNum <= (k<<1);
    }
}