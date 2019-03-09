class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int length1 = nums1.size();
        int length2 = nums2.size();
        int startIndex1 = 0;
        int startIndex2 = 0;
        while(startIndex1<length1 && startIndex2<length2){
        	int current = nums1[startIndex1++];
        	while(startIndex2 < length2 && nums2[startIndex2] < current){
        		startIndex2++;
        	}
        	if(startIndex2<length2 && current == nums2[startIndex2]){
        		res.push_back(current);
        		startIndex2++;
        	}
        }
        return res;
    }
};