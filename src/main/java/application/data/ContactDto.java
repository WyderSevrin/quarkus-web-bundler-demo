package application.data;

public class ContactDto {

    private Long id;
    private int version;
    private String email;
    private String firstname;
    private String lastname;


    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.version = contact.getVersion();
        this.email = contact.getEmail();
        this.firstname = contact.getFirstname();
        this.lastname = contact.getLastname();
    }

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
}
