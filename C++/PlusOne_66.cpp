class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int len = digits.size();
        int carryNum = 1;
        for(int i=len-1; i>=0; i--){
            int num = digits[i] + carryNum;
            if(num >= 10){
                num -= 10;
                carryNum = 1;
                digits[i] = num;
            }
            else{
                digits[i] = num;
                carryNum = 0;
            }
        }
        if(carryNum > 0){
            digits.insert(digits.begin(), carryNum);
        }
        return digits;
    }
};