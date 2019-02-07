class Solution {
public:
    bool validMountainArray(vector<int>& A) {
        int length = A.size();
        if(length < 3){
        	return false;
        }
        int left = 1;
        if(A[0] >= A[1]){
        	return false;
        }
        for(; left < length; left++){
        	if(A[left-1] < A[left]){
        		continue;
        	}
        	else if(A[left-1] == A[left]){
        		return false;
        	}
        	break;
        }
        int right = length - 2;
        if(A[right] <= A[length-1]){
        	return false;
        }
        for(; right > 0; right--){
        	if(A[right] > A[right+1]){
        		continue;
        	}
        	break;
        }
        if(right+1 != left-1){
        	return false; 
        }
        return true;
    }
};