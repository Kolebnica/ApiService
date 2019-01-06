package beans.external;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import pojo.User;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.persistence.oxm.MediaType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class UserServiceBean {

    @Inject
    @DiscoverService(value = "userservice", version = "1.0.x", environment = "dev")
    private Optional<WebTarget> userServiceWebTarget;

    @Counted(name = "callUserService", monotonic = true)
    public String getMetadata() {
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

            return t.path("api/metadata").request().get(String.class);
        }
        return null;
    }

    @Counted(name = "callUserService", monotonic = true)
    public Response loginUser(String username, String password) {
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

            return t.path("api/login?username="+username+"&password="+password).request().post(null);
        }
        return null;
    }

    @Counted(name = "callUserService", monotonic = true)
    public Response registerUser(User user) {
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

            return t.path("api/register").request().put(Entity.json(user));
        }
        return null;
    }

    @Counted(name = "callUserService", monotonic = true)
    public Response getUsers() {
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

            return t.path("api/users").request().get();
        }
        return null;
    }

    @Counted(name = "callUserService", monotonic = true)
    public Response getUserById(int userId) {
        if(userServiceWebTarget.isPresent()) {
            WebTarget t = userServiceWebTarget.get();

            return t.path("api/users/"+userId).request().get();
        }
        return null;
    }
}
