package JsonParsing.ParsingExceptions.RouteExceptions;

import DataModel.TransportationData.RouteData.Route;

/**
 *
 * Class: java.JsonParsing.ParsingExceptions.RouteExceptions.RouteOutOfReach
 *
 * <p>Signals that an attempt to get a route information has failed,because
 * the TMB API doesn't support the specified locations (origin / destination)
 * <p>
 * This Exception will be thrown by
 * {@link JsonParsing.Transportation.JsonRouteReader} if the Json String that
 * it received had the error filed noted with "No trip found. There may be no
 * transit service within the maximum specified distance or at the specified
 * time, or your start or end point might not be safely accessible."
 *
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see JsonParsing.Transportation.JsonRouteReader
 */
public class RouteOutOfReach extends RouteExceptions {
    private String message;

    /**
     * Constructs a <code>RouteOutOfReach</code> with the
     * specified detail message. The string <code>message</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param message  the detail message.
     */
    public RouteOutOfReach(String message) {
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
