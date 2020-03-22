class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m < 1){
        	return false;
        }
        int n = matrix[0].length;
        int length = m*n;
        int left = 0, right = length-1;
        while(left <= right){
        	int mid = (left + right) >> 1;
        	int row = mid / n;
        	int val = matrix[row][mid-row*n];
        	if(val > target){
        		right = mid-1;
        	}
        	else if(val < target){
        		left = mid+1;
        	}
        	else {
        		return true;
        	}
        }
        return false;
    }
}