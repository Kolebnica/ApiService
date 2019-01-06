package api.resources.LibraryServiceResources;

import beans.external.LibraryServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("artists")
@ApplicationScoped
@Tags(value = @Tag(name = "artists"))
@Log
public class ArtistResource {

    @Inject
    private LibraryServiceBean libraryServiceBean;

    @GET
    public Response getArtists() {
        return libraryServiceBean.getArtists();
    }


    @GET
    @Path("{artistId}")
    public Response getArtistById(@PathParam("artistId") int artistId) {
        return libraryServiceBean.getArtistById(artistId);
    }


    @GET
    @Path("user/{userId}")
    public Response getArtistsByUser(@PathParam("userId") int userId) {
        return libraryServiceBean.getArtistsByUser(userId);
    }


    @POST
    public Response createArtist(Artist artist) {
        return libraryServiceBean.createArtist(artist);
    }


    @PUT
    @Path("{artistId}")
    public Response updateArtist(@PathParam("artistId") int artistId, Artist artist) {
        return libraryServiceBean.updateArtist(artistId, artist);
    }


    @DELETE
    @Path("{artistId}")
    public Response deleteArtist(@PathParam("artistId") int artistId) {
        return libraryServiceBean.deleteArtist(artistId);
    }

}