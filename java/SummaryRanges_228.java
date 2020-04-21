class Solution {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList<>();
        if(length == 0){
            return result;
        }
        else if(length < 2){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int start = nums[0];
        int end = start;
        for(int i=1; i<length; i++){
            if(nums[i] > end+1){
                if(end == start){
                    result.add(String.valueOf(start));
                }
                else {
                    result.add(start+"->"+end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if(end == start){
            result.add(String.valueOf(start));
        }
        else {
            result.add(start+"->"+end);
        }
        return result;
    }
}