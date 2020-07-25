class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C-A)*(D-B) + (G-E)*(H-F);
        int left = Math.max(B, F);
        int right = Math.min(D, H);
        int bottom = Math.max(A, E);
        int top = Math.min(C, G);
        if(left < right && bottom < top){
            return total - (right - left)*(top - bottom);
        }
        return total;
    }
}