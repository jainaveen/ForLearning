package CoreJava;

public class Person implements Cloneable{

   String name;
   int age;
   Address address;

   Person(String name, int age, Address address) {
       this.name = name;
       this.age = age;
       this.address = address;
   }

   public Person shallowCopy() {
       try {
           return (Person) super.clone();
       } catch (CloneNotSupportedException e) {
           return null;
       }
   }

    public Person deepCopy() {
        try {
            Person copiedPerson = (Person) super.clone();
            copiedPerson.address =  new Address(this.address.name);
            return copiedPerson;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
