package JsonParsing.ParsingExceptions.RouteExceptions;

public class RouteOutOfReach extends RouteExceptions {
    String message;

    public RouteOutOfReach(String message) {
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
