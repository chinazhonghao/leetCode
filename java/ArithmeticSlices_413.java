class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        int start=0, current=2, len = A.length, count=0, span = A[1] - A[0];
        while (current < len) {
            if(A[current] - A[current-1] != span) {
                int length = current - start;
                count += (length - 1) * (length - 2) / 2;
                start = current-1;
                span = A[current] - A[start];
            }
            current++;
        }
        int length = current - start;
        count += (length -1)*(length-2)/2;
        return count;
    }
}