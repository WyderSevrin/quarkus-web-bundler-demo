package application.ressources;


import application.data.ContactDto;
import application.services.CrmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class API {

    @Inject
    CrmService crmservice;


    @GET
    @Path("/contacts")
    public Response list(@QueryParam("name") String filter) {
        List<ContactDto> contacts = crmservice.findAllContacts(filter).stream().map(ContactDto::new).toList();
        return Response.ok()
                .entity(contacts)
                .header("X-count", contacts.size())
                .build();
    }


}
