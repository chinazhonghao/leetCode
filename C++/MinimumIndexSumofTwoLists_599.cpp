class Solution {
public:
    vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
        vector<string> res;
        int length1 = list1.size();
        int length2 = list2.size();
        map<string, int> list2Map;
        for(int i=0; i<length2; i++){
        	list2Map.insert(pair<string, int>(list2[i], i));
        }
        int currentIndexSum = length2 + length1;
        map<string, int> sameRes;
        map<string, int>::iterator it;
        for(int i=0; i<length1; i++){
        	it = list2Map.find(list1[i]);
        	if(it != list2Map.end()){
        		sameRes.insert(pair<string, int>(list1[i], i+it->second));
        	}
        }
        for(it = sameRes.begin(); it != sameRes.end(); it++){
        	if(it->second < currentIndexSum){
        		currentIndexSum = it->second;
        	}
        }
        for(it = sameRes.begin(); it != sameRes.end(); it++){
        	if(it->second == currentIndexSum){
        		res.push_back(it->first);
        	}
        }
        return res;
    }
};