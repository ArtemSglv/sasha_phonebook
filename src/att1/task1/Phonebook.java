package att1.task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.*;

@XmlRootElement(name = "phonebook")
@XmlAccessorType (XmlAccessType.FIELD)
public class Phonebook {
    @XmlElement
    List<Person> book;

    public Phonebook()
    {
        book=new ArrayList<Person>();
    }

    public void AddPerson(Person newPerson)
    {
        book.add(newPerson);
    }

    public void DeletePerson(String id)
    {
        for(int i=0;i<book.size();i++)
            if(book.get(i).getId().equals(id))
                book.remove(i);
    }

    public void EditPerson(String id, String newName, String[] newnumbers){
        for(int i=0;i<book.size();i++)
            if(book.get(i).getId().equals(id))
                book.get(i).Edit(newName, newnumbers);
    }
    
    public void ShowBook()
    {
        for (Person pr: book) {
            System.out.println(pr.getId()+"|"+pr.getName()+"|"+pr.getNum1()+"|"+pr.getNum2()+"|"+pr.getNum3());
        }
    }

    void Save() throws JAXBException{
        try {

            File file = new File("save_file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Phonebook.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(book, file);
           // jaxbMarshaller.marshal(book, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    void ReadFile()throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Phonebook.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Phonebook bk = (Phonebook) jaxbUnmarshaller.unmarshal( new File("save_file.xml") );
        book = bk.book;
    }

}
