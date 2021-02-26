/**
 * @param {number[]} piles
 * @param {number} H
 * @return {number}
 */
var minEatingSpeed = function(piles, H) {
    let sum = 0, R = Math.max(...piles);
    sum = piles.reduce((sum, num) => sum + num, 0);
    let L = Math.ceil(sum / H);
    while(L < R){
      let M = Math.floor((L + R) / 2);
      let h = 0;
      piles.forEach(item => h+=Math.ceil(item / M));
      console.log(`L:${L}, R:${R}, M:${M}, h:${h}`);
      if(h <= H) {
        R = M;
      } else if( h > H) {
        L = M + 1;
      }
    }
    return L;
};

console.log(minEatingSpeed([3,6,7,11],8));
