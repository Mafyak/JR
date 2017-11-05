import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
+Классом-адаптером является PersonScannerAdapter.
+В классе адаптере создать приватное финальное поле Scanner fileScanner.
+Поле инициализировать в конструкторе с одним аргументом типа Scanner.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957
В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.
Требования:
+1. PersonScanner должен быть интерфейсом.
+2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
+3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
+4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
+5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же
методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Sergo_Solution {

    public static void main(String[] args) throws IOException {
        PersonScannerAdapter.read();
    }


    public static class PersonScannerAdapter implements PersonScanner{

        final Scanner fileScanner;
        public PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public static Person read() throws IOException{
            Scanner s;
            String lastName= null, firstName= null, middleName= null, bDate = null;
            String data[];
            data = new String[6];
            Person tester=null;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {

                //BufferedReade new BufferedReader(new InputStreamReader(new FileInputStream("DirectionResponse.xml"), "UTF-8"));
                s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\WorkBase\\IdeaProjects\\test\\src\\test.txt"), "UTF-8")));
                for (int i=0; i<6; i++)
                {
                    data[i] = s.next();
                }
                String sDate = data[3] + "/"  + data [4] + "/" + data[5];
                Date date = df.parse(sDate);
                tester = new Person(data[1], data[2], data[0], date);
                s.close();
                System.out.println(tester);
                }
            catch (ParseException e) {
                e.printStackTrace();
            }
            return tester;
        }
        public void close() throws IOException{
            this.fileScanner.close();
        }
    }
}


/*
String employee = "Smith,Katie,3014,,8.25,6.5,,,10.75,8.5";
String delims = "[,]";
String[] tokens = employee.split(delims);


String startDateString = "06/27/2007";
DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
Date startDate;
try {
    startDate = df.parse(startDateString);
    String newDateString = df.format(startDate);
    System.out.println(newDateString);
} catch (ParseException e) {
    e.printStackTrace();
}
 */
