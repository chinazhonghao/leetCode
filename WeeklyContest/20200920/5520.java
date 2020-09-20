class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return _recursive(s, set);
    }

    private int _recursive(String s, Set<String> set){
        int length = s.length();
        if(length == 0){
            return 0;
        }
        int max = 0;
        for(int i=1; i<=length; i++){
            String sub = s.substring(0, i);
            if(!set.contains(sub)){
                set.add(sub);
                int count = _recursive(s.substring(i), set);
                set.remove(sub);
                max = Math.max(max, count+1);
            }
        }
        return max;
    }
}