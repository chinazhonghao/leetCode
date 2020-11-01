class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int row = destination[0];
        int col = destination[1];
        char[] flags = new char[row+col];
        for(int i=0; i<col; i++){
            flags[i] = 'H';
        }
        for(int i=col; i<col+row; i++){
            flags[i] = 'V';
        }
        int count = 1;
        int index = 1;
        while(count < k){
            count += index * row;
            if(index > 1){
                count--;
            }
            index++;
        }
        int prev = (count +1 - (index-1)*row);
        if(prev < k){

        }
        else {

        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<flags.length; i++){
            builder.append(flags[i]);
        }
        return builder.toString();
    }
}