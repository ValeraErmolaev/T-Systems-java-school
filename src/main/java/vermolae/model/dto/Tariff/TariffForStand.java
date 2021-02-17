package vermolae.model.dto.Tariff;

import lombok.Getter;
import lombok.Setter;
import vermolae.model.entity.Tariff;
@Setter
@Getter
public class TariffForStand {
    private int id;
    private String name;
    private int numberOfContracts;

    public TariffForStand(Tariff tariff){
        this.id = tariff.getId();
        this.name = tariff.getName();
        this.numberOfContracts = tariff.getContracts().size();
    }
}

