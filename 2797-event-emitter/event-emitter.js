class EventEmitter {
    #storage = {};

    subscribe(eventName, callback) {
        this.#storage[eventName] 
            ? this.#storage[eventName].push(callback) 
            : (this.#storage[eventName] = [callback])
        
        return {
            unsubscribe: () => {
                this.#storage[eventName] = 
                this.#storage[eventName].filter(c => c !== callback);
            }
        };
    }

    emit(eventName, args = []) {
        return this.#storage[eventName]?.map(c => c(...args)) ?? []
    }
}