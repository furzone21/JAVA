package teams;
import java.util.Scanner;

class Komanda {
    String name, city;     //назва команди, міста
    int place, count_win;   //місце в лізі, кількість перемог

}
public class RecordTeams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");

        //Введення інформації про команди
        System.out.print("Введіть кількість команд => ");
        int n = sc.nextInt(); //кількість команд
        Komanda team[] = new Komanda[n];
        System.out.println("Введіть інформацію про команди: ");

        for (int i=0; i<team.length;i++){
            sc.nextLine(); //очищення буфера
            team[i] = new Komanda();
            System.out.print("Назва " + (i+1) + "-ї команди - ");
            team[i].name=sc.nextLine();
            System.out.print("Назва міста " + (i+1) + "-ї команди - ");
            team[i].city=sc.nextLine();
            System.out.print("Місце в лізі " + (i+1) + "-ї команди - ");
            team[i].place= sc.nextInt();
            System.out.print("Кількість перемог " + (i+1) + "-ї команди - ");
            team[i].count_win= sc.nextInt();
        }

        //Виведення отриманої інформації
        System.out.println("\nХарактеристика команд:");
        for (int i=0; i< team.length;i++){
            System.out.println(""+team[i].name+"\t"+team[i].city+"\t\t"+team[i].place+" місце\t\t\t"+team[i].count_win+" перемог;");
        }

        //Команда з найбільшою кількістю перемог
        int nommax=0; //номер елемента для команди з найбільшою кількістю перемог (початкове значення)
        double max=team[nommax].count_win; //найбільша к-сть перемог (початкове значення)
        for (int i=0;i< team.length;i++){
            max = team[i].count_win;
            nommax=i;
        }
        System.out.println("\nКоманда з найбільшою кількістю перемог: ");
        System.out.println(""+team[nommax].name+"\t"+team[nommax].city+"\t\t"+team[nommax].place+" місце\t\t\t"+team[nommax].count_win+" перемог;");

        //К-сть перемог більше середньої
        double s = 0;       //сумарна к-сть перемог
        for (int i=0;i< team.length;i++)
            s+=team[i].count_win;
        double sr = s/team.length;      //середня к-сть перемог
        System.out.println("\nСередня кількість перемог = " + sr);
        System.out.println("\nКоманди, з кількістю перемог більше середньої");
        for (int i=0;i< team.length;i++) {
            if (team[i].count_win>sr)
                System.out.println(""+team[i].name+"\t"+team[i].city+"\t\t"+team[i].place+" місце\t\t\t"+team[i].count_win+" перемог;");
        }

        //Сортування команд зі спадання місць у лізі
        for (int i=0;i< team.length-1;i++)
            for (int j=0;j< team.length-1-i;j++)
                if (team[j].place<team[j+1].place) {
                    Komanda rab = team[j];
                    team [j]=team [j+1];
                    team [j+1] = rab;
                }
        System.out.println("\nВідсортований список зі спадання місць у лізі: ");
        for (int i=0;i< team.length;i++) {
            System.out.println(""+team[i].name+"\t"+team[i].city+"\t\t"+team[i].place+" місце\t\t\t"+team[i].count_win+" перемог;");
        }

        //Пошук за назвою команди
        sc.nextLine();      //очищення буфера

        System.out.print("\nВведіть назву шуканої команди - ");
        String name = sc.nextLine();
        int nom=-1;         //-1 - команда з шуканою назвою відсутня

        for (int i=0;i< team.length;i++)
            if (name.equalsIgnoreCase(team[i].name))
                nom=i;
        if (nom!=-1) {
            System.out.println("Така команда є у списку. Це "+team[nom].name+"\t"+team[nom].city+"\t\t"+team[nom].place+" місце\t\t\t"+team[nom].count_win+" перемог;");
        }
        else
            System.out.println("Такої команди немає у списку");
    }
}
