package JsonParsing.ParsingExceptions.RouteExceptions;

public class RouteExceptions extends Exception {
    String message;
    public RouteExceptions(String message){
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
