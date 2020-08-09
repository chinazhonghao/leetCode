class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y){
            return false;
        }
        if(z==x || z==y){
            return true;
        }

        while(y > 0){
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return z % x == 0;
    }
}