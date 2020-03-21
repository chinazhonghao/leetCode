class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
    	if(arr.length < k){
    		return 0;
    	}
    	int sum = 0;
    	for(int i=0; i<k-1; i++){
    		sum += arr[i];
    	}
    	threshold *= k;
    	int count = 0;
        for(int i=k-1; i<arr.length; i++){
        	sum += arr[i];
        	if(sum >= threshold){
        		count++;
        	}
        	sum -= arr[i-k+1];
        }
        return count;
    }
}