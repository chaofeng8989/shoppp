
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
    private Cart cart;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private ShippingAddress shippingAddress;

    @ManyToOne
    private BillingAddress billingAddress;

}
