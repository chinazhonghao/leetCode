class Solution {
    public int divide(int dividend, int divisor){
        int sign = 1;
        if(dividend > 0 && divisor < 0){
            sign = -1;
            if(divisor == Integer.MIN_VALUE){
                return 0;
            }
            divisor = -divisor;
        }
        else if (dividend < 0 && divisor > 0){
            if(dividend == Integer.MIN_VALUE && divisor == 1){
                return Integer.MIN_VALUE;
            }
            sign = -1;
            dividend = -dividend;
        }
        else if(dividend < 0 && divisor < 0){
            if(dividend == Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            }
            else if(divisor == Integer.MIN_VALUE){
                if(dividend == Integer.MIN_VALUE){
                    return 1;
                }
                return 0;
            }
            dividend = -dividend;
            divisor = -divisor;
        }

        int step = 1;
        int left = divisor;
        int count = 0;
        dividend -= left;
        while(dividend >= 0){
            if(left > dividend){
                left = divisor;
                step = 1;
            }
            count += step;
            dividend -= left;

            left += divisor;
            step++;
        }
        return sign < 1 ? -count: count;
    }
}