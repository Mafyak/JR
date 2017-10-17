package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

/* Проход по дереву файлов

1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя существующего файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Пройдись по всем файлам в директории, которая приходит первым параметром в main, и всех ее поддиректориях. Файлы с размером более 50 байт нужно удалить используя метод FileUtils.deleteFile.
4. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
5. Поток для записи в файл нужно закрыть.
*/


public class Solution {
    private static List<File> list;
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        String newName = "/allFilesContent.txt";
        File fileResult = new File(resultFileAbsolutePath);
        if (path.equals(resultFileAbsolutePath)) {
            return;
        }
        List<File> allFiles = getAllFilesByPath(path);
        if (allFiles.contains(fileResult)) {
            allFiles.remove(fileResult);
        }
        ifMore50bytesDeleteFilesOr(allFiles);
        if (allFiles.size() != 0) {
            sortList(allFiles);
            fileResult = rename(fileResult, newName);
            writeFilesToFileWithSeparator(allFiles, fileResult);
        }
        deleteEmptyFolders(path);
    }
    private static void deleteEmptyFolders(String path) {
        if (path == null) {
            return;
        }
        File file = new File(path);
        if (file.isDirectory()) {
            if (file.listFiles().length == 0) {
                file.delete();
            } else {
                for (File file1 : file.listFiles()) {
                    deleteEmptyFolders(file1.getAbsolutePath());
                }
            }
        }
    }
    private static void writeFilesToFileWithSeparator(List<File> allFiles, File fileResult) {
        for (File file : allFiles) {
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileResult, true))
            ) {
                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static File rename(File fileResult, String newName) {
        Path sourcePath = Paths.get(fileResult.getAbsolutePath());
        Path destinationPath = Paths.get(fileResult.getParentFile() + newName);
        try {
            return Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING).toFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void sortList(List<File> allFiles) {
        Collections.sort(allFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    private static void ifMore50bytesDeleteFilesOr(List<File> allFiles) {
        Iterator<File> iterator = allFiles.iterator();
        while (iterator.hasNext()) {
            File next = iterator.next();
            if (next.length() > 50 && !next.isDirectory()) {
                next.delete();
                iterator.remove();
            }
        }
    }
    private static List<File> getAllFilesByPath(String path) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File(path);
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                getAllFilesByPath(file1.getAbsolutePath());
            }
        } else list.add(file);
        return list;
    }
}
