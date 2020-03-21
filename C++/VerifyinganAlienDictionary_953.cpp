class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        int alphabet[26];
        memset(alphabet, 0, sizeof(alphabet));
        int length = order.size();
        for(int i=0; i<length; i++){
        	alphabet[order[i]-'a'] = i;
        }
        length = words.size();
        string last = words[0];
        for(int i=1; i<length; i++){
        	string& current = words[i];
        	if(!isSorted(last, current, alphabet)){
        		return false;
        	}
        	last = current;
        }
        return true;
    }

    inline bool isSorted(string& left, string& right, int* alphabet){
    	int length = left.size();
    	int rLen = right.size();
    	for(int i=0; i<length; i++){
    		if(i >= rLen){
    			return false;
    		}
    		if(alphabet[left[i] - 'a'] > alphabet[right[i] - 'a'])
    		{
    			return false;
    		}
    		else if(alphabet[left[i] - 'a'] < alphabet[right[i] - 'a']){
    			return true;
    		}
    	}
    	return true;
    }
};