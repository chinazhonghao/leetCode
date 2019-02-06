class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int length = A.size();
        int even = 0;
        int odd = 1;
        while(true){
            while(even < length && isEven(A[even])){
                even += 2;
            }
            while(odd < length && !isEven(A[odd])){
                odd += 2;
            }
            if(even < length && odd < length){
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
            }
            else{
                break;
            }
        }
        return A;
    }

    bool isEven(int num){
        return ((num >> 1) << 1) == num;
    }
};