class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        Integer[] B = new Integer[A.length];
        for(int i=0; i<B.length; i++){
        	B[i] = i+1;
        }
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);
        for(int i=0; i<B.length; i++){
        	System.out.println(B[i]);
        }
        int N = A.length;
        for(int i=0; i<B.length; i++){
        	for(int j=0; j<result.size(); j++){
        		if(B[i] <= result.get(j)){
        			B[i] = f+1-B[i];
        		}
        	}
        	result.add(B[i]);
        	result.add(N--);
        }
        return result;
    }
}