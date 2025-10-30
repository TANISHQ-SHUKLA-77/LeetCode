var TimeLimitedCache = function() {
    this.map = new Map();
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    const existing = this.map.get(key);
    const stillValid = existing && existing.expiry > now;

    if (existing) {
        clearTimeout(existing.timerId);
        // if expired, remove it before continuing (we'll overwrite anyway)
        if (!stillValid) this.map.delete(key);
    }

    const expiry = now + duration;
    const timerId = setTimeout(() => {
        // remove entry when it expires
        this.map.delete(key);
    }, duration);

    this.map.set(key, { value, expiry, timerId });

    return Boolean(stillValid);
};

TimeLimitedCache.prototype.get = function(key) {
    const now = Date.now();
    const rec = this.map.get(key);
    if (!rec) return -1;
    if (rec.expiry <= now) {
        clearTimeout(rec.timerId);
        this.map.delete(key);
        return -1;
    }
    return rec.value;
};

TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let cnt = 0;
    for (const [k, rec] of this.map) {
        if (rec.expiry > now) cnt++;
        else {
            // cleanup any expired entries we encounter
            clearTimeout(rec.timerId);
            this.map.delete(k);
        }
    }
    return cnt;
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */