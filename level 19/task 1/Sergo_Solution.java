/* TableAdapter
Измени класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку «[username] : tablename«.
Пример, «[Amigo] : DashboardTable«.
Требования:
+1. Класс Solution должен содержать public static интерфейс ATable.
+2. Класс Solution должен содержать public static интерфейс BTable.
+3. Класс Solution должен содержать public static класс TableAdapter.
4. Класс TableAdapter должен реализовывать интерфейс BTable.
5. Класс TableAdapter должен содержать приватное поле aTable типа ATable.
6. Класс TableAdapter должен содержать конструктор с параметром ATable.
7. Класс TableAdapter должен переопределять метод getHeaderText согласно заданию.
*/

    public class Sergo_Solution {
        public static void main(String[] args) {
            //это пример вывода
            ATable aTable = new ATable() {
                @Override
                public String getCurrentUserName() {
                    return "Amigo";
                }

                @Override
                public String getTableName() {
                    return "DashboardTable";
                }
            };

            BTable table = new TableAdapter(aTable);
            System.out.println(table.getHeaderText());
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


        public static class TableAdapter implements BTable{
        private ATable aTable;
        TableAdapter (ATable aTable){
            this.aTable = aTable;
        }

        public String getHeaderText(){
            return ("[" + this.aTable.getCurrentUserName() +"] : "+ this.aTable.getTableName());
        }
}

        public interface ATable {
            String getCurrentUserName();
            String getTableName();
        }

        public interface BTable {
            String getHeaderText();
        }
    }
