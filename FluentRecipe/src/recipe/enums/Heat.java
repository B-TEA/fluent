package recipe.enums;

public enum Heat {
    HIGH ("high heat"),
    MEDIUM ("medium heat"),
    LOW ("low heat");

    private String val;

    Heat(String s) {
        this.val = s;
    }

    public String toVal () {
        return this.val;
    }
}
