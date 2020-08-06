class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i=1; i<=n; i++){
            int tmp = (int)Math.sqrt(i);
            if(tmp * tmp == i){
                count++;
            }
        }
        return count;
    }
}