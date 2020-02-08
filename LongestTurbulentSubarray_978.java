class Solution {
    public int maxTurbulenceSize(int[] A) {
        int i=0, j=0;
        int less = 0;
        int count = 0;
        for(j=0; j<A.length-1; j++){
        	if(A[j] == A[j+1]){
        		less = 0;
        		count = Math.max(count, j-i+1);
        		i=j+1;
        		continue;
        	}
        	if(_isEven(j)){
        		if(less == 0){
        			if(A[j] > A[j+1]){
        				less = 1;
        			}
        			else if(A[j] < A[j+1]){
        				less = -1;
        			}
        			i = j;
        		}
        		else if(less == 1){
        			if(A[j] < A[j+1]){
        				count = Math.max(count, j-i+1);
        				less = -1;
        				i = j;
        			}
        		}
        		else if(less == -1){
        			if(A[j] > A[j+1]){
        				count = Math.max(count, j-i+1);
        				less = 1;
        				i = j;
        			}
        		}
        	}
        	else {
        		if(less == 0){
        			if(A[j] < A[j+1]){
        				less = 1;
        			}
        			else if(A[j] > A[j+1]){
        				less = -1;
        			}
        			i = j;
        		}
        		else if(less == 1){
        			if(A[j] > A[j+1]){
        				count = Math.max(count, j-i+1);
        				less = -1;
        				i = j;
        			}
        		}
        		else if(less == -1){
        			if(A[j] < A[j+1]){
        				count = Math.max(count, j-i+1);
        				less = 1;
        				i = j;
        			}
        		}
        	}
        }
        return Math.max(j-i+1, count);
    }

    private boolean _isEven(int val){
    	return (val & 1) == 0;
    }
}