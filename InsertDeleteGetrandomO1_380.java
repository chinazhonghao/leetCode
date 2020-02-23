class RandomizedSet {

    private Map<Integer, Integer> m;
    private List<Integer> l;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        m = new HashMap<>();
        l = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if(!m.containsKey(val)){
            flag = true;
            m.put(val, l.size());
            l.add(val);
        }
        return flag;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!m.containsKey(val)){
            return false;
        }
        int index = m.get(val);
        int value = l.get(l.size()-1);
        l.set(index, value);
        l.remove(l.size()-1);
        m.remove(val);
        m.replace(value, index);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(rand.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */