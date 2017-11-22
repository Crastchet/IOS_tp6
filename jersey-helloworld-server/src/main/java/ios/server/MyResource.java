
package ios.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Path("/hello")
    @Produces("application/json")
    public Hello hello() {
        return new Hello("hello !");
    }
    
    @POST 
    @Path("/sayhello")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Hello sayHello(Hello hello) {
    	return new Hello("Hello " + hello.getString());
    }
}
