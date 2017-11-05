/* Адаптация нескольких интерфейсов
+Адаптируй IncomeData к Customer и Contact.
+Классом-адаптером является IncomeDataAdapter.
+Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
+UA Ukraine
+RU Russia
+CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
Требования:
+1. Класс Solution должен содержать public static поле countries типа Map.
+2. В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
+3. Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
+4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
+5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки
в виде комментариев в интерфейсах.
*/

import java.util.HashMap;
import java.util.Map;

public class goForIt {
    public static Map<String, String> countries = new HashMap<String, String>();

    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        IncomeData data;
        IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        public String getPhoneNumber(){     // Needs to be adjusted futher to get +38(050)123-45-67 result...
            return "+" + String.valueOf(this.data.getCountryPhoneCode()) + "0" + String.valueOf(this.data.getPhoneNumber());
        }
        
        public String getName (){
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }
        
        public String getCompanyName(){
            return this.data.getCompany();
        }
        
        public String getCountryName(){     // Needs to be adjusted futher to get data from countries MAP by key UA, RU or CA...
            return this.data.getCountryCode();
        }
    }
/*
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки
в виде комментариев в интерфейсах
 */

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
