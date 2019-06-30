class Solution {
public:
    string toGoatLatin(string S) {
        char * c_str = new char[S.size()+1];
        strcpy(c_str, S.c_str());
        char * p = strtok(c_str, " ");
        string result = "";
        int index = 1;
        while(p){
            string convert = "";
            if(isVowel(p[0])){
                convert += p;
            }
            else{
                convert += (p+1);
                convert += (string(1, p[0]));
            }
            convert += "ma";
            for(int i=0; i<index; i++){
                convert += "a";
            }
            if(result.size() > 0){
                result += " ";
            }
            result += convert;
            p = strtok(NULL, " ");
            index++;
        }
        return result;
    }

    bool isVowel(char letter){
        static char vowel[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(int i=0; i<10; i++){
            if(letter == vowel[i]){
                return true;
            }
        }
        return false;
    }
};