
class Solution {
    public boolean reorderedPowerOf2(int N) {
        String num = String.valueOf(N);
        int[] bits = new int[num.length()];
        int min = 1, max = 9;
        for(int i=0; i<num.length(); i++){
            bits[i] = Integer.valueOf(num.charAt(i));
            if(i > 0){
                min = min * 10;
                max = max * 10 + 9;
            }
        }
        Arrays.sort(bits);
        int pows = (int)(Math.log10(min) / Math.log10(2));
        int current = (int)Math.pow(2, pows+1);
        if(N < 10){
            current = 1;
        }
        while(current < max){
            if(_equal(bits, current)){
                return true;
            }
            current = current << 1;
        }
        return false;
    }

    private boolean _equal(int[] bits, int n){
        String num = String.valueOf(n);
        int[] current = new int[num.length()];
        for(int i=0; i<num.length(); i++){
            current[i] = num.charAt(i);
        }
        Arrays.sort(current);
        for(int i=0; i<bits.length; i++){
            if(bits[i] == current[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}