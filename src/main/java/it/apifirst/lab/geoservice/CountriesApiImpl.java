package it.apifirst.lab.geoservice;

import it.apifirst.lab.geoservice.openapi.api.CountriesApi;
import it.apifirst.lab.geoservice.service.GeoService;
import it.apifirst.lab.geoservice.openapi.model.*;

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
    public CitiesByRegionAndCityId200Response citiesByRegionAndCityId(String countryId, String regionId, String cityId, String lang) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response cityByCityIdAndProvince(String countryId, String regionId, String provinceId, String cityId, String lang) {
        return null;
    }

    @Override
    public CitiesByRegion200Response citiesByRegion(String countryId, String regionId, String lang, Integer limit, Integer offset) {
        return null;
    }

    @Override
    public GetApiGeoCountriesCountryCode200Response getApiGeoCountriesCountryCode(String countryId, String lang, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public CitiesByRegion200Response getApiGeoCountriesCountryCodeRegionsRegionCodeProvincesProvinceCodeCities(String countryId, String regionId, String provinceId, String lang, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public GetCountries200Response getCountries(String lang, Integer offset, Integer limit) {
        return allCountries(lang, offset, limit);
    }

    @Override
    public ProvincesByRegion200Response provincesByRegion(String countryId, String regionId, String lang, Integer offset, Integer limit) {
        return null;
    }
}
