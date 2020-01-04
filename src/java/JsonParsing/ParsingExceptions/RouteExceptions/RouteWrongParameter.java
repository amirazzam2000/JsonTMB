package JsonParsing.ParsingExceptions.RouteExceptions;

import DataModel.TransportationData.RouteData.Route;

/**
 *
 * Class: java.JsonParsing.ParsingExceptions.RouteExceptions.RouteOutOfReach
 *
 * <p>Signals that an attempt to get a route information has failed,because
 * one or more of the parameters sent to the TMB API was wrong
 * <p>
 * This Exception will be thrown by
 * {@link JsonParsing.Transportation.JsonRouteReader} if the Json String that
 * it received had the error filed noted with any other error code other than
 * the one used by {@link RouteOutOfReach}
 *
 * Additionally, it has one constructor that takes a message as a parameter
 * and builds the exception with that message. Moreover, it has a getter for
 * that message in order to be able to read it if needed.
 *
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see RouteOutOfReach
 * @see JsonParsing.Transportation.JsonRouteReader
 *
 */
public class RouteWrongParameter extends RouteExceptions {
    private String message;

    /**
     * Constructs a <code>RouteWrongParameter</code> with the
     * specified detail message. The string <code>message</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param message  the detail message.
     */
    public RouteWrongParameter(String message) {
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
