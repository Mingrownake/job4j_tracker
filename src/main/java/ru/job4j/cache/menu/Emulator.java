package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    /**
     * - указать кэшируемую директорию
     * - загрузить содержимое файла в кэш
     * - получить содержимое файла из кэша
     */
    public final int setCacheDir = 1;
    public final int loadFileIntoCache = 2;
    public final int getFileFromCache = 3;
    public final String select = "Выберите пункт меню";
    public final String exit = "Конец работы";

    public final String menu = """
                Введите 1, чтобы указать кэшируемую директорию.
                Введите 2, чтобы загрузить содержимое файла в кэш.
                Введите 3, чтобы получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;
//C:\projects\job4j_tracker\src\main\java\ru\job4j\cache\files\names.txt

    private void start(Scanner scanner) {
        boolean run = true;
        DirFileCache dirFileCache = null;
        String fileName = null;
        while (run) {
            System.out.println(menu);
            System.out.println(select);
            int userChoice = scanner.nextInt();
            if (setCacheDir == userChoice) {
                System.out.println("Введите название директории : ");
                fileName = scanner.next();
                dirFileCache = new DirFileCache(fileName);
                System.out.println("Кэшируемая директория : " + fileName);

            } else if (loadFileIntoCache == userChoice) {
                System.out.println("Загружаем содержимое файла в кэш.");

                dirFileCache.put(fileName, dirFileCache.getFileLines());

            } else if (getFileFromCache == userChoice) {
                System.out.println("Получаем содержимое из кеша.");
                System.out.println(dirFileCache.get(fileName));

            } else {
                run = false;
                System.out.println(exit);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Emulator emulator = new Emulator();
        emulator.start(scanner);
    }
}
