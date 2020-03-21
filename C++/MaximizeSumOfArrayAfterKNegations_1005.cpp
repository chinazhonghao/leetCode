class Solution {
public:
    int largestSumAfterKNegations(vector<int>& A, int K) {
        int length = A.size();
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += A[i];
        }
        for(int i=0; i<K; i++){
            int minNum = A[0];
            int index = 0;
            for(int i=1; i<length; i++){
                if(minNum > A[i]){
                    minNum = A[i];
                    index = i;
                }
            }
            sum -= 2*minNum;
            A[index] = -A[index];
        }
        return sum;
    }
};