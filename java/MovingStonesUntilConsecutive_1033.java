import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        if(nums[2]-nums[0] < 3){
            return new int[]{0, 0};
        }
        int[] diff = new int[]{nums[1]-nums[0], nums[2]-nums[1]};
        int min = 0;
        int max = 0;
        if(diff[0] > 1 && diff[1]>1) {
            if(diff[0]==2 || diff[1]==2){
                min = 1;
            }
            else {
                min = 2;
            }
        }
        else {
            min = 1;
        }
        max = diff[0]+diff[1]-2;
        return new int[]{min, max};
    }
}