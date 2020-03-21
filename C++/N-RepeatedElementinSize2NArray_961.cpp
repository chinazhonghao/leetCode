class Solution {
public:
    int repeatedNTimes(vector<int>& A) {
        unordered_map<int, bool> mapA;
        int length = A.size();
        for(int i=0; i<length; i++){
        	int current = A[i];
        	if(mapA.find(current) != mapA.end()){
        		return current;
        	}
        	mapA[current] = true;
        }
        return 0;
    }
};