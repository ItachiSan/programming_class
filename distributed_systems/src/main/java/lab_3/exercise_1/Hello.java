package lab_3.exercise_1;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
//import XMLRootNode

//@XMLRootNode
@Path("/hello")
public class Hello {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, world\n";
    }

    @Path("{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloToSomebody(@PathParam("name") String name) {
        return "Hello, " + name + "\n";
    }

    @Path("{name1}/{name2}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String somebodySaysHelloToSomebodyElse(@PathParam("name1") String name1, @PathParam("name2") String name2) {
        return name1 + " says hello to " + name2 + "\n";
    }
}