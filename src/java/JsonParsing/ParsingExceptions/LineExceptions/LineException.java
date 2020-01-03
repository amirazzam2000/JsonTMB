package JsonParsing.ParsingExceptions.LineExceptions;

import DataModel.TransportationData.RouteData.Route;

/**
 *
 * Class: java.JsonParsing.ParsingExceptions.LineExceptions.LineException
 *
 * <p>Signals that an attempt to get a Bus Lines information at a specific
 * stop has failed, because the Stop ID was invalid
 * <p>
 * This Exception will be thrown by
 * {@link JsonParsing.Transportation.JsonLineReader}, if it receives a Json
 * String with an error code.
 *
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see DataModel.TransportationData.StopData.Line
 * @see JsonParsing.Transportation.JsonLineReader
 */
public class LineException extends Exception{
    String message;

    /**
     * Constructs a <code>LineException</code> with the
     * specified detail message. The string <code>message</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param message  the detail message.
     */
    public LineException(String message) {
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
