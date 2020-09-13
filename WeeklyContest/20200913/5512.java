class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int counts = 0;
        int nums = pairs.length;
        if(nums < 2){
            return counts;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums; i++){
            int[] current = pairs[i];
            map.put(current[0], current[1]);
            map.put(current[1], current[0]);
        }
        for(int i=0; i<nums; i++){
            int x = pairs[i][0];
            int y = pairs[i][1];
            List<Integer> _x = _get(preferences[x], y);
            List<Integer> _y = _get(preferences[y], x);
            counts += _count(_x, preferences, map, x);
            counts += _count(_y, preferences, map, y);
        }
        return counts;
    }

    private List<Integer> _get(int[] preferences, int target){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<preferences.length; i++){
            if(preferences[i] == target){
                break;
            }
            result.add(preferences[i]);
        }
        return result;
    }

    private int _count(List<Integer> _x, int[][] preferences, Map<Integer, Integer> map, int x){
        int counts = 0;
        for(int m=0; m<_x.size(); m++){
            int u = _x.get(m);
            int v = map.get(u);
            List<Integer> _u = _get(preferences[u], v);
            for(int n=0; n<_u.size(); n++){
                if(_u.get(n) == x){
                    counts++;
                    break;
                }
            }
            if(counts>0){
                break;
            }
        }
        return counts;
    }
}