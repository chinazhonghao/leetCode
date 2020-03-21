class Solution {
    public int sumSubarrayMins(int[] A) {
        int[] B = new int[A.length];
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int count = 0;
        int mod = 1000000000 + 7;
        for(int i=0; i<A.length; i++){
        	int base = -1;
        	while(s.peek() > -1){
        		int index = s.peek();
        		if(A[index] < A[i]){
        			base = index;
        			break;
        		}
        		s.pop();
        	}

        	B[i] = ((i - base) * A[i]) % mod;
        	if(base > -1){
        		B[i] += B[base];
        	}

        	count = (count + B[i]) % mod;
        	s.push(i);
        }
        return count;
    }
}