
class Solution {
    public String solveEquation(String equation) {
        int length = equation.length();
        String[] all = equation.split("=");
        int[] left = parse(all[0]);
        int[] right = parse(all[1]);
        int x = left[0] - right[0];
        int num = right[1] - left[1];
        if(x == 0 && num == 0){
            return "Infinite solutions";
        }
        else if(x==0){
            return "No solution";
        }
        else {
            return "x="+((int)num/x);
        }
    }

    private int[] parse(String input){
        int x = 0;
        int num = 0;
        int length = input.length();
        StringBuilder builder = new StringBuilder();
        int sign = 1;
        for(int i=0; i<length; i++){
            char current = input.charAt(i);
            if(current == '+'){
                if(input.charAt(i-1) != 'x'){
                    num += sign * Integer.valueOf(builder.toString());
                }
                sign = 1;
                builder = new StringBuilder();
            }
            else if(current == '-'){
                if(i-1 >=0 && input.charAt(i-1)!='x'){
                    num += sign * Integer.valueOf(builder.toString());
                }
                sign = -1;
                builder = new StringBuilder();
            }
            else if(current == 'x'){
                if(builder.length() < 1){
                    x += sign;
                }
                else {
                    x += sign*Integer.valueOf(builder.toString());
                }
                builder = new StringBuilder();
            }
            else {
                builder.append(current);
            }
        }
        if(input.charAt(length-1) != 'x'){
            num += sign * Integer.valueOf(builder.toString());
        }
        return new int[]{x, num};
    }
}