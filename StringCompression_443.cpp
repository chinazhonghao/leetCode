class Solution {
public:
    int compress(vector<char>& chars) {
        int length = chars.size();
        int count = 1;
        char lastChar = chars[0];
        vector<char> result;
        for(int i=1; i<length; i++){
        	if(chars[i] == lastChar){
        		count++;
        	}
        	else{
        		result.push_back(lastChar);
        		if(count > 1){
        			vector<char> res;
        			splitNum(count, res);
        			for(int i=res.size()-1; i>=0; i--){
        				result.push_back(res[i]);
        			}
        		}
        		lastChar = chars[i];
        		count=1;
        	}
        }
        result.push_back(lastChar);
        if(count > 1){
        	vector<char> res;
		    splitNum(count, res);
		    for(int i=res.size()-1; i>=0; i--){
				result.push_back(res[i]);
			}
        }
        chars.clear();
        for(int i=0; i<result.size(); i++){
        	chars.push_back(result[i]);
        }
        return chars.size();
    }

    inline void splitNum(int num, vector<char>& res){
    	while(num > 0){
    		res.push_back(num % 10 + '0');
    		num /= 10;
    	}
    }
};