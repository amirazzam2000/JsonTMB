package JsonParsing.ParsingExceptions;

public class LineException extends Exception{
    String message;

    public LineException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
