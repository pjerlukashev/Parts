package net.proselyte.springmvc.model;


import org.hibernate.annotations.Proxy;



import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Proxy(lazy=false)
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank (message = "Part name should not be blank")
    @Size(min=2, max=50, message= "Part name should be between 2 and 50 characters long")
private String partName;

    @Min(0)
    @Max(1)
private int isRequired;

    @Min(0)
    @Max(1000000)
private int quantity;

    public Part(int id, String partName, int isRequired, int quantuty) {
        this.id = id;
        this.partName = partName;
        this.isRequired = isRequired;
        this.quantity = quantuty;
    }

    public Part(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", isRequired=" + isRequired +
                ", quantity=" + quantity +
                '}';
    }
}
