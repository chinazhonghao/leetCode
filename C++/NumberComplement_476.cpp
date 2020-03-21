class Solution {
public:
    int findComplement(int num) {
        int length = 0;
        int copy = num;
        while(num > 0){
            num = num >> 1;
            length++;
        }
        return ((long)1<<length) -1 - copy;
    }
};