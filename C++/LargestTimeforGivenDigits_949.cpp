class Solution {
public:
    string largestTimeFromDigits(vector<int>& A) {
        string result;
        for(int i=23; i>=0; i--){
            int left = i % 10;
            int right = i / 10;
            left = findIn(A, left);
            vector<int> B;
            eraseEle(A, B, left);
            right = findIn(B, right);
            vector<int> C;
            eraseEle(B, C, right);
            if(left > -1 && right > -1) {
                for(int j=59; j>=0; j--) {
                    int m = j%10;
                    int n = j/10;
                    m = findIn(C, m);
                    vector<int> D;
                    eraseEle(C, D, m);
                    n = findIn(D, n);
                    if(m>-1 && n>-1) {
                        result.append(1, '0'+B[right]);
                        result.append(1, '0'+A[left]);
                        result.append(1, ':');
                        result.append(1, '0'+D[n]);
                        result.append(1, '0'+C[m]);
                        return result;
                    }
                }
            }
        }
        return result;
    }

    inline int findIn(vector<int>& A, int value) {
        int length = A.size();
        bool isFind = false;
        for(int i=0; i<length; i++) {
            if(A[i] == value) {
                return i;
            }
        }
        return -1;
    }

    inline void eraseEle(vector<int>& A, vector<int>& B, int index){
        int length = A.size();
        for(int i=0; i<length; i++){
            if(i != index){
                B.push_back(A[i]);
            }
        }
    }
};