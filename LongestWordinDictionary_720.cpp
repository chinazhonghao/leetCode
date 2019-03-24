class Solution {
public:
    string longestWord(vector<string>& words) {
        sort(words.begin(), words.end());
        int length = words.size();
        string last = "";
        string result = "";
        bool isBegin = false;
        
        for(int i=0; i<length; i++){
        	string& current = words[i];
        	int lastLen = last.size();
        	int currentLen = current.size();
        	if(currentLen == lastLen+1 && current.substr(0, lastLen) == last){
        		last = current;
        	}
        	else if(currentLen == lastLen+1 && current.substr(0, lastLen) != last){
        		updateResult(result, last);
        	}
        	else if(currentLen < lastLen+1){
        		updateResult(result, last);
        		if(current.substr(0, currentLen-1) == last.substr(0, currentLen-1)){
        			last = current;
        		}
        	}
        }
        updateResult(result, last);
        return result;
    }

    void updateResult(string& result, string& last){
    	if(last.size() > result.size()){
			result = last;
		}
		else if(last.size() == result.size() && last < result){
			result = last;
		}
    }

    void printStringVec(vector<string>& words){
    	for(int i=0; i<words.size(); i++){
    		cout<<words[i]<<endl;
    	}
    }
};