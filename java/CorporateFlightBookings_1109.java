class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for(int i=0; i<bookings.length; i++){
        	int[] current = bookings[i];
        	for(int j=current[0]; j<=current[1]; j++){
        		result[j-1] += current[2];
        	}
        }
        return result;
    }
}