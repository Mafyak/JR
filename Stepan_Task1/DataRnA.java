package test.EPAM_Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DataRnA {
    private ArrayList<String[]> list = new ArrayList<>();
    private ArrayList<Surface> surfaces = new ArrayList<>();

    public ArrayList dataReader (){

        String s = "C:\\Users\\WorkBase\\Dropbox\\HWS\\Parser\\src\\test\\EPAM_Task1\\Data";
        try (BufferedReader br = new BufferedReader(new FileReader(s))) {
                String line;
                String sep[];
                while ((line = br.readLine()) != null) {
                    sep = line.split(" ");
                    if (lineChecker(sep)){list.add(sep);}
                }
            br.close();
        } catch (Exception e){e.printStackTrace();}
        return list;
    }

    public boolean lineChecker(String[] x){

        String[] n = x;
        double d;

        if (!(n.length==9))
            return false;

        for(int y=0;y<n.length;y++){
            try{
            d = Double.parseDouble(n[y]);}
            catch (Exception e){
                System.out.println("Not a double Ex: " +n[y]);
                return false;
            }
        }
        return true;
    }

    public void writeDataDown(){

        String s = "C:\\Users\\WorkBase\\Dropbox\\HWS\\Parser\\src\\test\\EPAM_Task1\\Data2";
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(s))){
            for(String[] a: list){
                for (String x: a) {
                    wr.write(x + " ");
                }
                wr.write("\n");
            }
            wr.close();
        } catch (Exception e){e.printStackTrace();}
    }

    public ArrayList<Surface> surfacesListCreator(){

        ArrayList<Surface> surfList = new ArrayList<>();
        String s = "C:\\Users\\WorkBase\\Dropbox\\HWS\\Parser\\src\\test\\EPAM_Task1\\Data2";
        try (BufferedReader br = new BufferedReader(new FileReader(s))) {
            String line;
            String sep[];
            while ((line = br.readLine()) != null) {
                sep = line.split(" ");
                Dot a = new Dot(Double.parseDouble(sep[0]),Double.parseDouble(sep[1]),Double.parseDouble(sep[2]));
                Dot b = new Dot(Double.parseDouble(sep[3]),Double.parseDouble(sep[4]),Double.parseDouble(sep[5]));
                Dot c = new Dot(Double.parseDouble(sep[6]),Double.parseDouble(sep[7]),Double.parseDouble(sep[8]));
                Surface sur = new Surface(a, b, c);
                if (!(a.equals(b) || b.equals(c) || a.equals(c)))
                    surfList.add(sur);
                }
            br.close();
        } catch (Exception e){e.printStackTrace();}

        return surfList;
    }

}
