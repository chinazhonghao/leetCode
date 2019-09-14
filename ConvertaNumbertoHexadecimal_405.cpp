class Solution {
public:
    string toHex(int num) {
        stack<char> hex;
        long limit = 1;
        limit = limit << 32;
        long input = num;
        if(input < 0){
            input= limit + num;
        }
        char digit[16] = {'0', '1', '2', '3', '4', '5', '6', '7','8','9','a','b', 'c', 'd', 'e', 'f'};
        while(input > 0 || hex.size() == 0){
            int index = input & 0x0f;
            hex.push(digit[index]);
            input = input >> 4;
        }
        string hexStr;
        while(hex.size() > 0){
            hexStr.push_back(hex.top());
            hex.pop();
        }
        return hexStr;
    }
};