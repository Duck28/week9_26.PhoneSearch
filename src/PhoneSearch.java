/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filip
 */
import java.util.*;

public class PhoneSearch {

    private Scanner reader;
    private Map<String, Person> list;

    public PhoneSearch(Scanner reader) {
        this.reader = reader;
        this.list = new HashMap<String, Person>();
    }

    public void start() {

        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n");

        while (true) {

            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("x")) {
                break;
            }
            if (command.equals("1")) {
                addNumber();
            }
            if (command.equals("2")) {
                try {
                    searchByName();
                } catch (Exception e) {
                    System.out.println("  not found\n");
                }
            }
            if (command.equals("3")) {
                searchByNumber();
            }
            if (command.equals("4")) {
                addAdress();
            }
            if (command.equals("5")) {
                try {
                    printPersonalInformation();
                } catch (Exception e) {
                    System.out.println("  not found\n");
                }
            }
            if (command.equals("6")) {
                remove();
            }
            if (command.equals("7")) {
                filteredSearch();
            }

        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        if (!list.containsKey(name)) {
            list.put(name, new Person(name, number));
        } else {
            list.get(name).addNumber(number);
        }
        System.out.println("");
    }

    public void searchByName() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        for (String string : this.list.keySet()) {
            this.list.get(name).printNumbers();
        }
        if (!list.containsKey(name)) {
            System.out.println(" not found");
        }
        System.out.println("");
    }

    public void searchByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();
        for (String string : this.list.keySet()) {
            if (this.list.get(string).checkNumber(number)) {
                System.out.println(" " + string + "\n");
            } else {
                System.out.println(" not found\n");
            }
        }
    }

    public void addAdress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();

        if (!list.containsKey(name)) {
            list.put(name, new Person(name));
        }

        System.out.print("street: ");
        this.list.get(name).setStreet(reader.nextLine());
        System.out.print("city: ");
        this.list.get(name).setCity(reader.nextLine());
        System.out.println("");
    }

    public void printPersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();

        if (!list.containsKey(name)) {
            System.out.println("  not found");
        }

        for (String string : this.list.keySet()) {
            if (string.equals(name)) {
                System.out.println(this.list.get(name).toString());
            }
        }
    }

    public void remove() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (list.containsKey(name)) {
            this.list.remove(name);
        }
        System.out.println("");
    }

    public void filteredSearch() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();

        List results = new ArrayList();
        for (String name : this.list.keySet()) {
            if (name.contains(keyword) || this.list.get(name).getAddress().contains(keyword)) {
                String found = " " + name + "\n" + this.list.get(name).toString();
                results.add(found);
            }
        }
        if (!results.isEmpty()) {
            Collections.sort(results);
            for (Object string : results) {
                System.out.println(string);
            }
        } else {
            System.out.println(" keyword not found");
            System.out.println("");
        }
    }

}
