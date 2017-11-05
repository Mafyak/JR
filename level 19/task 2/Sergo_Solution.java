/* Адаптер
Используй класс goForIt, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
Требования:
+1. AmigoStringWriter должен быть интерфейсом.
+2. Класс goForIt должен реализовывать интерфейс AmigoStringWriter.
+3. Класс goForIt должен содержать приватное поле fileOutputStream типа FileOutputStream.
+4. Класс goForIt должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса goForIt должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса goForIt должен делегировать полномочие такому же методу fileOutputStream.
7. Метод close() класса goForIt должен делегировать полномочие такому же методу fileOutputStream.
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class Sergo_Solution implements AmigoStringWriter{

    public static void main(String[] args) {

    }
    /*
    class MyClass implements Interface2
{
 private Interface1 object;
 MyClass(Interface1 object)
 {
  this.object = object;
 }
 // тут располагаются методы Interface2,
 // которые вызывают методы Interface1
}
     */
    FileOutputStream fileOutputStream;
    goForIt(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    public void flush() throws IOException{
        this.fileOutputStream.flush();
    }
    public void writeString(String s) throws IOException{
        this.fileOutputStream.write(Integer.parseInt(s));
    }
    public void close() throws IOException{
        this.fileOutputStream.close();
    }

}
