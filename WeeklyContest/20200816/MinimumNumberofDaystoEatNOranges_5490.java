class Solution {
    Map<Integer, Integer> m;

    public int minDays(int n) {
        m = new HashMap<>();
        m.put(1, 1);
        m.put(2, 2);
        m.put(3, 2);
        return _recursive(n);
    }

    private int _recursive(int n){
        if(m.containsKey(n)){
            return m.get(n);
        }

        int count = Integer.MAX_VALUE;
        if(n % 2 == 0){
            count = Math.min(count, 1+_recursive(n/2));
        }
        else {
            count = Math.min(count, 1+_recursive(n-1));
        }

        if(n % 3 == 0){
            count = Math.min(count, 1+_recursive(n/3));
        }
        else if(n % 3 == 1){
            count = Math.min(count, 1+_recursive(n-1));
        }
        else {
            count = Math.min(count, 2+_recursive(n-2));
        }
        m.put(n, count);
        return count;
    }
}