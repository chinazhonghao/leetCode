class Solution {
    public int findLatestStep(int[] arr, int m) {
        int maxStep = -1;
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ranges = new int[length][2];
        int[] lens = new int[length];
        for(int i=0; i<length; i++){
            int pos = arr[i] - 1;
            int len = 1;
            int start = pos;
            int end = pos;
            if(pos>0){
                len += lens[pos-1];
                if(lens[pos-1] > 0){
                    int count = map.get(lens[pos-1]);
                    start = ranges[pos-1][0];
                    if(count > 1){
                        map.put(lens[pos-1], count-1);
                    }
                    else {
                        map.remove(lens[pos-1]);
                    }
                }
            }

            if(pos<length-1){
                len += lens[pos+1];
                if(lens[pos+1] > 0){
                    int count = map.get(lens[pos+1]);
                    end = ranges[pos+1][1];
                    if(count > 1){
                        map.put(lens[pos+1], count-1);
                    }
                    else {
                        map.remove(lens[pos+1]);
                    }
                }
            }
            ranges[start] = new int[]{start, end};
            ranges[end] = new int[]{start, end};
            lens[start] = len;
            lens[end] = len;
            map.put(len, map.getOrDefault(len, 0)+1);
            if(map.containsKey(m)){
                maxStep = i+1;
            }
        }
        return maxStep;
    }
}