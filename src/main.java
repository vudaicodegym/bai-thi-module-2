import controller.ControllerContact;
import validate.Validate;

public class main {
    public static void main(String[] args) {
        ControllerContact controllerContact = new ControllerContact();
        Validate validate = new Validate();
        int choice;
        do {
            System.out.println("1. show contacts list");
            System.out.println("2. create contact");
            System.out.println("3. updates");
            System.out.println("4. delete contact");
            System.out.println("5. search");
            System.out.println("6. write to file");
            System.out.println("7. read form file");
            System.out.println("8. quit");
            choice = validate.inputAndCheckChoice();
            switch (choice) {
                case 1:
                    controllerContact.showContactsList();
                    break;
                case 2:
                    controllerContact.addContact();
                    break;
                case 3: controllerContact.update();
                    break;
                case 4: controllerContact.delete();
                break;
                case 5: controllerContact.checkDuplicationContacts();
                break;
                case 6: controllerContact.writeToFile();
                    break;
                case 7: controllerContact.readFile();
                    break;
            }
        }while (choice != 8);
    }
}
