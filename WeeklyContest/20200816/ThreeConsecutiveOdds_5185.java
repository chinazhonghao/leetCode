class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int length = arr.length;
        int count = 0;
        for(int i=0; i<length; i++){
            if((arr[i] & 1) == 0){
                count = 0;
            }
            else {
                count++;
                if(count >= 3){
                    return true;
                }
            }
        }
        return false;
    }
}