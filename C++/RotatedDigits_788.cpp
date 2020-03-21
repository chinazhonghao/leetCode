class Solution {
public:
    int rotatedDigits(int N) {
        int sum = 0;
        for(int i=1; i<=N; i++){
            if(isValid(i)){
                sum++;
            }
        }
        return sum;
    }

    bool isValid(int num){
        bool contains2569 = false;
        int digit = 0;
        while(num > 0){
            digit = num % 10;
            if(digit==3 || digit==4 || digit==7){
                return false;
            }
            if(!contains2569 && (digit==2 || digit==5 || digit==6 || digit==9)){
                contains2569 = true;
            }
            num /= 10;
        }
        return contains2569;
    }
};