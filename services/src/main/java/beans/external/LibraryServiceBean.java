package beans.external;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import pojo.Album;
import pojo.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped()
public class LibraryServiceBean {

    @Inject
    @DiscoverService(value = "libraryservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> libraryServiceWebTarget;

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getAlbums() {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums").request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getAlbumById(int albumId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums/" + albumId).request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getAlbumsByArtist(int artistId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums/artist/" + artistId).request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getAlbumsByUser(int userId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums/user/" + userId).request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response createAlbum(Album album) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums").request().post(Entity.json(album));
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response updateAlbum(int albumId, Album album) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums/"+albumId).request().put(Entity.json(album));
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response deleteAlbum(int albumId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/albums/"+albumId).request().delete();
        }
        return null;
    }


    @Counted(name = "callLibraryService", monotonic = true)
    public Response getArtists() {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists").request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getArtistById(int artistId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists/"+artistId).request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response getArtistsByUser(int userId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists/user/"+userId).request().get();
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response createArtist(Artist artist) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists").request().post(Entity.json(artist));
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response updateArtist(int artistId, Artist artist) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists/"+artistId).request().put(Entity.json(artist));
        }
        return null;
    }

    @Counted(name = "callLibraryService", monotonic = true)
    public Response deleteArtist(int artistId) {
        if(libraryServiceWebTarget.isPresent()) {
            WebTarget t = libraryServiceWebTarget.get();

            return t.path("api/artists/"+artistId).request().delete();
        }
        return null;
    }
}
