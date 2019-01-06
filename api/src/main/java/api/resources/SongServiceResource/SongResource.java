package api.resources.SongServiceResource;

import beans.external.SongServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("song")
@ApplicationScoped
@Tags(value = @Tag(name = "song"))
@Log
public class SongResource {

    @Inject
    private SongServiceBean songServiceBean;

    @POST
    public Response uploadSong(@RequestBody Song song) {
        return songServiceBean.uploadSong(song);
    }


    @GET
    @Path("{id}")
    public Response getSong(@PathParam("id") int songId){
        return songServiceBean.getSong(songId);
    }


    @GET
    @Path("/list")
    public Response getListOfSongs(){
        return songServiceBean.getListOfSongs();
    }


    @GET
    @Path("artist/{artistId}")
    public Response getSongsByArtist(@PathParam("artistId") int artistId) {
        return songServiceBean.getSongsByArtist(artistId);
    }


    @GET
    @Path("album/{albumId}")
    public Response getSongsByAlbum(@PathParam("albumId") int albumId) {
        return songServiceBean.getSongsByAlbum(albumId);
    }


    @GET
    @Path("user/{userId}")
    public Response getSongsByUser(@PathParam("userId") int userId) {
        return songServiceBean.getSongsByUser(userId);
    }


    @PUT
    @Path("{songId}")
    public Response updateAlbum(@PathParam("songId") int songId, Song song) {
        return songServiceBean.updateAlbum(songId, song);
    }

}
