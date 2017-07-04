package com.mastercard;

import com.mastercard.model.User;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("getDate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("format") String format) {
        System.out.println(format);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return Response.ok("{'now': '" + sdf.format(new Date()) +"' }").build();
    }

    @Path("getTasks/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonPathParam(@PathParam("userId") String userId) {
        System.out.println("{\"userId\": '" +userId +"', 'task' : \"No task available\" }");
        System.out.println("{\"userId\": '" +userId +"', 'task' : \"No task available\" }2");
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return Response.ok("{\"userId\": " +userId +", \"task\" : \"No task available\" }").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response saveUser(@FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email) {
        User user = new User(1l, username, name, email);
        System.out.println(user.toString());

        return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUserJSon(User user) {
        System.out.println(user.toString());
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @PUT
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putUserJSonPut(@PathParam("userId") String userId, User user) {
        System.out.println(user.toString());
        user.setId(Long.parseLong(userId));
        return Response.ok(user).build();
    }

    @DELETE
    @Path("{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        System.out.println("User id: " +  userId + " deleted!");
        return Response.accepted().build();
    }



    // Receiving Arrays as parameter
    @POST
    @Path("saveArray")
    public Response saveArray(ArrayList<User> users) {
        for (User user: users) {
            System.out.println(user.toString());
        }
        return Response.ok().build();
    }
}
