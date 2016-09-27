/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.afcepf.atod.wine.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ronan
 */
@Table(name = "OrderDetail")
@Entity
public class OrderDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4233672529081477853L;

	/**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    
    /**
     * quantite
     */
    @Column(name     = "quantite",
            nullable = false)
    private int quantite;
    
    /**
     * order
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOrder", nullable = false)
    private Order order;
    
    /**
     * Product
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductOrdered", nullable = false)
    private Product product_ordered;
    
    // ------ Constructors ------- //

    public OrderDetail() {
    }

    /**
     * 
     * @param Id
     * @param quantite
     * @param order
     * @param product 
     */
    public OrderDetail(Integer Id, int quantite, Order order, Product product) {
        this.Id = Id;
        this.quantite = quantite;
        this.order = order;
        this.product_ordered = product;
    }
    
    
    // ------ Getters && Setters ------//

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProductOrdered() {
        return product_ordered;
    }

    public void setProductOrdered(Product product) {
        this.product_ordered = product;
    }
        
}
