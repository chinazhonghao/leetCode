/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    var left = 0, right = people.length, count = 0;
    people.sort((a, b) => a - b);
    while(right > left) {
      if(people[right-1] + people[left] > limit){
        count++;
        right--;
      }
      else {
        right--;
        left++;
        count++;
      }
    }
    return count;
};