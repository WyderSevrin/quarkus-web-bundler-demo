package application.ressources;


import application.data.Contact;
import application.services.CrmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("")
public class API {

    @Inject
    CrmService crmservice;

    @GET
    @Path("/contacts")
    public List<Contact> list(@QueryParam("name") String filter) {
        return crmservice.findAllContacts(filter);
    }




}
