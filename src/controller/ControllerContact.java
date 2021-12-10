package controller;

import module.Contact;
import validate.Validate;

import java.awt.datatransfer.Clipboard;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerContact {
    List<Contact> contactList = new ArrayList<>();
    Validate validate = new Validate();
    Scanner scanner = new Scanner(System.in);

    public void addContact() {
        Contact newContact = createContacts();
        contactList.add(newContact);
    }

    public Contact createContacts() {
        System.out.println("enter phone numbers ");
        String phoneNumber = validate.inputAndCheckPhoneNumber();
        System.out.println("enter your name");
        String name = scanner.nextLine();
        System.out.println("gender");
        String gender = scanner.nextLine();
        System.out.println("enter your address ");
        String address = scanner.nextLine();
        Contact newContact = new Contact(phoneNumber, name, address, gender);
        return newContact;
    }

    public void showContactsList() {
        if (contactList.size() > 0) {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i));
            }
        } else {
            System.out.println("danh bạ rỗng");
        }
    }

    public void update() {
        if (contactList.size() <= 0) {
            System.err.println("danh bạ tạm thời trống");
            return;
        }
        int index = findIndexByPhoneNumbers();
        System.out.println(contactList.get(index));
        System.out.println("enter new phone number");
        String newPhoneNumber = validate.inputAndCheckPhoneNumber();
        System.out.println("enter name");
        String newName = scanner.nextLine();
        System.out.println("enter address");
        String newAddress = scanner.nextLine();
        System.out.println("enter gender");
        String newGender = scanner.nextLine();
        contactList.get(index).setPhoneNumber(newPhoneNumber);
        contactList.get(index).setName(newName);
        contactList.get(index).setAddress(newAddress);
        contactList.get(index).setGender(newGender);
        return;

    }

        public int findIndexByPhoneNumbers(){
            System.out.println("nhập số điện thoại");
            String phoneNumber = validate.inputAndCheckPhoneNumber();
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getPhoneNumber().equals(phoneNumber)){
                    return i;
                }
            }
            return -1;
        }
        public void checkDuplicationContacts() {
        int index = findIndexByPhoneNumbers();
        if (index != -1) {
            System.out.println(contactList.get(index));
        }else  System.out.println("không tìm thấy danh bạ nào có số điện thoại này!");
        }
        public void delete(){
        int index = findIndexByPhoneNumbers();
        if (index > -1) {
            contactList.remove(index);
        }else System.out.println("không tìm thấy danh bạ này! ");
        }
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("E:\\bai thi thuc hanh module 2\\src\\readAndWriteFile\\contact.csv");
            for (Contact contacts: contactList) {
                fileWriter.write(contacts.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("ghi file thành công");
        } catch (IOException e) {
            System.err.println("ghi file thất bại");
            e.printStackTrace();
        }
    }
public void readFile() {
    try {
        FileReader fileReader = new FileReader("E:\\bai thi thuc hanh module 2\\src\\readAndWriteFile\\contact.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String contactsLine[] = line.split(",");
            String phone = contactsLine[0];
            String name = contactsLine[1];
            String gender = contactsLine[3];
            String address = contactsLine[2];
            Contact contacts = new Contact(phone, name, address, gender);
            contactList.add(contacts);
        }
        System.out.println("đọc file thành công");
    } catch (IOException e) {
        System.err.println("đọc file thất bại");
        e.printStackTrace();
    }
}
}


