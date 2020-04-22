class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 0;
        Map<Integer, BitSet> reserves = new HashMap<>();
        for(int i=0; i<reservedSeats.length; i++){
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            if(reserves.containsKey(row)){
                reserves.get(row).set(col);
            }
            else {
                BitSet bitSet = new BitSet(11);
                bitSet.set(col);
                reserves.put(row, bitSet);
            }
        }

        for(int row: reserves.keySet()){
            BitSet bitSet = reserves.get(row);
            if(bitSet.get(2,10).isEmpty()){
                count += 2;
            }
            else {
                if(bitSet.get(2, 6).isEmpty() || bitSet.get(4, 8).isEmpty() || bitSet.get(6, 10).isEmpty()){
                    count++;
                }
            }
        }
        return count + (n - reserves.size())*2;
    }
}