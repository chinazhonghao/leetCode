class Solution {
    public int[] prevPermOpt1(int[] A) {
        int indexA = -1;
        int minNum = Integer.MAX_VALUE;
        for(int i=A.length-1; i>=1; i--){
            if(A[i] < minNum){
                minNum = A[i];
            }

            if(A[i-1] > minNum){
                indexA = i;
                break;
            }
        }
        if(indexA <= 0){
            return A;
        }

        int indexB = -1;
        minNum = -1;
        for(int i=indexA; i<A.length; i++){
            if(A[i] > minNum && A[i] < A[indexA-1]){
                minNum = A[i];
                indexB = i;
            }
        }

        int tmp = A[indexA-1];
        A[indexA-1] = A[indexB];
        A[indexB] = tmp;
        return A;
    }
}