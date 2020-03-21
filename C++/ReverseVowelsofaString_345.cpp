class Solution {
public:
    string reverseVowels(string s) {
    	int length = s.size();
    	if(length < 1){
    		return s;
    	}
        int left = 0;
        int right = length - 1;
        vector<char> reverseS;
        reverseS.reserve(s.size());
        while(left <= right){
        	if(!isVowel(s[left])){
        		reverseS[left] = s[left];
        		left++;
        		continue;
        	}
        	if(!isVowel(s[right])){
        		reverseS[right] = s[right];
        		right--;
        		continue;
        	}
        	reverseS[left] = s[right];
        	reverseS[right] = s[left];
        	left++;
        	right--;
        }
        char * temp = &(reverseS[0]);
        return new string(temp, length);
    }

    inline bool isVowel(char data){
    	string vowels = "aAeEiIoOuU";
    	if(vowels.find(data)!=string::npos){
    		return true;
    	}
    	return false;
    }
};