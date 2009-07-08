package resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import services.UserService;

import model.CmoRoot;
import model.Message;
import model.User;
import model.UserList;

@Path(value = "/user")
public class UserResource {

    @GET
    @Produces("application/xml")
    @Path(value = "all")
    public synchronized CmoRoot getUserList() {
    	UserList users = UserService.getUserList();
    	CmoRoot c = new CmoRoot(200,"userList",users);
        return c;
    }
    
    @GET
    @Produces("application/xml")
    @Path(value = "{id}")
    public synchronized CmoRoot getUser(@PathParam("id") Long id) {
    	User user = UserService.getUser(id);
    	CmoRoot c = new CmoRoot(200,"user",user);
        return c;
    }

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Path(value = "add")
    public synchronized CmoRoot postUser(CmoRoot cmo) {
    	User user = (User)cmo.getData();
        System.out.println(user.getName());
    	UserService.addUser(user);
    	Message message = new Message();
    	message.setMessage("Add User Success");
    	CmoRoot c = new CmoRoot(200,"message",message);
    	return c;
    }
}
