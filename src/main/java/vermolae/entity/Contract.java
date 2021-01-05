package vermolae.entity;

import javax.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @SequenceGenerator(name = "seq-gen", sequenceName = "hibernate_sequence", initialValue = 205, allocationSize = 12)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
