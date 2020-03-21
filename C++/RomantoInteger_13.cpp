class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> romanMap;
        char romanDigit[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int romanNum[] = {1, 5, 10, 50, 100, 500, 1000};
        for(int i=0; i<7; i++){
            romanMap.insert(pair<char, int>(romanDigit[i], romanNum[i]));
        }
        char next;
        char current;
        int length = s.length();
        int num = 0;
        int i=0;
        for(; i<length-1; i++){
            current = s[i];
            next = s[i+1];
            int tmp = romanMap[current];
            if(romanMap[current] < romanMap[next]){
                tmp = romanMap[next] - tmp;
                i++;
            }
            num += tmp;
        }
        if(i==length){
            return num;
        }
        return num + romanMap[s[i]];
    }
};