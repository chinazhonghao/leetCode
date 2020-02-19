class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int[][] flag = new int[S.length()+1][26];
        for(int i=0; i<26; i++){
        	flag[S.length()][i] = -1;
        }
        for(int i=S.length()-1; i>=0; i--){
        	flag[i][S.charAt(i)-'a'] = i+1;
        	for(int j=0; j<26; j++){
        		if(j != S.charAt(i)-'a'){
        			flag[i][j] = flag[i+1][j]; 
        		}
        	}
        }

        int result = 0;
        for(int i=0; i<words.length; i++){
        	String word = words[i];
        	int nextLine = 0;
        	int count = 0;
        	while(count < word.length()){
        		int index = word.charAt(count) - 'a';
        		nextLine = flag[nextLine][index];
        		if(nextLine == -1){
        			break;
        		}
        		count++;
        	}
        	if(count == word.length()){
        		result++;
        	}
        }
        return result;
    }
}