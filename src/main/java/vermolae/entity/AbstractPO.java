package vermolae.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This class describes basic field for every entity in database
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractPO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}