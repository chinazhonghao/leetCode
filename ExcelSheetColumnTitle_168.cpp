class Solution {
public:
    string convertToTitle(int n) {
        int base = 26;
        string result = "";
        while(n > 0){
        	int num = n % base - 1;
        	if(num < 0){
        		num += base;
        	}
        	string current(1, 'A' + num);
        	n = (n - num - 1) / base;
        	result = current + result;
        }
        return result;
    }
};