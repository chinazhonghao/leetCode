class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t result = 0;
        int index = 1;
        while(n != 0){
            uint32_t current = n & 0x01;
            current = current << (32 - index);
            result = result | current;
            index++;
            n = n>>1;
        }
        return result;
    }
};