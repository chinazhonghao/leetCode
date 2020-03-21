class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int CIRCLE = 26;
        set<char> _letters(letters.begin(), letters.end());
        vector<char> uniqueLetters(_letters.begin(), _letters.end());
        int left = 0;
        int right = uniqueLetters.size()-1;
        int mid;
        if(target >= uniqueLetters[right] || target < uniqueLetters[left]){
            return uniqueLetters[left];
        }
        if(target == uniqueLetters[left]){
            return uniqueLetters[left+1];
        }
        while(1){
            mid = (left + right) >> 1;
            if(mid == left){
                return uniqueLetters[right];
            }
            if(uniqueLetters[mid]>target){
                right = mid;
            }
            else {
                left = mid;
            }
        }
    }
};