package it.apifirst.lab.localization;



import javax.persistence.*;

@Entity
@Table(name = "localized_data")
public class LocalizedData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "language_id")
    private String languageId; // SupportedLanguage?

    @Column(name = "data")
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalizedData() {
    }

    public LocalizedData(String languageId, String data) {
        this.languageId = languageId;
        this.data = data;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LocalizedData{" +
                "languageId='" + languageId + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
