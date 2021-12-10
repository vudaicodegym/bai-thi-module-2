package validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    public String inputAndCheckPhoneNumber(){
        String phoneNumber;
        phoneNumber = scanner.nextLine();
        Pattern m = Pattern.compile("^0[0-9]{9}$");
        if (m.matcher(phoneNumber).find()){
            return phoneNumber;
        }else
        {
            System.err.println("********************************************************");
            System.err.println("nhập lại số điện thoại với 10 số và bắt đầu = 0");
            System.err.println("********************************************************");
            return inputAndCheckPhoneNumber();}
    }
    public int inputAndCheckChoice(){
        System.out.println("nhập lựa chọn: ");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            return choice;
        }catch (Exception e){
            System.err.println("********************************************************");
            System.err.println("vui lòng nhập số nguyên dương tương ứng lựa chon trong menu");
            System.err.println("********************************************************");
            return inputAndCheckChoice();
        }
    }
}
