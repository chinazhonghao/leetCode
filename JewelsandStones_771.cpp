class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int lenJ = J.size();
        int lenS = S.size();
        int count = 0;
        bool lowercase[26];
        bool upcase[26];
        memset(lowercase, 0, sizeof(lowercase));
        memset(upcase, 0, sizeof(upcase));
        for(int i=0; i<lenJ; i++){
        	char current = J[i];
        	if(current>='a'){
        		lowercase[current - 'a'] = true;
        	}
        	else{
        		upcase[current - 'A'] = true;
        	}
        }
        for(int i=0; i<lenS; i++){
        	char current = S[i];
        	if(current>='a'){
        		if(lowercase[current-'a']){
        			count++;
        		}
        	}
        	else if(upcase[current - 'A']) {
        		count++;
        	}
        }
        return count;
    }
};