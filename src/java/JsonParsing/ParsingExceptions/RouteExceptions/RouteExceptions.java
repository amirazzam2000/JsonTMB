package JsonParsing.ParsingExceptions.RouteExceptions;

import DataModel.TransportationData.RouteData.Route;

import java.security.PrivateKey;

/**
 *
 * Class: java.JsonParsing.ParsingExceptions.RouteExceptions.RouteExceptions
 *
 * <p>Signals that an attempt to get a route information has failed,
 * <p>
 * This Exception will be thrown by
 * {@link JsonParsing.Transportation.JsonRouteReader}, if it receives a mal
 * formed Json String or if the Json String had it's error field not null
 *
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Route
 * @see JsonParsing.Transportation.JsonRouteReader
 */
public class RouteExceptions extends Exception {
    private String message;
    /**
     * Constructs a <code>RouteExceptions</code> with the
     * specified detail message. The string <code>message</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param message  the detail message.
     */
    public RouteExceptions(String message){
        super(message);
        this.message = message;
    }


    /**
     * Returns the detail message string of this throwable.
     *
     * @return  the detail message string of this {@code Throwable} instance
     *          (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return message;
    }

}
