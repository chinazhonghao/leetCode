class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = target;
        while(left < right){
        	int mid = (left + right) / 2;
        	int sum = _sum(arr, mid);
        	if(sum < target){
        		left = mid + 1;
        	}
        	else {
        		right = mid;
        	}
        }
        if(Math.abs(target - _sum(arr, left)) >= Math.abs(target - _sum(arr, left-1))){
        	return left - 1;
        }
        else {
        	return left;
        }
    }

    private int _sum(int[] arr, int val){
    	int value = 0;
    	for(int i=0; i<arr.length; i++){
    		value += arr[i] > val ? val : arr[i];
    	}
    	return value;
    }
}