package test;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] — String, [значение] — double. [имя] и [значение] разделены пробелом.
Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.
Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1
Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import static java.lang.Double.parseDouble;

public class Solution {
    public static void main(String[] args){
        try {
            FileReader fileReader = new FileReader("C:\\Users\\WorkBase\\IdeaProjects\\test\\src\\test\\test");
            FileWriter fileWriter = new FileWriter("C:\\Users\\WorkBase\\IdeaProjects\\test\\src\\test\\output");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            HashMap<String, Double> map = new HashMap();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (map.containsKey(parts[0]))
                    map.put(parts[0], (map.get(parts[0]) + parseDouble(parts[1])));
                    else  map.put(parts[0], parseDouble(parts[1]));
            }
            for (String name : map.keySet()){
                String key = name.toString();
                String value = map.get(name).toString();
                fileWriter.write(key + " " + value + "\n");
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (Exception e){e.printStackTrace();}
    }
}
