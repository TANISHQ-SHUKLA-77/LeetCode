const fs = require('fs')
var debounce = function(fn, t) {
    let timerId = null;
    return function(...args) {
        if (timerId !== null) clearTimeout(timerId);
        timerId = setTimeout(() => {
            fn(...args)
        }, t)
    }
};
process.on('exit', () => {
    fs.writeFileSync('display_runtime.txt', '0')
})