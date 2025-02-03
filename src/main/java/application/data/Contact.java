package application.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contact extends AbstractEntity {
    @Column(name="email")
    private String email = "";

    @Column (name="first_name")
    private String firstname;

    @Column (name="last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"employees"})
    private Company company;

    @ManyToOne
    private Status status;


    @Override
    public String toString() {
        return firstname + " " + lastName;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
