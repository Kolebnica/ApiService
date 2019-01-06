package api.resources.LibraryServiceResources;

import beans.external.LibraryServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.Album;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("albums")
@ApplicationScoped
@Tags(value = @Tag(name = "albums"))
@Log
public class AlbumResource {

    @Inject
    private LibraryServiceBean libraryServiceBean;

    @GET
    public Response getAlbums() {
        return libraryServiceBean.getAlbums();
    }


    @GET
    @Path("{albumId}")
    public Response getAlbumById(@PathParam("albumId") int albumId) {
        return libraryServiceBean.getAlbumById(albumId);
    }


    @GET
    @Path("artist/{artistId}")
    public Response getAlbumsByArtist(@PathParam("artistId") int artistId) {
        return libraryServiceBean.getAlbumsByArtist(artistId);
    }


    @GET
    @Path("user/{userId}")
    public Response getAlbumsByUser(@PathParam("userId") int userId) {
        return libraryServiceBean.getAlbumsByUser(userId);
    }


    @POST
    public Response createAlbum(Album album) {
        return libraryServiceBean.createAlbum(album);
    }


    @PUT
    @Path("{albumId}")
    public Response updateAlbum(@PathParam("albumId") int albumId, Album album) {
        return libraryServiceBean.updateAlbum(albumId, album);
    }


    @DELETE
    @Path("{albumId}")
    public Response deleteAlbum(@PathParam("albumId") int albumId) {
        return libraryServiceBean.deleteAlbum(albumId);
    }
}
