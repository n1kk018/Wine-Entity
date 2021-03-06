package fr.afcepf.atod.wine.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * 
 * @author stagiaire
 *
 */
@Entity
@DiscriminatorValue(value = "ADMIN")
public class Admin extends User implements Serializable {

   
    /**
	 * serial.
	 */
	private static final long serialVersionUID = 3958693263738816120L;

	/**
     * bi directionnalite.
     */
    @OneToMany(mappedBy = "admin")
    private Set<SpecialEvent> events;

    /**
     * bi directionnalite
     */
    @OneToMany(mappedBy = "admin")
    private Set<Comment> comments;

    /**
     * bi directionnalite
     */
    @OneToMany(mappedBy = "admin")
    private Set<Newsletter> news;

    
    
     // ------- Constructors ------ //
    /**
     * Default constructor
     */
    public Admin() {
        
    }
    
    /**
     * @param id
     * @param lastname
     * @param firstname
     * @param birthdate
     * @param email
     * @param login
     * @param password
     * @param phonenumber
     * @param createdAt
     * @param updatedAt
     * @param label
     * @param adress 
     */
    public Admin(Integer id, String lastname, String firstname,
            Date birthdate, String email, String login, String password,
            String phonenumber, Date createdAt, Date updatedAt, 
            Civility label) {
        super(id, lastname, firstname, birthdate, email, login, password,
                phonenumber, createdAt, updatedAt, label);
    }

    // -------- getters && setters -------- //

    public Set<SpecialEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<SpecialEvent> events) {
        this.events = events;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Newsletter> getNews() {
        return news;
    }

    public void setNews(Set<Newsletter> news) {
        this.news = news;
    }
    
}