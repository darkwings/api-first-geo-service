package it.apifirst.lab.geoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.apifirst.lab.localization.LocalizedData;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "region")
public class RegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="region_id")
    private String regionId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "region_localization",
            joinColumns = @JoinColumn(name = "region_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id")
    )
    private Set<LocalizedData> names;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @JsonProperty
    @Column
    private boolean deleted;

    public String getRegionId() {
        return regionId;
    }

    public Set<LocalizedData> getNames() {
        return names;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "RegionEntity{" +
                "id=" + id +
                ", regionId='" + regionId + '\'' +
                ", names=" + names +
                ", country=" + country +
                ", deleted=" + deleted +
                '}';
    }
}
