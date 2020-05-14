class Solution {
    private int[] nums;

    public boolean circularArrayLoop(int[] nums) {
        this.nums = nums;
        int slow = 0, fast = 0;
        boolean[] flag = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(flag[i]){
                continue;
            }
            slow = fast = i;

            while(nums[next(slow)]*nums[next(fast)]>0 && nums[next(slow)]*nums[next(next(fast))]>0){
                if(flag[slow]){
                    break;
                }
                flag[slow] = true;
                slow = next(slow);
                fast = next(next(fast));
                if(slow == fast){
                    if(slow != next(slow)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int next(int base){
        base += this.nums[base];
        while(base < 0){
            base += this.nums.length;
        }
        return base % this.nums.length;
    }
}