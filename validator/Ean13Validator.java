package validator;


public class Ean13Validator extends Ean13ValidatorModel {
    public Ean13Validator(String eanCode) {
        super(eanCode);
    }

    @Override
    protected boolean validator(String eanCode) {
        if (!eanCode.matches("^[0-9]{13}$")) {
            return false;
        }
        // Validate Right to left
        int[] number = eanCode.chars().map(Character::getNumericValue).toArray();
        int sumPairs = number[12] + number[10] + number[8] + number[6] + number[4] + number[2];
        int oddPairs = number[11] + number[9] + number[7] + number[5] + number[3] + number[1];
        int result = (sumPairs * 3) + oddPairs;
        int verifyingDigit = 10 - result % 10;

        //Validate Left to right
        int sumPairsTwo = number[1] + number[3] + number[5] + number[7] + number[9] + number[11];
        int oddPairsTwo = number[0] + number[2] + number[4] + number[6] + number[8] + number[10];
        int resultTwo = (sumPairsTwo * 3) + oddPairsTwo;
        int verifyingDigitTwo = 10 - resultTwo % 10;

        // if verifyingDigit equals number[0] and verifyingDigitTwo equals number[12] return true
        return verifyingDigit == number[0] || verifyingDigitTwo == number[12];
    }
}
