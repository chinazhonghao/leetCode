
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] counts = new int[nums.length];
        int[] indexs = new int[nums.length];
        indexs[0] = -1;
        for(int i=1; i<nums.length; i++){
            int maxCount = 0, index = -1;
            for(int j=i; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    if(counts[j] > maxCount){
                        maxCount = counts[j];
                        index = j;
                    }
                }
            }
            counts[i] = maxCount + 1;
            indexs[i] = index;
        }

        int currentIndex = -1, maxCount=0;
        for(int i=0; i<nums.length; i++){
            if(counts[i] > maxCount){
                maxCount = counts[i];
                currentIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(currentIndex > -1){
            result.add(nums[currentIndex]);
            currentIndex = indexs[currentIndex];
        }
        return result;
    }
}