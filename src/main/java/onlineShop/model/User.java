
package onlineShop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@ToString

public class User implements Serializable {

    private static final long serialVersionUID = 2681531852204068105L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Customer customer;

}
