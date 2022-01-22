package recipe.enums;

public enum TimeUnit {
    MINUTE ( "minute");


    private String valInString;

    TimeUnit ( String valInString) {
        this.valInString = valInString;
    }

    public String toVal (int time) {

        if (time > 1) {
            return valInString + "s";
        } else {
            return valInString;
        }
    }
}
