package beans.external;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import pojo.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped()
public class SongServiceBean {

    @Inject
    @DiscoverService(value = "songservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> songServiceWebTarget;

    @Counted(name = "callSongService", monotonic = true)
    public Response uploadSong(Song song) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song").request().post(Entity.json(song));
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getSong(int songId) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/"+songId).request().get();
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getListOfSongs() {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/list").request().get();
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getSongsByArtist(int artistId) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/artist/"+artistId).request().get();
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getSongsByAlbum(int albumId) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/album/"+albumId).request().get();
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getSongsByUser(int userId) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/user/"+userId).request().get();
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response updateAlbum(int songId, Song song) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/song/"+songId).request().put(Entity.json(song));
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response uploadStream(byte[] stream) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/stream").request().post(Entity.entity(stream, MediaType.APPLICATION_OCTET_STREAM));
        }
        return null;
    }

    @Counted(name = "callSongService", monotonic = true)
    public Response getStream(int streamId) {
        if(songServiceWebTarget.isPresent()) {
            WebTarget t = songServiceWebTarget.get();

            return t.path("api/stream/"+streamId).request().get();
        }
        return null;
    }
}
