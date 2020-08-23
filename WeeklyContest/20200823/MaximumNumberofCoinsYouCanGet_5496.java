class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int maxCounts = 0;
        int cycles = piles.length / 3;
        int index = cycles;
        for(int i=0; i<cycles; i++){
            maxCounts += piles[index];
            index += 2;
        }
        return maxCounts;
    }
}