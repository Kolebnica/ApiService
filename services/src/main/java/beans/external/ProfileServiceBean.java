package beans.external;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.eclipse.microprofile.metrics.annotation.Counted;
import pojo.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class ProfileServiceBean {

    @Inject
    @DiscoverService(value = "profileservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> profileServiceWebTarget;

    @Counted(name = "callProfileService", monotonic = true)
    public Response getProfiles() {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            return t.path("api/profiles").request().get();
        }
        return null;
    }

    @Counted(name = "callProfileService", monotonic = true)
    public Response getProfileById(int profileId) {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            return t.path("api/profiles/" + profileId).request().get();
        }
        return null;
    }

    @Counted(name = "callProfileService", monotonic = true)
    public Response createProfile(int profileId) {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            return t.path("api/profiles/" + profileId).request().post(null);
        }
        return null;
    }

    @Counted(name = "callProfileService", monotonic = true)
    public Response updateProfile(int profileId, Profile profile) {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            return t.path("api/profiles/" + profileId).request().put(Entity.json(profile));
        }
        return null;
    }

    @Counted(name = "callProfileService", monotonic = true)
    public Response deleteProfile(int profileId) {
        if(profileServiceWebTarget.isPresent()) {
            WebTarget t = profileServiceWebTarget.get();

            return t.path("api/profiles/" + profileId).request().delete();
        }
        return null;
    }
}
