/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 1 массив резалт, счетчик для промисов, перебор функций, внутри запучкаем, , если ок то результат записываем в резалт счетчик палсс пласс проверяем если счетчик длинне массива то резолв. кетч еррор с реджет и если массив 0 то резолвим
 */
var promiseAll = function(functions) {

    return new Promise ((resolve, reject) => {

const result = [];
let counter = 0;

functions.forEach((fn, index) => {
    fn()
    .then(res => {
        result[index] = res;
        counter++;
        
        if(counter === functions.length){
            resolve(result)
        }
    })
    .catch(err => reject(err))
});

if(functions.length === 0) {
    resolve([])
}



    })
    
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */