class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int, bool> numsExist;
        int lenght = nums.size();
        for(int i=0; i<lenght; i++){
            int currentKey = nums[i];
            try {
                return numsExist.at(currentKey);
            }
            catch(...){
                numsExist[currentKey] = true;
            }
        }
        return false;
    }
};