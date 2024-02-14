package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

/* Программа эмулирует поведение данного кэша,
считывает текстовые файлы из системы и выдаваёт текст при запросе имени файла.
Если в кэше файла нет, кэш должен загрузить себе данные.
По умолчанию в кеше нет ни одного файла.
Текстовые файлы должны лежать в одной директории.
При запросе по ключу Names.txt - кеш должен вернуть содержимое файла Names.txt.
Важно! key это относительный путь к файлу в директории. */
public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    private String fileLines;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
        fileLines = load(cachingDir);
    }

    /*выдача текста из кеша */
    @Override
    protected String load(String key) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(Path.of(key).toFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                str.append(line).append(System.lineSeparator());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str.toString();
    }

    public String getFileLines() {
        return fileLines;
    }
}
