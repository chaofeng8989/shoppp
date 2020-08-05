
package onlineShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2681531852204068105L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String emailId;
    private String password;
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Customer customer;

}
