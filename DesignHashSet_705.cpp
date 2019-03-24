class MyHashSet {
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        
    }
    
    void add(int key) {
        if(contains(key)){
            return;
        }
        data.push_back(key);
    }
    
    void remove(int key) {
        for(int i=0; i<data.size(); i++){
            if(data[i] == key){
                data.erase(data.begin() + i);
                return;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        for(int i=0; i<data.size(); i++){
            if(data[i] == key){
                return true;
            }
        }
        return false;
    }

private:
    vector<int> data;
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * bool param_3 = obj.contains(key);
 */