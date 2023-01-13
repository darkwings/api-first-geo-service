package it.apifirst.lab.geoservice.legacy;

import it.apifirst.lab.geoservice.service.GeoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;


@Path("/dbCap")
@Deprecated
public class LegacyApi {

    @Inject
    GeoService geoService;

    @GET
    @Path("/regioni")
    @Produces({ "application/json", "application/problem+json" })
    public List<Regione> getRegs() {
        var r = geoService.regionsOfCountry("it", "it", 0, 20);
        return r.stream()
                .map(region -> new Regione(region.getName()))
                .collect(Collectors.toList());
    }

}


