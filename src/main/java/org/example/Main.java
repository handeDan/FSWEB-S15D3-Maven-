package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //List-LinkedList:
        List<Employee> list = new LinkedList<>();
        list.add(new Employee(1, "Hande", "Dan"));
        list.add(new Employee(2, "Hakan", "Kr"));
        list.add(new Employee(3, "Nil", "Kr"));
        list.add(new Employee(4, "Hande", "Dan"));
        list.add(new Employee(4, "Ceylin", "Kr"));
    }

    //METHOD: tekrarlayan Employee objects'leri dönmek için:
    public static List<Employee> findDuplicates(List<Employee> list){
        Set<Employee> uniqueSet = new HashSet<>(); //unique olanları tutmak için..
        List<Employee> duplicates = new LinkedList<>(); //duplicate olanları tutmak için..

        for(Employee employee: list) {
            if (employee != null) {
                if (!uniqueSet.add(employee)) { //eğer uniqueSet'e Employee object eklenemezse, unique değil duplicate demektir..
                    duplicates.add(employee); //duplicates List'e ekliyoruz.
                }
            }
        }
        return duplicates;
    }

    //METHOD: tekrarlayan Employee objects'leri içinde unique olanları dönmek için:
    public static Map<Integer, Employee> findUniques(List<Employee> list){
        Map<Integer, Integer> countMap = new HashMap<>(); //id ve kaç kez tekrarlandığını tutuyor..
        Map<Integer, Employee> uniqueMap = new HashMap<>(); //unique olanları tutuyor..

        for(Employee employee: list) {
            if (employee != null) {
                if (countMap.containsKey(employee.getId())) { //eğer bu id daha önce eklendiyse..
                    countMap.put(employee.getId(), countMap.get(employee.getId()) + 1); //sayısını 1 arttırıyor.
                } else { //daha önce eklenmediyse..
                    countMap.put(employee.getId(), 1); //ekleniyor.
                }
                uniqueMap.put(employee.getId(), employee); //uniqueMap'e bu employee'yi ekliyoruz..
            }
        }
        return uniqueMap;
    }

    //METHOD: tekrarlayan Employee objects'leri kaldırmak ve unique olanları dönmek için:
    public static List<Employee> removeDuplicates(List<Employee> list){
        Map<Integer, Integer> countMap = new HashMap<>(); //id ve kaç kez tekrarlandığını tutuyor.

        for(Employee employee: list){
            if (employee != null) {
                if (countMap.containsKey(employee.getId())) { //eğer bu id daha önce eklendiyse..
                    countMap.put(employee.getId(), countMap.get(employee.getId()) + 1); //sayısını 1 arttırıyor.
                } else { //daha önce eklenmediyse..
                    countMap.put(employee.getId(), 1); //ekleniyor.
                }
            }
        }

        List<Employee> cleanedList = new LinkedList<>(); //tekrar etmeyen Employee nesneleri için..

        for(Employee employee: list){
            if(employee != null && countMap.get(employee.getId()) == 1){ //Eğer bu ID 1 kez görülüyorsa..
                cleanedList.add(employee); //cleanedList'e ekliyoruz.
            }
        }

        return cleanedList; //sadece unique Employee nesneleri döndürülür..
    }

}