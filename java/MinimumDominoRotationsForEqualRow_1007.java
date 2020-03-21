class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int length = A.length;
        int a=1, b=1;
        for(int i=1; i<length; i++){
        	if(A[i] == A[0] || B[i] == A[0]){
    			a++;
    		}

    		if(A[i] == B[0] || B[i] == B[0]){
    			b++;
    		}
        }
        int base = -1;
        if(a == length){
    		base = A[0];
    	}
    	else if(b == length){
    		base = B[0];
    	}
    	else {
    		return -1;
    	}
        int resultA = 0;
        int resultB = 0;
        for(int i=0; i<length; i++){
        	if(A[i] != base){
        		resultA++;
        	}
        	if(B[i] != base){
        		resultB++;
        	}
        }
        return Math.min(resultB, resultA);
    }
}