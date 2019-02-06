class Solution {
public:
    bool isMonotonic(vector<int>& A) {
        int length = A.size();
        if(length < 2){
            return true;
        }
        bool increasing = true;
        int i=0;
        for(; i<length-1; i++){
            if(A[i] > A[i+1]){
                increasing = false;
                break;
            }
            else if(A[i] < A[i+1]){
                break;
            }
        }
        if(increasing){
            for(; i <length - 1; i++){
                if(A[i] > A[i+1]){
                    return false;
                }
            }
        }
        else{
            for(; i < length - 1; i++){
                if(A[i] < A[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
};