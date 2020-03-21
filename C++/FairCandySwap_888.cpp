class Solution
{
  public:
    vector<int> fairCandySwap(vector<int> &A, vector<int> &B)
    {
        int lengthA = A.size();
        int lengthB = B.size();
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < lengthA; i++)
        {
            sumA += A[i];
        }
        for (int i = 0; i < lengthB; i++)
        {
            sumB += B[i];
        }
        int diff = (sumA - sumB) >> 1;
        set<int> setB;
        for(int i=0; i<lengthB; i++){
            setB.insert(B[i]);
        }
        for(int i=0; i<lengthA; i++){
            int current = A[i] - diff;
            if(setB.find(current) != setB.end()){
                return {A[i], current};
            }
        }
        
        return {0, 0};
    }
};