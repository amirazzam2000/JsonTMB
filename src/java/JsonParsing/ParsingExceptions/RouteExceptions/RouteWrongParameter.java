package JsonParsing.ParsingExceptions.RouteExceptions;

public class RouteWrongParameter extends RouteExceptions {
    String message;
    public RouteWrongParameter(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
