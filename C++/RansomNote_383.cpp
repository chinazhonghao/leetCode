class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        map<char, int> rCount, mCount;
        count(ransomNote, rCount);
        count(magazine, mCount);
        map<char, int>::iterator iter = rCount.begin();
        for(; iter != rCount.end(); iter++){
        	char current = iter->first;
        	if(mCount.find(current) == mCount.end()){
        		return false;
        	}
        	if(mCount[current] < iter->second){
        		return false;
        	}
        }
        return true;
    }

    inline void count(string& str, map<char, int>& c){
    	int length = str.size();
    	for(int i=0; i<length; i++){
    		char current = str[i];
    		if(c.find(current) != c.end()){
    			c[current]++;
    		}
    		else{
    			c[current] = 1;
    		}
    	}
    }
};