class Solution {
    public String reorderSpaces(String text) {
        String[] ts = text.split(" ");
        int counts = 0;
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i) == ' '){
                counts++;
            }
        }
        List<String> t = new ArrayList<>();
        for(int i=0; i<ts.length; i++){
            if(ts[i].length()>0 && ts[i].charAt(0) != ' '){
                t.add(ts[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(t.get(0));
        if(t.size() == 1){
            for(int i=0; i<counts; i++){
                builder.append(' ');
            }
        }
        else {
            int num = t.size() - 1;
            int s = counts / num;
            int l = counts - s * num;
            for(int i=1; i<t.size(); i++){
                for(int j=0; j<s; j++){
                    builder.append(' ');
                }
                builder.append(t.get(i));
            }
            for(int j=0; j<l; j++){
                builder.append(' ');
            }
        }
        return builder.toString();
    }
}