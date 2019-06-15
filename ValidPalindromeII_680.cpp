class Solution {
public:
    bool validPalindrome(string s) {
        int length = s.size();
        int left = 0;
        int right = length-1;
        int count = 0;
        return isValid(s, left, right, count);
    }

    bool isValid(string& s, int left, int right, int count){
        while(left <= right){
            if(count > 1){
                return false;
            }
            if(s[left] != s[right]){
                count++;
                return isValid(s, left+1, right, count) ? true : isValid(s, left, right-1, count);
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }
};