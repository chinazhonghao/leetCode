class ProductOfNumbers {

	private List<Integer> nums;
	private int zeroIndex = -1;

    public ProductOfNumbers() {
        nums = new ArrayList<>();
    }
    
    public void add(int num) {
    	if(num == 0){
    		zeroIndex = nums.size()+1;
    		nums.add(1);
    		return;
    	}
        if(nums.size() < 1){
        	nums.add(num);
        }
        else {
        	nums.add(num * nums.get(nums.size()-1));
        }
    }
    
    public int getProduct(int k) {
    	if(k < 1 || k>nums.size()-zeroIndex){
    		return 0;
    	}
        int a = nums.get(nums.size()-1);
        int b = 1;
        if(nums.size()-k-1 >= 0){
        	b = nums.get(nums.size()-k-1);
        }
        return a / b;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */