package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* структура данных типа кеш */
public abstract class AbstractCache<K, V> {
    /* K =  ключ получения, V - кэш, если нет, то загрузить */
    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    /* put кладёт в кэш */
    public final void put(K key, V value) {
            cache.put(key, new SoftReference<>(value));
    }

    /* get достаёт из кеша */
    public final V get(K key) {
        V res = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (res == null) {
            res = load(key);
            cache.put(key, new SoftReference<>(res));
        }
        return res;
    }

    /*load()  читает файл и получает его содержимое в виде строки */
    protected abstract V load(K key);
}
