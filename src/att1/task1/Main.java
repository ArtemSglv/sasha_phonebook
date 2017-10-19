package att1.task1;

import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) {

        Menu menu=new Menu();
        try {
            menu.ShowMenu();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
