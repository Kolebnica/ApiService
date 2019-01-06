package api.resources.SongServiceResource;


import beans.external.SongServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM})
@Produces(MediaType.APPLICATION_JSON)
@Path("stream")
@ApplicationScoped
@Tags(value = @Tag(name = "stream"))
@Log
public class StreamResource {

    @Inject
    private SongServiceBean songServiceBean;

    @POST
    public Response uploadStream(@RequestBody byte[] stream) {
        return songServiceBean.uploadStream(stream);
    }

    @GET
    @Path("{id}")
    public Response getStream(@PathParam("id") int streamId){
        return songServiceBean.getStream(streamId);
    }
}