package it.apifirst.lab.geoservice.service;


import it.apifirst.lab.geoservice.model.RegionEntity;
import it.apifirst.lab.geoservice.openapi.model.Country;
import it.apifirst.lab.geoservice.model.CountryEntity;
import it.apifirst.lab.geoservice.openapi.model.Region;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * First implementation, rough and quick and dirty... needs refactoring. Code written only to show
 * quickly the feature of localization
 */
@ApplicationScoped
public class GeoService {

    @Inject
    EntityManager em;

    public List<Country> countries(String lang, int pageNumber, int pageSize) {
        // TODO join con localized data, paginazione, gestire errori, validazione etc.
        try {
            var list = new ArrayList<Country>();
            var q = em.createQuery("from CountryEntity");
            List<CountryEntity> countries = q.getResultList();
            countries.forEach(ce -> ce.getNames().stream().filter(d -> d.getLanguageId().equals(lang))
                    .findFirst().ifPresent(localizedData -> {
                        var c = new Country();
                        c.countryId(ce.getCountryId())
                                .name(localizedData.getData())
                                .deleted(ce.isDeleted())
                                .phoneCode(ce.getPhoneCode());
                        list.add(c);
                    }));
            return list;
        }
        catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Region> regionsOfCountry(String countryId, String lang, int pageNumber, int pageSize) {
        // TODO join con localized data, paginazione, gestire errori, validazione etc.

        var q = em.createQuery("select b from RegionEntity b " +
                "JOIN b.country c where c.countryId = :countryId");
        q.setParameter("countryId", countryId);
        List<RegionEntity> regions = q.getResultList();

        var list = new ArrayList<Region>();
        regions.forEach(ce -> ce.getNames().stream().filter(d -> d.getLanguageId().equals(lang))
                .findFirst().ifPresent(localizedData -> {
                    var c = new Region();
                    c.countryId(countryId)
                            .regionId(ce.getRegionId())
                            .name(localizedData.getData())
                            .deleted(ce.isDeleted());
                    list.add(c);
                }));
        return list;
    }
}
