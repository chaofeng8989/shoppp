
package onlineShop.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 5186013952828648626L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category")
    private String productCategory;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "manufacturer")
    private String productManufacturer;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private double productPrice;

    @Column(name = "unit")
    private String unitStock;

    @Transient
    private MultipartFile productImage;

}
