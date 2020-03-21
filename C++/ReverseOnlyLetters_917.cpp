class Solution {
public:
    string reverseOnlyLetters(string S) {
        int length = S.size();
        char * letters = new char[length+1];
        strcpy(letters, S.c_str());
        int left = 0;
        int right = length-1;
        while(left < right){
            if(!isLetter(letters[left])){
                left++;
                continue;
            }
            if(!isLetter(letters[right])){
                right--;
                continue;
            }
            char current = letters[left];
            letters[left] = letters[right];
            letters[right] = current;
            left++;
            right--;
        }
        string result(letters);
        delete [] letters;
        return result;
    }

    bool isLetter(char letter){
        if((letter>='a'&&letter<='z')||(letter>='A'&&letter<='Z')){
            return true;
        }
        return false;
    }
};