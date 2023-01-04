package com.wefox.lab.geoservice;

import com.wefox.lab.geoservice.openapi.GeoApi;
import com.wefox.lab.geoservice.openapi.model.*;
import com.wefox.lab.geoservice.service.GeoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;

@ApplicationScoped
public class CountriesApiImpl implements GeoApi {

    @Inject
    GeoService geoService;

    @Override
    public CitiesByRegion200Response citiesByRegion(String countryId, String regionId, String lang, BigDecimal limit, BigDecimal offset) {
        return null;
    }

    @Override
    public CitiesByRegionAndCityId200Response citiesByRegionAndCityId(String countryId, String regionId, String cityId, String lang) {
        return null;
    }

    @Override
    public CityByCityIdAndProvince200Response cityByCityIdAndProvince(String countryId, String regionId, String provinceId, String cityId, String lang) {
        return null;
    }

    @Override
    public GetApiGeoCountriesCountryCode200Response getApiGeoCountriesCountryCode(String countryId, String lang) {
        return null;
    }

    @Override
    public CitiesByRegion200Response getApiGeoCountriesCountryCodeRegionsRegionCodeProvincesProvinceCodeCities(String countryId, String regionId, String provinceId, String lang) {
        return null;
    }

    @Override
    public GetCountries200Response getCountries(String lang, BigDecimal limit, BigDecimal offset) {
        GetCountries200Response r = new GetCountries200Response();
        var l = geoService.countries(lang, offset.intValue(), limit.intValue());
        return r.data(l)
                .links(Collections.emptyList())
                .metadata(new Metadata().currentOffset(0).totalCount(l.size()));
    }

    @Override
    public CitiesByRegionAndCityId200Response getGeoCitiesCityId(String cityId, String lang) {
        return null;
    }

    @Override
    public PostCitiesSearch200Response postCitiesSearch(String lang, BigDecimal limit, BigDecimal offset, PostCitiesSearchRequest postCitiesSearchRequest) {
        return null;
    }

    @Override
    public ProvincesByRegion200Response provincesByRegion(String countryId, String regionId, String lang) {
        return null;
    }

    @Override
    public ValidateTaxCode200Response validateTaxCode(String lang, ValidateTaxCodeRequest validateTaxCodeRequest) {
        return null;
    }


}
