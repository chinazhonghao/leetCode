class Solution {
public:
    bool isUgly(int num) {
    	if(num == 0){
    		return false;
    	}
        int base[3] = {2, 3, 5};
        bool isNext = true;
        while(isNext){
        	isNext = false;
        	for(int i=0; i<3; i++){
        		if(isParam(num, base[i])){
        			num = num / base[i];
        			isNext = true;
        		}
        	}
        }
        return num==1;
    }

    inline bool isParam(int num, int base){
    	return (num / base) * base == num;
    }
};