class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        int length = stones.size();
        if(length < 2){
            return stones[0];
        }
        int a = 0, b = 0;
        int count = length;
        while(count > 1){
            a = 0, b=0;
            if(stones[0] > stones[1]){
                b = 1;
            }
            else{
                a = 1;
            }
            for(int i=2; i<length; i++){
                if(stones[i] > stones[a]){
                    b = a;
                    a = i;
                }
                else if(stones[i] > stones[b]){
                    b = i;
                }
            }
            stones[a] -= stones[b];
            stones[b] = 0;
            if(stones[a] == 0){
                count -= 2;
            }
            else{
                count--;
            }
        }
        if(count==1){
            for(int i=0; i<length; i++){
                if(stones[i]!=0){
                    return stones[i];
                }
            }
        }
        return 0;
    }
};