class Solution {
    public int numTeams(int[] rating) {
        int count = _count(rating);
        int len = rating.length / 2;
        for(int i=0; i<len; i++){
            int tmp = rating[i];
            rating[i] = rating[rating.length-1-i];
            rating[rating.length-1-i] = tmp;
        }
        count += _count(rating);
        return count;
    }

    private int _count(int[] rating){
        int count = 0;
        int[] sum = new int[rating.length];
        for(int i=0; i<rating.length; i++){
            int small = 0;
            for(int j=0; j<i; j++){
                if(rating[j] < rating[i]){
                    small++;
                    if(sum[j] > 0){
                        count += sum[j];
                    }
                }
            }
            sum[i] = small;
        }
        return count;
    }
}