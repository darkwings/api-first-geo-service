package com.wefox.lab.geoservice;

import com.wefox.lab.geoservice.openapi.CountriesApi;
import com.wefox.lab.geoservice.openapi.model.*;
import com.wefox.lab.geoservice.service.GeoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;

@ApplicationScoped
public class CountriesApiImpl implements CountriesApi {

    @Inject
    GeoService geoService;

    private GetCountries200Response allCountries(String lang, int offset, int limit) {
        GetCountries200Response r = new GetCountries200Response();
        var l = geoService.countries(lang, offset, limit);
        return r.data(l)
                .links(Collections.emptyList())
                .metadata(new Metadata().currentOffset(0).totalCount(l.size()));
    }


    @Override
    public CitiesByRegion200Response citiesByRegion(String countryId, String regionId, String lang, BigDecimal limit, BigDecimal offset) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response citiesByRegionAndCityId(String countryId, String regionId, String cityId, String lang) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response cityByCityIdAndProvince(String countryId, String regionId, String provinceId, String cityId, String lang) {
        return null;
    }

    @Override
    public GetApiGeoCountriesCountryCode200Response getApiGeoCountriesCountryCode(String countryId, String lang, BigDecimal offset, BigDecimal limit) {
        return null;
    }

    @Override
    public CitiesByRegion200Response getApiGeoCountriesCountryCodeRegionsRegionCodeProvincesProvinceCodeCities(String countryId, String regionId, String provinceId, String lang, BigDecimal offset, BigDecimal limit) {
        return null;
    }

    @Override
    public GetCountries200Response getCountries(String lang, BigDecimal offset, BigDecimal limit) {
        return allCountries(lang, offset.intValue(), limit.intValue());
    }

    @Override
    public ProvincesByRegion200Response provincesByRegion(String countryId, String regionId, String lang, BigDecimal offset, BigDecimal limit) {
        return null;
    }
}
