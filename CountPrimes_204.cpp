class Solution {
public:
    int countPrimes(int n) {
    	int count = 0;
        unsigned char* prime = new unsigned char[n];
        memset(prime, 1, n);
        for(int i=2; i*i < n; i++){
        	for(int j=i; j*i<n; j++){
        		prime[j*i] = 0;
        	}
        }
        for(int i=2; i<n; i++){
        	count += prime[i];
        }
        return count;
    }
};