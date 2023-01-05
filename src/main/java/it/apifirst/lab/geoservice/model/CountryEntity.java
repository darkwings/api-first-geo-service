package it.apifirst.lab.geoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.apifirst.lab.localization.LocalizedData;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "country_localization",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id")
    )
    private Set<LocalizedData> names;

    /**
     * The ISO code of the country
     */
    @Column(name = "country_id", length = 10, unique = true)
    @JsonProperty("country_id")
    private String countryId;

    /**
     * The phone code
     */
    @Column(name = "phone_code", length = 5)
    @JsonProperty("phone_code")
    private String phoneCode;

    @JsonProperty
    private boolean deleted;

    public CountryEntity() {
    }

    public CountryEntity(Set<LocalizedData> names, String countryId, String phoneCode) {
        this.names = names;
        this.countryId = countryId;
        this.phoneCode = phoneCode;
    }

    public Long getId() {
        return id;
    }

    public Set<LocalizedData> getNames() {
        return names;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
