class Solution {
    public int[] advantageCount(int[] A, int[] B) {
    	int length = A.length;
    	Node[] C = new Node[length];
    	for(int i=0; i<length; i++){
    		C[i] = new Node(B[i], i);
    	}
    	Arrays.sort(A);
    	Arrays.sort(C, (a, b) -> a.val - b.val);

    	int[] D = new int[length];
    	int left = 0;
    	int right = length-1;
    	for(int i=0; i<length; i++) {
    		if(A[i] > C[left].val){
    			D[C[left++].index] = A[i];
    		}
    		else {
    			D[C[right--].index] = A[i];
    		}
    	}
    	return D;
    }
}

class Node {
	public Node(int val, int index){
		this.val = val;
		this.index = index;
	}

	public int val;
	public int index;
}