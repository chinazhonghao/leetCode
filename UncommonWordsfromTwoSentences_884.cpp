class Solution {
public:
    vector<string> uncommonFromSentences(string A, string B) {
        unordered_map<string, int> mapA, mapB;
        vector<string> _str;
        _split(A, _str);
        _count(_str, mapA);
        _str.clear();
        _split(B, _str);
        _count(_str, mapB);

        vector<string> result;
        vector<unordered_map<string, int> > mapContainer = {mapA, mapB};
        for(int i=0; i<2; i++){
        	unordered_map<string, int> mapLeft = mapContainer[i];
        	unordered_map<string, int> mapRight = mapContainer[1-i];
        	unordered_map<string, int>::iterator iter = mapLeft.begin();
	        for(; iter != mapLeft.end(); iter++){
	        	int count = iter->second;
	        	if(count == 1){
	        		string current = iter->first;
	        		if(mapRight.find(current) == mapRight.end()){
	        			result.push_back(current);
	        		}
	        	}
	        }
        }
        return result;
    }

    inline void _split(string& str, vector<string>& _str){
    	int length = str.size();
    	string flag = " ";
    	while(!str.empty()){
    		size_t pos = str.find_first_of(flag);
    		if(pos == string::npos){
    			_str.push_back(str);
    			str.clear();
    		}
    		else{
    			_str.push_back(str.substr(0, pos));
    			str = str.substr(pos+1);
    		}
    	}
    }

    inline void _count(vector<string> &_str, unordered_map<string, int>& _map){
    	int length = _str.size();
    	for(int i=0; i<length; i++){
    		string& current = _str[i];
    		unordered_map<string, int>::iterator iter = _map.find(current);
    		if(iter != _map.end()){
    			_map[current]++;
    		}
    		else{
    			_map[current] = 1;
    		}
    	}
    }
};