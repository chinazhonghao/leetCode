class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int max = (stones[n-1]-stones[0]+1-n) - Math.min(stones[1]-stones[0]-1, stones[n-1]-stones[n-2]-1);
        int min = max;
        for(int i=0; i<n; i++){
            int j=i;
            while(j+1<n&&stones[j+1]-stones[i]+1<=n){
                j++;
            }
            int left = n - (j-i+1);
            if((j-i+1)==n-1&&stones[j+1]-stones[i]+1==n-1){
                left = 2;
            }
            min = Math.min(min, left);
        }
        return new int[]{min, max};
    }
}