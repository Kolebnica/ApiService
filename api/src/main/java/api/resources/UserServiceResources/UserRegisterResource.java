package api.resources.UserServiceResources;

import beans.external.UserServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("register")
@ApplicationScoped
@Tags(value = @Tag(name = "users"))
@Log
public class UserRegisterResource {

    @Inject
    private UserServiceBean userServiceBean;

    @PUT
    public Response registerUser(@RequestBody User user) {
        return userServiceBean.registerUser(user);
    }
}
