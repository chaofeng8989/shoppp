
package onlineShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "billingAddress")
@Data
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = 1028098616457762743L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "billingAddress")
    private Customer customer;

}
