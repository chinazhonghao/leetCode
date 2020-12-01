/**
 * 并发量控制的异步执行器
 * 实现 ParallelExecutor 类
 * constructor 中的 parallel 参数可以指定能够并发执行的 promise 数量
 * 可以在任何时候往里面push promiseMaker 但是同时只允许 parallel 个正在执行
 * 依次执行，直到所有队列中的promise被执行完毕
 */

/**
 * 请实现ParallelExecutor
 */
'use strict';

class ParallelExecutor {
    constructor(parallel) {
        this.buffer = new Array();
        this.blocked = new Array();
        this.limited = parallel;
    }
    push(promiseMaker) { 
        if(this.buffer.length < this.limited){
            let current = this.buffer.length;
            this.buffer.push(promiseMaker().then(() => this.done(current)));
        }
        else {
            this.blocked.push(promiseMaker);
        }
    }

    done(index){
        if(this.blocked.length < 1){
            this.buffer.splice(index, 1);
            return;
        }
        let current = this.blocked[0];
        this.blocked.splice(0, 1);
        this.buffer.splice(index, 1, current().then(() => this.done(index)));
    }
}

/**
 * Test case
 */
const exec1 = new ParallelExecutor(2);
const t = new Date().getTime();

const push = (name, pushTimeout, execTime) => {
    setTimeout(() => {
        exec1.push(() => {
            return new Promise((resolve) => {
                setTimeout(resolve, execTime);
            }).then(() => {
                console.log(`promise ${name} complete, cost: ${new Date().getTime() - t}`);
            });
        });
    }, pushTimeout);
};

push('p1', 0, 1000); // 第0ms push 一个开始执行 1000 ms之后的打印 promise
push('p2', 0, 500); // 第0ms push 一个开始执行 500 ms之后的打印 promise
push('p3', 0, 200); // 第0ms push 一个开始执行 200 ms之后的打印 promise
push('p4', 0, 500); // 第0ms push 一个开始执行 500 ms之后的打印 promise
push('p5', 1000, 500); // 第1000ms push 一个开始执行 500 ms之后的打印 promise

/**
 * 结果
 * 大约 500ms 后，打印：promise p2 complete
 * 大约 700ms 后，打印：promise p3 complete
 * 大约 1000ms 后，打印：promise p1 complete
 * 大约 1200ms 后，打印：promise p4 complete
 * 大约 1500ms 后，打印：promise p5 complete
 */