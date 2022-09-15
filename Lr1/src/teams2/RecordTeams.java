package teams2;
import java.util.Scanner;

class Komanda {
    String name, city;     //назва команди, міста
    int place, count_win;   //місце в лізі, кількість перемог
}

public class RecordTeams {
    public static Komanda[] setTeamArr(int k) {
        //Введення массиву команд
        Scanner sc = new Scanner(System.in, "cp1251");
        Komanda team[] = new Komanda[k];

        System.out.println("Введіть інформацію про команди: ");
        for (int i = 0; i < team.length; i++) {
            team[i] = new Komanda();
            System.out.print("Назва " + (i + 1) + "-ї команди - ");
            team[i].name = sc.nextLine();
            System.out.print("Назва міста " + (i + 1) + "-ї команди - ");
            team[i].city = sc.nextLine();
            System.out.print("Місце в лізі " + (i + 1) + "-ї команди - ");
            team[i].place = sc.nextInt();
            System.out.print("Кількість перемог " + (i + 1) + "-ї команди - ");
            team[i].count_win = sc.nextInt();
            sc.nextLine();
        }
        return team;
    }

    public static void showArray(Komanda[] tm) {
        //Виведення масиву
        for (int i = 0; i < tm.length; i++) {
            System.out.println("" + tm[i].name + "\t" + tm[i].city + "\t\t" + tm[i].place + " місце\t\t\t" + tm[i].count_win + " перемог");
        }
    }

    public static void showTeam (Komanda tm) {
        //Інформація про одну команду
        System.out.println("" + tm.name + "\t" + tm.city + "\t\t" + tm.place + " місце\t\t\t" + tm.count_win + " перемог");
    }

    public static int Winner(Komanda[] tm) {
        //Команда з найбільшою кількістю перемог
        int nommax = 0; //номер елемента для команди з найбільшою кількістю перемог (початкове значення)
        double max = tm[nommax].count_win; //найбільша к-сть перемог (початкове значення)
        for (int i = 0; i < tm.length; i++)
        if (tm[i].count_win>max){
            max = tm[i].count_win;
            nommax = i;
        }
        return nommax;
    }

    public static double avgWin(Komanda[] tm) {
        //Середня к-сть перемог
        double s = 0;       //сумарна к-сть перемог
        for (int i = 0; i < tm.length; i++)
            s += tm[i].count_win;
        double sr = s / tm.length;      //середня к-сть перемог
        return sr;
    }

    public static Komanda[] WinnerMoreavg(Komanda tm[]) {
        //Команди з к-стю перемог більше середньої
        double sred = avgWin(tm);
        int kol = 0;        //к-сть команд
        for (int i = 0; i < tm.length; i++) {
            if (tm[i].count_win > sred)
                ++kol;
        }
        if (kol != 0) {
            Komanda[] winTeam = new Komanda[kol];
            int n = -1;
            for (int i = 0; i < tm.length; i++)
                if (tm[i].count_win > sred) {
                    winTeam[++n] = tm[i];
                }
            return winTeam;
        } else return null;
    }

    public static void sortPlace(Komanda[] tm) {
        //Сортування команд зі спадання місць у лізі
        for (int i = 0; i < tm.length - 1; i++)
            for (int j = 0; j < tm.length - 1 - i; j++)
                if (tm[j].place < tm[j + 1].place) {
                    Komanda rab = tm[j];
                    tm[j] = tm[j + 1];
                    tm[j + 1] = rab;
                }
    }



    public static Komanda findForName(Komanda tm[],String name) {
        //Пошук за назвою команди
        int n=-1;           //-1-країна з шуканою назвою відсутня
        for (int i=0;i< tm.length;i++)
            if (name.equalsIgnoreCase(tm[i].name))
                n=i;
        if (n!=-1) {
            return tm[n];
        } else return null;
    }

    public static void editTeam(String name, Komanda tm[], Scanner sc) {
        //редагування команди
        int nom = -1;
        for (int i = 0; i < tm.length; i++)
            if (name.equalsIgnoreCase(tm[i].name)) nom = i;
        if (nom != -1) {
            System.out.println("\nЯкщо хочете відредагувати команду напишіть: 'n' - назва команди, 'c' - місто команди, 'p' - місце в лізі команди, 'w' - кількість перемог.");
            System.out.println("=> ");
            String in = sc.nextLine();
            switch (in) {
                case "n": {
                    System.out.println("Введіть нову назву команди:");
                    String newvar = sc.nextLine();
                    tm[nom].name = newvar;
                    break;
                }
                case "c": {
                    System.out.println("Введіть нове місто команди:");
                    String newvar = sc.nextLine();
                    tm[nom].city = newvar;
                    break;
                }
                case "p": {
                    System.out.println("Введіть нове місце в лізі команди:");
                    int newvar = sc.nextInt();
                    tm[nom].place = newvar;
                    break;
                }
                case "w": {
                    System.out.println("Введіть нову кількість перемог команди:");
                    int newvar = sc.nextInt();
                    tm[nom].count_win = newvar;
                    break;
                }
                default: {
                    System.out.println("Ви ввели не правильні данні! Будь ласка спробуйте ще раз:");
                    editTeam(name, tm, sc);

                }
            }
            System.out.println("\nОновленні дані команди: " + "\n" + "" + tm[nom].name + "\t" + tm[nom].city + "\t" + tm[nom].place + " місце\t" + tm[nom].count_win + " перемог.");
        }
    }

    public static void main(String[] args) {
        //Головний клас з методами
        Scanner sc = new Scanner(System.in, "cp1251");

        System.out.print("Введіть кількість команд => ");
        int n = sc.nextInt();             //к-сть команд
        Komanda team[] = setTeamArr(n);   //Введення інформації про країни
        System.out.println("\nХарактеристика команд: ");
        showArray(team); // Виведення отриманої інформації

        //Команда з найбільшою кількістю перемог
        int nommax = Winner(team);
        System.out.println("\nКоманда з найбільшою кількістю перемог: ");
        showTeam(team[nommax]);

        //Середня к-сть перемог
        System.out.println("Середня кількість перемог - "+avgWin(team));

        //Команди з к-стю перемог більше середньої
        System.out.println("\nКоманди, з кількістю перемог більше середньої: ");
        Komanda[] winner = WinnerMoreavg(team);
        showArray(winner);

        //Сортування команд зі спадання місць у лізі
        sortPlace(team);
        System.out.println("\nВідсортований список за спадання місць у лізі: ");
        showArray(team);

        //Пошук за назвою та редагування команди
        System.out.println("\nВведіть назву шуканої команди - ");
        sc.nextLine();
        String sname = sc.nextLine();
        Komanda sfind = findForName(team, sname);
        if (sfind != null) {
            showTeam(sfind);
            editTeam(sname,team,sc);
        } else {
            System.out.println("Такої команди немає у списку!");
        }
    }
}
