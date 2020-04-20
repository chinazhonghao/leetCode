class Solution {
    public int numTimesAllBlue(int[] light) {
        int count = 0;
        int sum = 0;
        int max = 0;
        for(int i=0; i<light.length; i++){
            sum += 1;
            max = Math.max(max, light[i]);
            if(max == sum){
                count++;
            }
        }
        return count;
    }
}