package att1.task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Runtime.*;

public class Menu {
    private Phonebook book = new Phonebook();

    private void ClearScreen() {
        try {
            getRuntime().exec("cls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowMenu() throws JAXBException {
        int Case = 0;
        while (Case != -1) {

            System.out.println("1 - Добавить контакт");
            System.out.println("2 - Вывести справочник");
            System.out.println("3 - Удалить контакт");
            System.out.println("4 - Сохранить файл");
            System.out.println("5 - Открыть справоник");
            System.out.println("6 - Изменить контакт");
        /*cout << "5 - Записать в файл" << endl;
        cout << "6 - Прочитать из файла" << endl;
        cout << "7 - Закрыть программу" << endl;
        cout << "-----------------------" << endl;
        cout << "8 - ! Удалить весь список !" << endl;
        cout << "=======================" << endl;*/
            Scanner in = new Scanner(System.in);
            Case = in.nextInt();

            switch (Case) {
                case 1: {
                    //ClearScreen();
                    Person p;
                    System.out.println("Введите имя");
                    in.nextLine(); //WhY!!!!
                    String name = in.nextLine();
                    System.out.println("Введите номера телефонов через пробел");
                    String[] nums = in.nextLine().split(" ");
                    p = new Person(name, nums);
                    book.AddPerson(p);
                    break;
                }
                case 2: {
                    //ClearScreen();
                    book.ShowBook();
                    break;
                }
            case 3: {
                System.out.println("Введите ID");
                in.nextLine();
                book.DeletePerson(in.nextLine());

                break;
            }
            case 4: {
                book.Save();
                break;
            }
            case 5:
            {
              book.ReadFile();
              break;
            }
            case 6:
            {
                System.out.println("Введите ID");
                in.nextLine();
                String id = in.nextLine();
                System.out.println("Введите имя");
                //in.nextLine(); //WhY!!!!
                String name = in.nextLine();
                System.out.println("Введите номера телефонов через пробел");
                String[] nums = in.nextLine().split(" ");
                book.EditPerson(id,name,nums);


            }
            /*case 7: {Case = -1; return; }
            case 8:
            {
                system("cls");
                deleteAll(list);
                break;
            }

            default:
            {
                system("cls");
                SetConsoleTextAttribute(hand, FOREGROUND_RED | BACKGROUND_BLUE | BACKGROUND_GREEN | BACKGROUND_RED | BACKGROUND_INTENSITY);
                cout << "++++++++++++++++++++++" << endl;
                cout <<"+ "<<"Некорректный ввод!"<<" +" << endl;
                cout << "++++++++++++++++++++++" << endl;
                cout << ""<<endl;
                break;
            }*/
            }
        }
    }



}
