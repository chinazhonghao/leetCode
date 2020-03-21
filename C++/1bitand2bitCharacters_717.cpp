class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        int length = bits.size();
        if(length < 1){
        	return false;
        }
        int lastBit = bits[length - 1];
        if(lastBit > 0){
        	return false;
        }
        int count = 0;
        for(int i=length-2; i>=0; i--){
        	if(bits[i]){
        		count++;
        	}
        	else{
        		break;
        	}
        }
        return (count+1) % 2;
    }
};