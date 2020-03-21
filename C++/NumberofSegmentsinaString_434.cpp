class Solution {
public:
    int countSegments(string s) {
        int length = s.size();
        int count = 0;
        bool isChar = false;
        bool isSpace = false;
        for(int i=0; i<length; i++){
        	if(s[i] != ' '){
        		if(!isChar){
        			isChar = true;
        		}
        		else if(isSpace){
        			count++;
        			isSpace = false;
        			isChar = false;
        		}
        	}
        	else {
        		if(isChar){
        			isSpace = true;
        		}
        	}
        }
        if(isChar){
        	count++;
        }
        return count;
    }
};