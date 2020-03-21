class Solution {
    public boolean canWinNim(int n) {
        int left = n % 4;
        return left > 0 && left < 4;
    }
}