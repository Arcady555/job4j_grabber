package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        if (cache.get(key) == null) {
            StringBuilder text = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new FileReader(cachingDir + key))) {
                in.lines().forEach(s -> text.append(s).append(System.lineSeparator()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            cache.put(key, new SoftReference<>(text.toString()));
        }
        return cache.get(key).get();
    }

    @Override
    protected boolean validationKey(String key) {
        return new File(cachingDir + key).exists();
    }
}