class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        int length1 = nums1.size();
        int length2 = nums2.size();
        vector<int> result;
        result.resize(length1);
        for(int i=0; i<length1; i++){
            int current = nums1[i];
            bool greater = false;
            int start = 0;
            for(int j=0; j<length2; j++){
                if(nums2[j]==current){
                    start = j+1;
                }
            }
            for(int j=start; j<length2; j++){
                if(nums2[j] > current){
                    start = j+1;
                    result[i] = nums2[j];
                    greater = true;
                    break;
                }
            }
            if(!greater){
                result[i] = -1;
            }
        }
        return result;
    }
};