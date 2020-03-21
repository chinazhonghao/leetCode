class Solution {
public:
    string addStrings(string num1, string num2) {
        if(num1.size() < num2.size()){
        	swap(num1, num2);
        }
        int length1 = num1.size();
        int length2 = num2.size();
        int diff = length1 - length2;
        int carry = 0;
        vector<char> result;
        result.reserve(length1 + 1);
        int length = 0;
        for(int i=length2-1; i>=0; i--){
        	int sum = carry + num1[diff + i] + num2[i] - '0' - '0';
        	carry = 0;
        	if(sum > 9){
        		carry = 1;
        		sum = sum - 10;
        	}
        	result[length++] = sum + '0';
        }
        for(; length<length1; length++){
        	int sum = carry + num1[length1 - length] - '0';
        	carry = 0;
        	if(sum > 9){
        		carry = 1;
        		sum = sum - 10;
        	}
        	result[length] = sum + '0';
        }
        if(carry > 0){
        	result[length++] = carry + '0';
        }
        string str;
        for(int i=length-1; i>=0; i--){
        	str.append(1, result[i]);
        }
        return str;
    }
};