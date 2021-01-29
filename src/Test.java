import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    private static ArrayList<String> params;

    public static void main(String[] args) {

        stringSum("456text54");
        stringSum("45654");

        //параметр -p передан при запуске
        //можно внутри их передавать, добавляем к -p еще параметров
        args = setParameterMain("-x", args);
        args = setParameterMain("-y", args);
        args = setParameterMain("-z", args);
        getParameterMain();

        //Вызов статических методов класса ClassInner
        ClassInner.getPrint();
        ClassInner.getPrintMain(args);

        // Создадим экземпляр класса ClassInner
        ClassInner classInner = new ClassInner();
        classInner.getPrintInner();

        // вызов метода main подкласса ClassInner с передачей параметров
        ClassInner.main(new String[]{"a", "b", "c"});
        //еще раз но с параметрами от Test, передав в внутренний класс ClassInner
        ClassInner.main(args);

    }

    public static String[] setParameterMain(String str, String[] args) {
        params = new ArrayList<>(Arrays.asList(args));
        params.add(str);
        return params.toArray(new String[0]);
    }

    public static void getParameterMain() {
        System.out.println(params);

    }

    //просто метод который сумирует элементы числовой строки
    public static void stringSum(String str) {
        int sum = 0;
        try {
            int value = Integer.parseInt(str);
            while (value != 0) {
                sum += value % 10;
                value /= 10;
            }
        } catch (NumberFormatException err) {
            System.out.println(err.toString());
        }
        System.out.println(sum);
    }

}

//Внутренний класс
class ClassInner {

    public static void main(String[] args) {
        getPrint();
        getPrintMain(args);
    }

    static void getPrint() {
        System.out.println("Я внутренний класс ClassInner");
    }

    static void getPrintMain(String[] str) {
        System.out.print("Переданные параметры:");
        for (String parameter : str) {
            System.out.print(parameter);
        }
        System.out.println();
        //если параметр при запуске -p
        if (str[0].equals("-p")) System.out.println("Я main класса Test запустился с параметром -p ");

    }

    void getPrintInner() {
        System.out.println("Я экземпляр класса ClassInner");
    }

}
