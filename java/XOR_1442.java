class Solution {
    public int countTriplets(int[] arr) {
        int[] xor = new int[arr.length];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            xor[i+1] = xor[i] ^ arr[i];
        }
        for(int i=2; i<xor.length; i++){
            if(xor[i] == 0){
                count += (i);
            }
        }
        for(int i=0; i<arr.length-2; i++){
            for(int j=i+2; j<xor.length; j++){
                int tmp = xor[j] ^ xor[i];
                if(tmp == 0){
                    count += (j - i - 1);
                }
            }
        }
        return count;
    }
}