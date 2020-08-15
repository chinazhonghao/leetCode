class Solution {
    public String originalDigits(String s) {
        int[] chs = new int[26];
        for(int i=0; i<s.length(); i++){
            chs[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        int[] counts = new int[10];
        String[][] records = {{"z", "0", "zero"}, {"w", "2", "two"}, {"u", "4", "four"}, {"f", "5", "five"}, {"r", "3", "three"},
                {"x", "6", "six"}, {"s", "7", "seven"}, {"g", "8", "eight"}, {"o", "1", "one"}, {"n", "9", "nine"}};
        for(int i=0; i<records.length; i++){
            String[] item = records[i];
            int count = chs[item[0].charAt(0) - 'a'];
            for(int j=0; j<item[2].length(); j++){
                count = Math.min(count, chs[item[2].charAt(j)-'a']);
            }
            counts[item[1].charAt(0) - '0'] = count;
            if(chs[item[0].charAt(0) - 'a'] > 0){
                for(int j=0; j<item[2].length(); j++){
                    chs[item[2].charAt(j)-'a'] -= count;
                }
            }
        }
        for(int i=0; i<counts.length; i++){
            for(int j=0; j<counts[i]; j++){
                builder.append(i);
            }
        }
        return builder.toString();
    }
}