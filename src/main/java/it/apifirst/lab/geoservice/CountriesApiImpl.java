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

    private GetCountries200Response allCountries(String lang, int pageNumber, int pageSize) {
        GetCountries200Response r = new GetCountries200Response();
        var l = geoService.countries(lang, pageNumber, pageSize);
        return r.data(l)
                .links(Collections.emptyList())
                .metadata(new Metadata().currentOffset(0).totalCount(l.size()));
    }


    @Override
    public CitiesByRegion200Response citiesByRegion(String countryId, String regionId, String lang, Integer pageNumber, Integer pageSize, String accept) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response citiesByRegionAndCityId(String countryId, String regionId, String cityId, String lang, String accept) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response cityByCityIdAndProvince(String countryId, String regionId, String provinceId, String cityId, String lang, String accept) {
        return null;
    }

    @Override
    public GetApiGeoCountriesCountryCode200Response getApiGeoCountriesCountryCode(String countryId, String lang, Integer pageNumber, Integer pageSize, String accept) {
        return null;
    }

    @Override
    public CitiesByRegion200Response getApiGeoCountriesCountryCodeRegionsRegionCodeProvincesProvinceCodeCities(String countryId, String regionId, String provinceId, String lang, Integer pageNumber, Integer pageSize, String accept) {
        return null;
    }

    @Override
    public GetCountries200Response getCountries(String lang, Integer pageNumber, Integer pageSize, String accept) {
        return allCountries(lang, pageNumber, pageNumber);
    }

    @Override
    public ProvincesByRegion200Response provincesByRegion(String countryId, String regionId, String lang, Integer pageNumber, Integer pageSize, String accept) {
        return null;
    }
}
