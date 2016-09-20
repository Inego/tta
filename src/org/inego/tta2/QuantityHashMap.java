package org.inego.tta2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inego on 17.09.2016.
 */
public class QuantityHashMap<T> extends HashMap<T, Integer> {

    @Override
    public Integer get(Object key) {
        if (!containsKey(key))
            return 0;
        return super.get(key);
    }

    public int delta(T key, int value) {
        int newValue = get(key) + value;
        if (newValue == 0)
            remove(key);
        else
            put(key, newValue);
        return newValue;
    }
}
