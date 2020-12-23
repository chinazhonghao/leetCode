/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */
var maxProfitAssignment = function(difficulty, profit, worker) {
    var result = 0, buffer = [], i=0, j=0;
    for(i=0; i<difficulty.length; i++){
      buffer.push({
        difficulty: difficulty[i], 
        profit: profit[i]
      });
    }
    buffer.sort((a, b) => a.difficulty - b.difficulty);
    worker.sort((a, b) => a - b);
    for(i=0; i<worker.length; i++){
      var current = 0;
      for(j=0; j<buffer.length; j++){
        if(worker[i] >= buffer[j].difficulty){
          current = Math.max(current, buffer[j].profit);
        }
        else {
          break;
        }
      }
      result += current;
    }
    return result;
};