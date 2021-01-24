package vermolae.model.dto.Tariff;

import vermolae.model.entity.Option;
import vermolae.model.entity.Tariff;

import java.util.Base64;
import java.util.List;

public class TariffViewForm {
    private int id;
    private String name;
    private String description;
    private double turnOnPrice;
    private String pictureUrl;
    private List<Option> options;

    public TariffViewForm(Tariff tariff) {
        this.id = tariff.getId();
        this.name = tariff.getName();
        this.description = tariff.getDescription();
        this.turnOnPrice = tariff.getPrice();
        this.options = tariff.getOptions();
        this.pictureUrl = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(tariff.getPicture().getPictureBytes());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTurnOnPrice() {
        return turnOnPrice;
    }

    public void setTurnOnPrice(double turnOnPrice) {
        this.turnOnPrice = turnOnPrice;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
