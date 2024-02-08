package dk.harbojohnston;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Path;

@Path("/database")
public class DatabaseResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Hello, World!";
    }

    // TODO: Get Single book
    // TODO: Get all of a users books
    // TODO: Update status of users book
    // TODO: Add a book
}
