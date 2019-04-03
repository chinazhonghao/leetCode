class Solution {
public:
    int reverse(int x) {
        bool isNegetive = (x < 0);
        long num = 0;
        while(x != 0){
            num = num*10 + x % 10;
            x = x / 10;
        }
        if(isNegetive){
            if(num + INT_MIN > 0){
                return 0;
            }
        }
        else{
            if(num > INT_MAX){
                return 0;
            }
        }
        return num;
    }
};