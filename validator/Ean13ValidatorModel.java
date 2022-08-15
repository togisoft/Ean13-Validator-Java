package validator;

public abstract class Ean13ValidatorModel {
    private final String eanCode;
    private final boolean validate;

    public Ean13ValidatorModel(String eanCode) {
        if (eanCode == null) throw new IllegalArgumentException("Please enter barcode number");
        this.eanCode = eanCode;
        this.validate = validator(eanCode);
    }
    

    public String getEanCode() {
        return eanCode;
    }

    public boolean isValidate() {
        return validate;
    }

    protected abstract boolean validator(String eanCode);
}
