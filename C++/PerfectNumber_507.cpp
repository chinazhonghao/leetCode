class Solution {
public:
    bool checkPerfectNumber(int num) {
        if(num == 1){
            return false;
        }
        int sum = 0;
        int half = sqrt(num);
        for(int i=2; i<=half; i++){
            if((num / i)*i == num){
                sum += i + num / i;
            }
        }
        return sum+1 == num;
    }
};