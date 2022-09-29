package ex;

public class Example11 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("Помилка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }
}