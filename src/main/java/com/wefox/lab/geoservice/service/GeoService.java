package com.wefox.lab.geoservice.service;


import com.wefox.lab.geoservice.model.CountryEntity;
import com.wefox.lab.geoservice.openapi.model.Country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class GeoService {

    @Inject
    EntityManager em;

    public List<Country> countries(String lang, int offset, int limit) {
        // TODO join con localized data, gestire errori, validazione etc.
        try {
            var list = new ArrayList<Country>();
            var q = em.createQuery("from CountryEntity");
            List<CountryEntity> countries = q.getResultList();
            countries.forEach(ce -> {
                ce.getNames().stream().filter(d -> d.getLanguageId().equals(lang))
                        .findFirst().ifPresent(localizedData -> {
                            var c = new Country();
                            c.countryId(ce.getCountryId())
                                    .name(localizedData.getData())
                                    .deleted(ce.isDeleted())
                                    .phoneCode(ce.getPhoneCode());
                            list.add(c);
                        });
            });
            return list;
        }
        catch (Exception e) {
            return Collections.emptyList();
        }
    }
}