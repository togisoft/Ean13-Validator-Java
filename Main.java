import java.util.Scanner;

import validator.Ean13Validator;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            try  {
                System.out.print("Enter Barcode Number: ");
                String eanCode = input.nextLine();
                Ean13Validator validator = new Ean13Validator(eanCode);

                if (validator.isValidate()) {
                    System.out.println("This is Ean13 Barcode : " + eanCode);
                } else {
                    System.out.println("Barcode is invalid : " + eanCode);
                }

                if(eanCode.equals("q")){
                    input.close();
                    System.out.println("Closed");
                    break;
                }
            }catch(Exception e){
                input.close();
            }
        }
    }
}