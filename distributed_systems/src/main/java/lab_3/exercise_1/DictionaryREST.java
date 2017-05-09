package lab_3.exercise_1;

// Needed for managing responses.
import java.net.URI;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.HeaderParam;
// Needed for handling parametric calls.
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
// Used HTTP methods
import javax.ws.rs.POST;    // To create
import javax.ws.rs.DELETE;  // To remove
import javax.ws.rs.GET;     // To fetch
import javax.ws.rs.PUT;     // To update
// For marshaling/unmarshaling
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
// Classes for managing the media type.
//import org.eclipse.persistence.jaxb.MarshallerProperties;
//import org.eclipse.persistence.oxm.MediaType;
// Used to return a String.
import java.io.StringWriter;
// For logging
import java.util.logging.Logger;
// Useful, as always
import java.util.List;
import java.util.ArrayList;



@Path("/dictionary")
/**
 * The REST API for the dictionary.
 */
public class DictionaryREST {
    private final static Dictionary dictionary = new Dictionary();

    /**
     * Return the available methods to use the API.
     */
    @GET
    public Response usage() {
        /*
        CRUD:
        Create <--> POST
        Read   <--> GET
        Update <--> PUT
        Delete <--> DELETE
        */
        return Response.ok(
            "RESTful Dictionary API\n"
            + "Here follows how to access the API:\n"
            + "PUT    word content: "
            + "Store the word in the dictionary with the defined content.\n"
            + "GET    word        : "
            + "Return the content for the word\n"
            + "UPDATE word content: "
            + "Update the word in the dictionary with the defined content.\n"
            + "DELETE word        : "
            + "Remove the word and its content from the dictionary.\n"
            + "_                  : "
            + "A special method to have a marshaled version of the whole dictionary.\n"
            ).build();
    }


    /**
     * Add a word in the dictionary.
     * @param word The word to add.
     * @param description The related description.
     */
    @POST
    @Path("{word}/{description}")
    public Response addWord(
        @PathParam("word") String word,
        @PathParam("description") String description,
        @Context UriInfo uriInfo
        ) {
        /* Needed to get the called URL. */
        if (dictionary.getWords().containsKey(word))
            return Response.notModified("Already present word").build();
        else if (word.isEmpty() || description.isEmpty())
            return Response.notModified("Missing parameters").build();
        else {
            // Add the word to the dictionary.
            synchronized(dictionary) {
                dictionary.getWords().put(word, description);
            };
            // Fetch the called URI as a String
            String calledURI = uriInfo.getRequestUri().toString();
            // Create a URI without the description part
            URI availableURI = URI.create(
                calledURI.substring(0, calledURI.lastIndexOf("/"))
            );
            // Well, everything went well
            return Response.created(availableURI).build();
        }
            
    }


    /**
     * Fetch a word in the dictionary.
     * @param word The word to add.
     */
    @GET
    @Path("{word}")
    public Response getWord(@PathParam("word") String word) {
        if (dictionary.getWords().containsKey(word))
            return Response.ok(dictionary.getWords().get(word)).build();
        else
            return Response.noContent().build();
    }

    /**
     * Update a word in the dictionary.
     * @param word The word to update.
     * @param description The updated description.
     */
    @PUT
    @Path("{word}/{description}")
    public Response updateWord(
        @PathParam("word") String word,
        @PathParam("description") String description
        ) {
        if (dictionary.getWords().containsKey(word)) {
            synchronized(dictionary) {
                dictionary.getWords().put(word, description);
            }
            return Response
                .ok(word + " was modified successfully")
                .build();
        } else
            return Response
                .notModified(word + " is not present in the dictionary")
                .build();
    }

    /**
     * Remove a word in the dictionary.
     * @param word The word to remove.
     */
    @DELETE
    @Path("{word}")
    public Response deleteWord(@PathParam("word") String word) {
        if (dictionary.getWords().containsKey(word)) {
            synchronized(dictionary) {
                dictionary.getWords().remove(word);
            }
            return Response
                .ok()
                .build();
        } else
            return Response
                .notModified(word + " is not contained in the dictionary")
                .build();
    }


    /**
     * Allow to dump the dictionary in a serializable version.
     * First, it checks the header 'Content-Type' to see which version
     * we request of the dictionary. If it is available, we return
     * such a version; else, we fall back to JSON.
     */
    @GET
    @Path("_")
    public Response dumpDictionary() {
        /* Thanks, Jersey MOXy support...! */
        return Response.ok(dictionary).build();
    }
}