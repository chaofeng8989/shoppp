package onlineShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String emailId;

    private String authorities;

}
