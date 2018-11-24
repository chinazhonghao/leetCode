class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        int currentLen = m;
        while(index1 < currentLen && index2 < n){
            if(nums1[index1] < nums2[index2]){
                index1++;
            }
            else{
                currentLen++;
                for(int i=currentLen-1; i > index1; i--){
                    nums1[i] = nums1[i-1];
                }
                nums1[index1] = nums2[index2];
                index2++;
                index1++;
            }
        }
        if(index2 < n){
            for(int i=0; i<n - index2; i++){
                nums1[index1] = nums2[index2+i];
                index1++;
            }
        }
    }
};