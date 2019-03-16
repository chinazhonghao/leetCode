class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        vector<string> line = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int length = words.size();
        vector<string> res;
        for(int i=0; i<length; i++){
        	string& current = words[i];
        	int len = current.size();
        	int l = -1;
        	int pos = 0;
        	bool sameLine = true;
        	for(int j=0; j<len; j++){
        		char c = current[j];
        		if(c>='A' && c<='Z'){
        			c += ('a' - 'A');
        		}
        		for(int k=0; k<3; k++){
        			pos = line[k].find(c);
        			if(pos != -1){
        				if(l != -1){
        					if(l != k){
        						sameLine = false;
	        				}
	        				else{
	        					sameLine = true;
	        				}
	        			}
	        			else{
	        				sameLine = true;
	        				l = k;
	        			}
	        			break;
        			}
        		}
        		if(!sameLine){
        			break;
        		}
        	}
        	if(sameLine){
        		res.push_back(current);
        	}
        }
        return res;
    }
};