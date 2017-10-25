package com.company;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8v 1
Результат:
12 14 1
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Main {
    public static boolean isNumeric(String str){
        try{
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)                {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fName1 = reader.readLine();
            String fName2 = reader.readLine();
//            fName1 = "E:/Java/JavaRush/lvl19/inp.txt";
//            fName2 = "E:/Java/JavaRush/lvl19/outp.txt";
            File ff = new File(fName1);
            FileReader fReader = new FileReader(fName1);
            FileWriter fWriter = new FileWriter(fName2);



            char [] a = new char[(int)ff.length()];
            fReader.read(a);
            String b = new String(a);
            String[] split = b.split(" ");
            System.out.println(split.length);
            for (int i =0; i<split.length; i++){
                if (isNumeric(split[i])){
                    fWriter.write(split[i] + " ");
                }
            }



            fReader.close();
            fWriter.close();
            reader.close();
        }
        catch (IOException e){
            System.out.println(e);
        }

    }
}
