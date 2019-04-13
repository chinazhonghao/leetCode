class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> result;
        for(int i=left; i<=right; i++){
            if(dividingNumbers((i))){
                result.push_back(i);
            }
        }
        return result;
    }

    inline bool dividingNumbers(int num){
        if(num == 0){
            return false;
        }
        int numCopy = num;
        bool status[10];
        memset(status, 0, sizeof(status));
        while(num > 0){
            int left = num % 10;
            if(left == 0){
                return false;
            }
            num /= 10;
            if(!status[left]){
                if((numCopy / left) * left == numCopy){
                    status[left] = true;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
};