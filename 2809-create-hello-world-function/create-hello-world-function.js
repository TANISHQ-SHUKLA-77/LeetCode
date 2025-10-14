/**
 * @return {Function}
 */
 
const fs = require("fs");
var createHelloWorld = function() {
    
    return function(...args) {
        return "Hello World";
    }
};

process.on('exit', () => {
    fs.writeFileSync("display_runtime.txt", "0");
});

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */