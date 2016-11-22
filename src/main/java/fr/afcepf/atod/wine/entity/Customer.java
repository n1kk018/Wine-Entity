package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * by roro
 */
@Entity
@DiscriminatorValue(value = "CUSTOMER")
public class Customer extends User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 708890365167036937L;

	/**
     * adresses
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="user")
    @OrderBy("billing asc")
    private List<Adress> adresses=new ArrayList<Adress>();
	/**
     * comments
     */
    @OneToMany(mappedBy = "customer")
    private Set<Comment> comments;

    
    /**
     * orders
     */
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
    
    // ------------- constructors ---------------- //
    /**
     * Default constructor
     */
    public Customer() {
        
    }

    /**
     * 
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
     * @param civility
     * @param adress
     * @param activated 
     */
    
    @Column(name = "activated", columnDefinition = "tinyInt(1) default '0'" ,nullable = false)
	private Boolean activated;
    
    /**
     * constructeur surcharge.
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
     * @param civility
     * @param adress
     * @param activated
     */
    public Customer(Integer id, String lastname, 
                    String firstname, Date birthdate, String email,
                    String login, String password, String phonenumber,
                    Date createdAt, Date updatedAt, Civility civility,
                    Boolean activated ) {
        super(id, lastname, firstname, birthdate, email, login, password,
               phonenumber, createdAt, updatedAt, civility);
        this.activated = activated;
    }
    
    // ------------ Getters && setters --------------//

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    
    public List<Adress> getAdresses() {
        return adresses;
    }
    public void addAdress(Adress adress) {
        adress.setUser(this);
        adresses.add(adress);
    }
}