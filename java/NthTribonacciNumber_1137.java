class Solution {
    public int tribonacci(int n) {
    	int f0 = 0;
    	int f1 = 1;
    	int f2 = 1;
    	if(n == 0){
    		return 0;
    	}
    	else if(n <= 2){
    		return 1;
    	}
    	else {
    		int i = 3;
    		int f3 = 0;
    		while(i <= n){
    			f3 = f0 + f1 + f2;
    			f0 = f1;
    			f1 = f2;
    			f2 = f3;
    			i++;
    		}
    		return f3;
    	}
    }

    private int _tribonacci(int n){
    	if(n==0){
    		return 0;
    	}
    	else if(n <= 2){
    		return 1;
    	}
    	else {
    		return _tribonacci(n-3) + _tribonacci(n-2) + _tribonacci(n-1);
    	}
    }
}