
package onlineShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shippingAddress")
@Data
public class ShippingAddress implements Serializable {

    private static final long serialVersionUID = 7551999649936522523L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "shippingAddress")
    private Customer customer;

}
