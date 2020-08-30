class Solution {
    public String optimalDivision(int[] nums) {
        int length = nums.length;
        StringBuilder str = new StringBuilder();
        str.append(nums[0]);
        if(length == 1) {
            return str.toString();
        }
        else if(length == 2){
            str.append("/"+nums[1]);
            return str.toString();
        }

        str.append("/(");
        for(int i=1; i<length; i++){
            str.append(nums[i]);
            str.append("/");
        }
        str.deleteCharAt(str.length()-1);
        str.append(")");
        return str.toString();
    }
}