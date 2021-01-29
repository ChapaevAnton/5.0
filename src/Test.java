public class Test {

    public static void main(String[] args) {

        stringSum("456text54");
        stringSum("45654");

        //Вызов статических методов класса ClassInner
        ClassInner.getPrint();
        ClassInner.getPrintMain(args);

        // Создадим экземпляр класса ClassInner
        ClassInner classInner = new ClassInner();
        classInner.getPrintInner();

        // вызов метода main подкласса ClassInner с передачей параметров
        ClassInner.main(new String[]{"a", "b", "c"});

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
    }
    void getPrintInner(){
        System.out.println("Я экземпляр класса ClassInner");
    }

}
