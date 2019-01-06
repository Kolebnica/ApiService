package api.resources.UserServiceResources;

import beans.external.UserServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("login")
@ApplicationScoped
@Tags(value = @Tag(name = "authentication"))
@Log
public class UserLoginResource {

    @Inject
    UserServiceBean userServiceBean;

    @POST
    public Response loginUser(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {

        return userServiceBean.loginUser(username, password);
    }
}