package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.
Пример:
words содержит слова А, Б, В
Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
Требования:
1. Класс Solution должен содержать публичное статическое поле words типа List, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три слова в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
List<String> myList = new ArrayList<String>(Arrays.asList(s.split(",")));

      String sampleString = "Cat,Dog,Elephant";
      String[] items = sampleString.split(",");
      List<String> itemList = Arrays.asList(items);
      System.out.println(itemList);
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        int counter = 0;
        String link = "C:\\Users\\WorkBase\\IdeaProjects\\test\\src\\test\\test";

        try{
//            String link = reader.readLine();
            FileReader fileReader = new FileReader(link);
            BufferedReader fileBufReader = new BufferedReader(fileReader);
            while ((line = fileBufReader.readLine()) != null){
                String[] lineSep = line.split((" "));
                list = Arrays.asList(lineSep);
                for (String x: list){
                    for (String y: words){
                        if (x.equals(y))
                        counter++;
                    }
                }
                if (counter == 2){
                    for(String z: list){
                        result.add(z+ " ");
                    }
                    result.add("\n");
                    counter=0;
                }
                else counter=0;
            }
            fileBufReader.close();
        }
        catch(Exception e){e.printStackTrace();}
        for(String z: result){
            System.out.print(z);
        }
    }
}
