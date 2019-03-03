class Solution {
public:
    bool isHappy(int n) {
    	map<int, bool> record;
    	while(n != 1){
    		if(record.find(n) == record.end()){
    			record.insert(pair<int, bool>(n, true));
    		}
    		else{
    			return false;
    		}
    		vector<int> splitRes = splitN(n);
    		n = 0;
    		for(int i=0; i < splitRes.size(); i++){
    			n += splitRes[i] * splitRes[i];
    		}
    	}
    	return true;
    }

    vector<int> splitN(int n){
    	vector<int> splitRes;
    	int nextN = 0;
    	int res = 0;
    	while(n > 0){
    		nextN = n / 10;
    		res = n - nextN * 10;
    		n = nextN;
    		splitRes.push_back(res);
    	}
    	return splitRes;
    } 
};