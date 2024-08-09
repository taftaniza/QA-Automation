public class InvalidYearException extends Exception {
    public InvalidYearException() {
        super("Invalid year");

    }
    public InvalidYearException(String message) {
        super(message);
    }
}
