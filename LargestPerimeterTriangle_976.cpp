class Solution {
public:
    int largestPerimeter(vector<int>& A) {
        int length = A.size();
        sort(A.begin(), A.end());
        for(int i=length-3; i>=0; i--){
        	int c = A[i+2];
        	int b = A[i+1];
        	int a = A[i];
        	if(a + b > c && c-a < b){
        		return a+b+c;
        	}
        }
        return 0;
    }
};