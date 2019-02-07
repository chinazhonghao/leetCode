class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        vector<int> res;
        int length = A.size();
        int start = 0;
        while(start < length && A[start]<0){
        	start++;
        }
        int left = start-1;
        int right = start;
        for(; right<length && left >= 0; ){
        	if(left >=0){
        		if(A[right] < -A[left]){
        			res.push_back(A[right] * A[right]);
        			right++;
        		}
        		else{
        			res.push_back(A[left]*A[left]);
        			left--;
        		}
        	}
        }
        for(; right<length; right++){
        	res.push_back(A[right]*A[right]);
        }
        for(; left>=0; left--){
        	res.push_back(A[left]*A[left]);
        }
        return res;
    }
};