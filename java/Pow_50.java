class Solution {
    public double myPow(double x, int n){
        if(x == 1){
            return 1;
        }
        long step = 1;
        long inc = 0;
        double result = 1;
        long count = (long)n;
        if(count < 0){
            x = 1 / x;
            count = -count;
        }
        double stepResult = x;
        Map<Long, Double> m = new HashMap<>();
        m.put((long)1, stepResult);
        while(inc < count){
            if(inc + step > count){
                step = count - inc;
                if(m.containsKey(step)){
                    stepResult = m.get(step);
                }
                else {
                    step = 1;
                    stepResult = x;
                }
            }
            result = result * stepResult;
            inc += step;
            step += step;
            stepResult *= stepResult;
            m.put(step, stepResult);
        }
        return result;
    }
}