package recipe.enums;

public enum Unit {
    TABLESPOON ("tabelspoon"),
    TEASPOON ("teaspoon"),
    OUNCE ("ounce"),
    CUP ("cup"),
    POUND ("pound");

    private final String val;

    Unit (String s) {
        this.val = s;
    }

    public String toVal (double count) {
        if (count> 1.0) {
            return val + "s";
        } else {
            return  val;
        }
    }
}
