package test.EPAM_Task1;

/*
Классы Точка и Плоскость (по 3м точкам)
        Создать методы и тесты -
        вычисления угла м\у плоскостью и любой из координатных плоскостей,
        составляют ли 3 точки плоскость
        перпендикулярна ли плоскость любой из осей координат
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        DataRnA d = new DataRnA();

        d.dataReader();
        d.writeDataDown();
        ArrayList<Surface> surfs = d.surfacesListCreator();
        for (Surface s: surfs){
            System.out.println(s.toString());
        }
    }
}
