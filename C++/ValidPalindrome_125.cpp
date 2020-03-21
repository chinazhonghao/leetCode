class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.size();
        while(left < right){
        	char leftC = s[left];
        	char rightC = s[right];
        	if(!isCharacter(leftC)){
        		left++;
        		continue;
        	}
        	if(!isCharacter(rightC)){
        		right--;
        		continue;
        	}
        	if(leftC != rightC){
        		return false;
        	}
        	left++;
        	right--;
        }
        return true;
    }

    inline bool isCharacter(char& data){
    	if(data>='a' && data<='z'){
    		return true;
    	}
    	else if(data>='A' && data<='Z'){
    		data = 'a' + data - 'A';
    		return true;
    	}
    	else if(data>='0' && data<='9'){
    		return true;
    	}
    	return false;
    }
};