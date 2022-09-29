package ex;

public class Example13 {
    public  static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("розмір масиву="+1);
            int h = 10/1;
            args[l+1]="10";
        } catch (ArithmeticException e) {
            System.out.println("Ділення на нуль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Індекс не існує");
        }
    }
}
