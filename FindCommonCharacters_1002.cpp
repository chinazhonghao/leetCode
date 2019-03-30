class Solution {
public:
    vector<string> commonChars(vector<string>& A) {
        int alphabet[26];
        int _count[26];
        int _singleCount[26];
        memset(alphabet, 0, sizeof(alphabet));
        memset(_count, 0, sizeof(_count));
        int length = A.size();
        vector<string> result;
        count(A[0], _count);
        for(int i=0; i<26; i++){
        	if(_count[i] > 0){
        		alphabet[i] = 1;
        	}
        }
        for(int i=1; i<length; i++){
        	count(A[i], _singleCount);
        	for(int j=0; j<26; j++){
        		if(_singleCount[j] > 0){
        			alphabet[j]++;
        			_count[j] = _count[j] < _singleCount[j] ? _count[j] : _singleCount[j];
        		}
        	}
        }
        for(int i=0; i<26; i++){
        	if(alphabet[i] >= length){
        		for(int j=0; j<_count[i]; j++){
        			result.push_back(string(1, i + 'a'));
        		}
        	}
        }
        return result;
    }

    inline void count(string& str, int* _count){
    	memset(_count, 0, sizeof(int)*26);
    	int length = str.size();
    	for(int i=0; i<length; i++){
    		_count[str[i] - 'a']++;
    	}
    }
};