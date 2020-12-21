package models;

import models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList  {
    private List<Person> PersonList = new ArrayList<>();
    public void Add(Person person){
        PersonList.add(person);
    }
    public Person GetAt(Integer index){
        return PersonList.get(index);
    }
    public void SetAt(Person person,Integer index) throws Exception {
        if(PersonList.size()-1 >= index)
            PersonList.set(index, person);
        else
            throw new Exception("Out of range");
    }

    public List<Person> getPersonList() {
        return PersonList;
    }

    public void setPersonList(List<Person> personList) {
        PersonList = personList;
    }

    public void removeAt(Integer index) throws Exception {
        if(PersonList.size()-1 >= index)
            PersonList.remove(index);
        else
            throw new Exception("Out of range");
    }
    public void remove(Person person) throws Exception {

        if( PersonList.contains(person)){
            PersonList.remove(person);
        }else{
            throw new Exception("Object not contains");
        }
    }
}
