package me.centauri07.menu.jda.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class BlockingMap<K, V> {
    private final ConcurrentHashMap<K, CompletableFuture<V>> map = new ConcurrentHashMap<>();

    public V take(K key) {
        CompletableFuture<V> future = new CompletableFuture<>();
        map.put(key, future);

        try {
            return future.join();
        } finally {
            map.remove(key, future);
        }
    }

    public void put(K key, V value) {
        CompletableFuture<V> future = map.remove(key);

        if (future != null) {
            future.complete(value);
        }
    }
}
