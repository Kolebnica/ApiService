package api.resources.ProfileServiceResources;

import beans.external.ProfileServiceBean;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import pojo.Profile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("profiles")
@ApplicationScoped
@Tags(value = @Tag(name = "profiles"))
public class ProfileServiceResource {

    @Inject
    private ProfileServiceBean profileServiceBean;

    @GET
    public Response getProfiles() {
        return profileServiceBean.getProfiles();
    }

    @GET
    @Path("{profileId}")
    public Response getProfileById(@PathParam("profileId") int profileId) {
        return profileServiceBean.getProfileById(profileId);
    }


    @POST
    @Path("{profileId}")
    public Response createProfile(@PathParam("profileId") int profileId) {
        return profileServiceBean.createProfile(profileId);
    }


    @PUT
    @Path("{profileId}")
    public Response updateProfile(@PathParam("profileId") int profileId, Profile profile) {
        return profileServiceBean.updateProfile(profileId, profile);
    }


    @DELETE
    @Path("{profileId}")
    public Response deleteProfile(@PathParam("profileId") int profileId) {
        return profileServiceBean.deleteProfile(profileId);
    }

}