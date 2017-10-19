package att1.task1;

import javax.xml.bind.annotation.*;
import java.util.UUID;

@XmlRootElement(name = "Person")
@XmlAccessorType (XmlAccessType.FIELD)
public class Person {
    //@XmlAttribute
    private String id;
    //@XmlElement
    private String name;
    //@XmlElement
    private String num1;
    //@XmlElement
    private String num2;
    //@XmlElement
    private String num3;


    private String GenerateId() // генерация id
    {
        return UUID.randomUUID().toString().substring(0,5);
    }

    public String getName(){ return name; }
    public String getId(){return id;}
    public String getNum1(){return num1;}
    public String getNum2(){return num2;}
    public String getNum3(){return num3;}

    public Person(String name, String[] numbers)
    {
        id=GenerateId();
        this.name=name;
        switch (numbers.length) {
            case 3:
                num3 = numbers[2];
            case 2:
                num2 = numbers[1];
            case 1:
                num1 = numbers[0];
                break;
           // default:
               // System.out.println("Введите номера!!!!!!");
        }
    }
    public Person(){
        name="";
        num1= "";
        num2= "";
        num3= "";
    } // дефолтный конструктор

    public void Edit(String newName, String[] numbers) {
        this.name = newName;
        switch (numbers.length) {
            case 3:
                num3 = numbers[2];
            case 2:
                num2 = numbers[1];
            case 1:
                num1 = numbers[0];
                break;
        }
    }
}
