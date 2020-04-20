class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        List<Integer> record = new ArrayList<>();
        for(int i=1; i<=m; i++){
            record.add(i);
        }
        for(int i=0; i<queries.length; i++){
            int current = queries[i];
            int index = record.indexOf(current);
            result[i] = index;
            record.remove(index);
            record.add(0, current);
        }
        return result;
    }
}