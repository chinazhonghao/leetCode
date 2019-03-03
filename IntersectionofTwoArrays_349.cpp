class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> a(nums1.begin(), nums1.end());
        set<int> b(nums2.begin(), nums2.end());
        vector<int> res;
        set<int>::iterator it = a.begin();
        for(; it != a.end(); it++){
        	if(b.find(*it) != b.end()){
        		res.push_back(*it);
        	}
        }
        return res;
    }
};