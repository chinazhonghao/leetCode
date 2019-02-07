class Solution {
public:
    vector<int> sumEvenAfterQueries(vector<int>& A, vector<vector<int>>& queries) {
        vector<int> res;
        int length = A.size();
        int evenSum = 0;
        for(int i=0; i<length; i++){
        	if(isEven(A[i])){
        		evenSum += A[i];
        	}
        }
        length = queries.size();
        for(int i=0; i<length; i++){
        	vector<int> &current = queries[i];
        	int val = current[0];
        	int index = current[1];
        	int tmp = A[index];
        	if(isEven(tmp)){
        		evenSum -= tmp;
        	}
        	tmp += val;
        	if(isEven(tmp)){
        		evenSum += tmp;
        	}
        	A[index] = tmp;
        	res.push_back(evenSum);
        }
        return res;
    }

    bool isEven(int num){
    	num = num > 0 ? num : -num;
    	return ((num >> 1) << 1) == num;
    }
};