class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(check(p1, p2, p3, p4)){
            return true;
        }

        if(check(p1, p2, p4, p3)){
            return true;
        }

        if(check(p1, p3, p4, p2)){
            return true;
        }

        return false;
    }

    private boolean check(int[] a, int[] b, int[] c, int[] d){
        int[] l1 = {b[0]-a[0], b[1]-a[1]};
        int[] l2 = {c[0]-a[0], c[1]-a[1]};
        int[] l3 = {d[0]-b[0], d[1]-b[1]};
        int[] l4 = {d[0]-c[0], d[1]-c[1]};
        int len1 = l1[0]*l1[0] + l1[1]*l1[1];
        int len2 = l2[0]*l2[0] + l2[1]*l2[1];
        int len3 = l3[0]*l3[0] + l3[1]*l3[1];
        int len4 = l4[0]*l4[0] + l4[1]*l4[1];
        if(len1==0 || len1 != len2 || len1 != len3 || len1 != len4){
            return false;
        }
        if(l1[0]*l4[1] != l1[1]*l4[0] || l2[0]*l3[1] != l2[1]*l3[0]){
            return false;
        }
        int[] l = {d[0]-a[0], d[1]-a[1]};
        if(len1+len2 != l[0]*l[0]+l[1]*l[1]){
            return false;
        }
        return true;
    }
}