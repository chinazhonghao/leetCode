class Solution {
public:
    int countBinarySubstrings(string s) {
        int length = s.size();
        int sum = 0;
        int num_0 = 0;
        int num_1 = 0;
        if(s[0] == '0'){
            num_0 = 1;
        }
        else {
            num_1 = 1;
        }
        for(int i=1; i<length; i++){
            if(s[i-1] != s[i]){
                int num = num_0 < num_1 ? num_0 : num_1;
                sum += num;
                if(s[i] == '0'){
                    num_0 = 1;
                }
                else {
                    num_1 = 1;
                }
            }
            else {
                if(s[i] == '0'){
                    num_0++;
                }
                else {
                    num_1++;
                }
            }
        }
        sum += (num_0 < num_1 ? num_0 : num_1);
        return sum;
    }
};