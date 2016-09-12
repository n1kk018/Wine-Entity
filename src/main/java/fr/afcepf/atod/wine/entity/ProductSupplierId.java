package fr.afcepf.atod.wine.entity;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductSupplierId implements java.io.Serializable {
	private Product product;
	private Supplier supplier;
	
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@ManyToOne
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
