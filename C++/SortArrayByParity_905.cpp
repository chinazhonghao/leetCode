class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        int left = 0;
        int right = A.size();
        while(right > left){
            int halfA;
            int recoverA;
            while(left < right){
                halfA = A[left] >> 1;
                recoverA = halfA << 1;
                if(recoverA != A[left]){
                    break;
                } 
                left++;
            }
            while(left < right){
                halfA = A[right-1] >> 1;
                recoverA = halfA << 1;
                if(recoverA == A[right-1]){
                    break;
                }
                right--;
            }
            if(left < right){
                int tmp = A[left];
                A[left] = A[right-1];
                A[right-1] = tmp;
            }
        }
        return A;
    }
};
