
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> repeats = new HashMap<>();
        int sign = 1;
        long num1 = (long)numerator;
        long num2 = (long)denominator;
        if(num1 * num2 < 0){
            sign = -1;
        }
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        long num = 0;
        if(num1 > num2){
            num = num1 / num2;
            num1 -= num * num2;
        }
        if(num1 == 0){
            return sign>0?String.valueOf(num):"-"+String.valueOf(num);
        }
        num1 *= 10;
        StringBuilder leftBuilder = new StringBuilder();
        int index = 0;
        long left = 0;
        while(num1 != 0 && !repeats.containsKey(num1)){
            repeats.put(num1, index++);
            if(num1 >= num2){
                left = num1 / num2;
                num1 -= left * num2;
            }
            else {
                left = 0;
            }
            leftBuilder.append(left);
            num1 *= 10;
        }
        StringBuilder allBuilder = new StringBuilder();
        if(sign < 0){
            allBuilder.append("-");
        }
        allBuilder.append(num);
        allBuilder.append(".");
        if(num1 == 0){
            allBuilder.append(leftBuilder);
        }
        else {
            index = repeats.get(num1);
            allBuilder.append(leftBuilder.subSequence(0, index));
            allBuilder.append("(");
            allBuilder.append(leftBuilder.substring(index));
            allBuilder.append(")");
        }
        return allBuilder.toString();
    }
}