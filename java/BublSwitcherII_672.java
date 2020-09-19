class Solution {
    public int flipLights(int n, int m) {
        Set<Integer> set = new HashSet<>();
        n = Math.min(n, 6);
        int shift = 6 - n;
        for(int i=0; i<16; i++){
            int bits = Integer.bitCount(i);
            if(bits <= m && bits % 2 == m%2){
                int lights = 0;
                if(((i >> 0) & 1) > 0){
                    lights = lights ^ (0b111111 >> shift);
                }

                if(((i >> 1) & 1) > 0){
                    lights = lights ^ (0b010101 >> shift);
                }

                if(((i >> 2) & 1) > 0){
                    lights = lights ^ (0b101010 >> shift);
                }

                if(((i >> 3) & 1) > 0){
                    lights = lights ^ (0b100100 >> shift);
                }
                set.add(lights);
            }
        }

        return set.size();
    }
}

