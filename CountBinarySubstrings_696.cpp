class Solution {
public:
    int countBinarySubstrings(string s) {
        int length = s.size();
        int count0 = 1;
        int count1 = 0;
        int sum = 0;
        int state = 0;
        bool first = false;
        if(length < 1){
            return 0;
        }
        if(s[0] == '1'){
            state = 1;
            count0 = 0;
            count1 = 1;
        }
        for(int i=1; i<length; i++){
            if(s[i] == '0'){
                if(state == 0){
                    state = 1;
                    if(first){
                        cout<<0<<":"<<sum<<":"<<count0<<":"<<count1<<endl;
                        sum += (count0 > count1 ? count1 : count0);
                        count0 = 0;
                    }
                    else{
                        first = true;
                    }
                }
                count0++;
            }
            else {
                if(state == 1){
                    state = 0;
                    if(first){
                        sum += (count0 > count1 ? count1 : count0);
                        count1 = 0;
                    }
                    else{
                        first = true;
                    }
                }
                count1++;
            }
        }
        sum += (count0 > count1 ? count1 : count0);
        return sum;
    }
};