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
            SoftReference<V> softReference = new SoftReference<>(value);
            cache.put(key, softReference);
    }

    /* get достаёт из кеша */
    public final V get(K key) {
        V result = cache.get(key).get();
        if (result == null) {
            put(key, load(key));
        }
        return result;
    }

    /*load()  читает файл и получает его содержимое в виде строки */
    protected abstract V load(K key);
}
