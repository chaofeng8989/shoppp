
package onlineShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salesOrder")
@Data
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = -6571020025726257848L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shippingAddress_id")
    private ShippingAddress shippingAddress;

    @ManyToOne
    @JoinColumn(name = "billingAddress_id")
    private BillingAddress billingAddress;

}
