
class Solution {
    public String intToRoman(int num){
        Map<Integer, String> m = new HashMap<>() {
            {
                put(1000, "M");
                put(900, "CM");
                put(800, "DCCC");
                put(700, "DCC");
                put(600, "DC");
                put(500, "D");
                put(400, "CD");
                put(300, "CCC");
                put(200, "CC");
                put(100, "C");
                put(90, "XC");
                put(80, "LXXX");
                put(70, "LXX");
                put(60, "LX");
                put(50, "L");
                put(40, "XL");
                put(30, "XXX");
                put(20, "XX");
                put(10, "X");
                put(9, "IX");
                put(8, "VIII");
                put(7, "VII");
                put(6, "VI");
                put(5, "V");
                put(4, "IV");
                put(3, "III");
                put(2, "II");
                put(1, "I");
            }
        };
        StringBuilder builder = new StringBuilder();
        String numStr = String.valueOf(num);
        int length = numStr.length();
        for(int i=length; i>0; i--){
            int val = numStr.charAt(length-i) - '0';
            if(val == 0){
                continue;
            }
            if(i == 4){
                for(; val > 0; val--){
                    builder.append(m.get(1000));
                }
            }
            else if(i==3){
                builder.append(m.get(val*100));
            }
            else if(i == 2){
                builder.append(m.get(val*10));
            }
            else {
                builder.append(m.get(val));
            }
        }
        return builder.toString();
    }
}