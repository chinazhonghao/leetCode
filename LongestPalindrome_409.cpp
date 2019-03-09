class Solution {
public:
    int longestPalindrome(string s) {
        int lowercase[26];
        memset(lowercase, 0, sizeof(lowercase));
        int uppercase[26];
        memset(uppercase, 0, sizeof(uppercase));
        int length = s.size();
        for(int i=0; i<length; i++){
        	int current = s.at(i);
        	if(current>='a' && current<='z'){
        		lowercase[current-'a']++;
        	}
        	else{
        		uppercase[current-'A']++;
        	}
        }
        int res = 0;
        bool isSingle = count(lowercase, res);
        isSingle = count(uppercase, res) || isSingle;

        if(isSingle){
        	res += 1;
        }
        return res;
    }

    bool isEven(int num){
    	return ((num >> 1) << 1) == num;
    }

    bool count(int *array, int &res){
    	bool isSingle = false;
    	for(int i=0; i<26; i++){
        	int count = array[i];
        	if(isEven(count)){
        		res += count;
        	}
        	else{
        		isSingle = true;
        		res += (count - 1);
        	}
        }
        return isSingle;
    }
};