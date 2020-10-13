
class Solution {
    public int primePalindrome(int N) {
        if(N <= 2){
            return 2;
        }
        else if(N <= 3){
            return 3;
        }
        else if(N <= 5){
            return 5;
        }
        else if(N <= 7){
            return 7;
        }
        else if(N < 11) {
            N = 11;
        }
        String s = _start(N);
        int length = s.length();
        boolean isEven = (length & 1) == 0;
        while(true){
            int num = Integer.valueOf(s);
            if(_isPrime(num)){
                return num;
            }
            if(isEven){
                String tmp = s.substring(0, length >> 1);
                int i = Integer.valueOf(tmp);
                i++;
                String t = String.valueOf(i);
                if(t.length() > tmp.length()){
                    StringBuilder builder = new StringBuilder();
                    builder.append(t);
                    builder.append(_reverse(t.substring(0, tmp.length())));
                    s = builder.toString();
                }
                else {
                    StringBuilder builder = new StringBuilder();
                    builder.append(t);
                    builder.append(_reverse(t));
                    s = builder.toString();
                }
            }
            else {
                String tmp = s.substring(0, (length >> 1)+1);
                int i = Integer.valueOf(tmp);
                i++;
                String t = String.valueOf(i);
                if(t.length() > tmp.length()){
                    StringBuilder builder = new StringBuilder();
                    String ss = t.substring(0, tmp.length());
                    builder.append(ss);
                    builder.append(_reverse(ss));
                    s = builder.toString();
                }
                else {
                    StringBuilder builder = new StringBuilder();
                    String ss = t.substring(0, t.length()-1);
                    builder.append(t);
                    builder.append(_reverse(ss));
                    s = builder.toString();
                }
            }
            length = s.length();
            isEven = (length & 1) == 0;
        }
    }

    private String _start(int N){
        String s = String.valueOf(N);
        int length = s.length();
        boolean isEven = (length & 1) == 0;
        int half = length >> 1;
        String left = s.substring(0, half);
        String rLeft = _reverse(left);
        String right = s.substring(length - half);
        int l = Integer.valueOf(rLeft);
        int r = Integer.valueOf(right);
        StringBuilder builder = new StringBuilder();
        if(l >= r){
            builder.append(left);
            if(!isEven){
                builder.append(s.charAt(half));
            }
            builder.append(rLeft);
        }
        else {
            if(!isEven){
                left = left + s.charAt(half);
            }
            l = Integer.valueOf(left);
            l++;
            left = String.valueOf(l);
            builder.append(left);
            if(!isEven){
                builder.append(_reverse(left.substring(0, left.length()-1)));
            }
            else {
                builder.append(_reverse(left));
            }
        }
        return builder.toString();
    }

    private String _reverse(String s){
        StringBuilder builder = new StringBuilder();
        for(int i=s.length(); i > 0; i--){
            builder.append(s.charAt(i-1));
        }
        return builder.toString();
    }

    private boolean _isPrime(int n){
        int limit = (int)Math.sqrt(n);
        for(int i=2; i<=limit; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}