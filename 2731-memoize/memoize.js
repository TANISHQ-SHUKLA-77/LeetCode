/**
 * @param {Function} fn
 * @return {Function}
 */

function memoize(fn) {
    
    const cache = new Map();

    return function(...args) {
        const key = JSON.stringify(args);

        if (cache.has(key)) {
            return cache.get(key); // return cached result if it exists
        }

        const result = fn.apply(this, args); // compute new result
        cache.set(key, result);               // store it in cache
        return result;                        // return the result
    };
}

/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */