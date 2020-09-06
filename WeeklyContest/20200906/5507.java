class Solution {
    public String modifyString(String s) {
        String buffer = "abcdefghijklnmopqrstuvwxyz";
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        char prev = '#', next = '#';
        for(int i=0; i<length; i++){
            if(s.charAt(i) != '?'){
                builder.append(s.charAt(i));
            }
            else {
                if(i > 0){
                    prev = builder.charAt(i-1);
                }
                if(i < length-1){
                    next = s.charAt(i+1);
                }
                for(int j=0; j<buffer.length(); j++){
                    if(buffer.charAt(j) != prev && buffer.charAt(j) != next){
                        builder.append(buffer.charAt(j));
                        break;
                    }
                }
            }
        }
        return builder.toString();
    }
}