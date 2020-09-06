class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return _cal(nums1, nums2) + _cal(nums2, nums1);
    }

    private int _cal(int[] nums1, int[] nums2){
        Map<Long, Integer> m1 = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            long num = (long)nums1[i] * (long)nums1[i];
            if(m1.containsKey(num)){
                m1.put(num, m1.get(num)+1);
            }
            else {
                m1.put(num, 1);
            }
        }
        int result = 0;
        for(int i=0; i<nums2.length; i++){
            for(int j=i+1; j<nums2.length; j++){
                long num = (long)nums2[i] * (long)nums2[j];
                if(m1.containsKey(num)){
                    result += m1.get(num);
                }
            }
        }
        return result;
    }
}