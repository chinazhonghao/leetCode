class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int[] a = new int[A.length];
        int[] b = new int[A.length];
        if(A[0]<L){
        	b[0] = 1;
        }
        else if(A[0]>=L && A[0]<=R){
        	a[0] = 1;
        }
        for(int i=1; i<A.length; i++){
        	if(A[i] < L){
        		a[i] = a[i-1];
        		b[i] = b[i-1]+1;
        	}
        	else if(A[i]>=L && A[i]<=R){
        		a[i] = 1 + a[i-1] + b[i-1];
        	}
        }
        int result = 0;
        for(int i=0; i<A.length; i++){
        	result += a[i];
        }
        return result;
    }
}