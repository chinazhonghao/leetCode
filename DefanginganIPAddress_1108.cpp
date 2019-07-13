class Solution {
public:
        string defangIPaddr(string address) {
            int length = address.size();
            char *p = new char[length+6+1];
            p[length+6] = 0;
            int k = 0;
            for(int i=0; i<length; i++){
                if(address[i]=='.'){
                    p[k++] = '[';
                    p[k++] = '.';
                    p[k++] = ']';
                }
                else{
                    p[k++] = address[i];
                }
            }
            return string(p, length+6);
        }
};