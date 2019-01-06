package api.resources.UserServiceResources;

import beans.external.UserServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("metadata")
@ApplicationScoped
@Tags(value = @Tag(name = "metadata"))
@Log
public class MetadataResource {

    @Inject
    private UserServiceBean userServiceBean;

    @GET
    public Response getMetadata() {
        return Response.ok(userServiceBean.getMetadata()).build();
    }
}