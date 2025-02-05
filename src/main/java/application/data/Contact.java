package application.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The initial value is to account for import.sql demo data ids
    @SequenceGenerator(name = "idgenerator", initialValue = 1000)
    @Column(name="id")
    private Long id;

    @Column(name="version")
    private int version;

    @Column(name="email")
    private String email = "";

    @Column (name="first_name")
    private String firstname;

    @Column (name="last_name")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"employees"})
    private Company company;

    @ManyToOne
    private Status status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
