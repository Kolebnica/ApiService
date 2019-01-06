package api.resources.UserServiceResources;

import beans.crud.UserBean;
import beans.external.UserServiceBean;
import com.kumuluz.ee.logs.cdi.Log;
import entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("users")
@ApplicationScoped
@Tags(value = @Tag(name = "users"))
@Log
public class UserResource {

    @Inject
    UserServiceBean userServiceBean;

    @GET
    public Response getUsers() {
        return userServiceBean.getUsers();
    }


    @GET
    @Path("{userId}")
    public Response getUserById(@PathParam("userId") int userId) {
        return userServiceBean.getUserById(userId);
    }
}
