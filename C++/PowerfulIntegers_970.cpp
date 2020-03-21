class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        set<int> result;
        for(int i=0; ; i++){
        	for(int j=0; ; j++){
        		int num = pow(x, i) + pow(y, j);
        		if(num <= bound){
        			result.insert(num);
        		}
        		else{
        			break;
        		}
        		if(y==1){
        			break;
        		}
        	}
        	if(x==1 || pow(x, i) > bound){
        		break;
        	}
        }
        return vector<int>(result.begin(), result.end());
    }
};