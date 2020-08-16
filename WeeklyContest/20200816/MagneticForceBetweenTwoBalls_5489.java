class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = (position[position.length-1] - position[0]);
        int result = 0;
        m--;
        while(left <= right){
            int mid = (left + right) / 2;
            if (_checkIsOk(position, m, mid)) {
                result = Math.max(result, mid);
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return result;
    }

    private boolean _checkIsOk(int[] positions, int m, int max){
        int start = positions[0];
        for(int i=0; i<positions.length; i++){
            if(positions[i] - start >= max){
                start = positions[i];
                m--;
            }
            if(m == 0){
                break;
            }
        }
        return m==0;
    }
}