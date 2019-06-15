class Solution {
public:
    string toLowerCase(string str) {
        int length = str.size();
        for(int i=0; i<length; i++){
            if(str[i]>='A' && str[i]<='Z'){
                str.replace(i, 1, 1, str[i]-'A'+'a');
            }
        }
        return str;
    }
};