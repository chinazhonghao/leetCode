class Solution {
public:
    int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i=L; i<=R; i++){
            if(isPrime(countBits(i))){
                count++;
            }
        }
        return count;
    }

    int countBits(int num){
        int count = 0;
        while(num > 0){
            count += (num & 0x01);
            num = num >> 1;
        }
        return count;
    }

    bool isPrime(int num){
        if(num==1){
            return false;
        }
        int half = sqrt(num);
        for(int i=2; i<=half; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
};