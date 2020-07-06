package sk.fri.uniza.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sk.fri.uniza.db.IotNodeDAO;
import sk.fri.uniza.model.IotNode;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.Valid;

@Api("/iotnode") // Swagger
@Path("/iotnode") // Koreňová adresa kolekcie koncových bodov
// pre prístup k zdrojom domácností // Súčasť JAX-RS
@Produces(MediaType.APPLICATION_JSON)// Výstupné dáta sú vo forme JSON //JAX-RS
@Consumes(MediaType.APPLICATION_JSON) //Vstupné dáta sú vo forme JSON //JAX-RS
public class IoTNodeResource {

    private IotNodeDAO iotNodeDAO;

    public IoTNodeResource(IotNodeDAO iotNodeDAO) {
        this.iotNodeDAO = iotNodeDAO;
    }

    @POST
    @ApiOperation(value = "Pridá nový IotNode")
    @UnitOfWork //Otvorí novú hibernate session
    public IotNode createIotNode(@Valid IotNode iotNode) {
        return iotNodeDAO.create(iotNode);
    }

    @PUT
    @ApiOperation(value = "Upraví existujúci IotNode")
    @UnitOfWork //Otvorí novú hibernate session
    public IotNode updateIotNode(@Valid IotNode iotNode) {
        return iotNodeDAO.update(iotNode);
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Zobrazí IotNode")
    @UnitOfWork //Otvorí novú hibernate session
    public IotNode findIotNode(@PathParam("id") Long id) {
        return iotNodeDAO.findById(id);
    }

    @GET
    @ApiOperation(value = "Zobrazí všetky IotNode")
    @UnitOfWork //Otvorí novú hibernate session
    public List<IotNode> allIotNodes() {
        return iotNodeDAO.allIotNodes();
    }

}
