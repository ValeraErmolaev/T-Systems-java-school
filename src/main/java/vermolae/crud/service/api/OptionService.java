package vermolae.crud.service.api;

import vermolae.model.entity.Option;

import java.util.List;

public interface OptionService extends GenericService<Option, Integer>{
    List<Option> optionsById(int id);

    List<Option> listOfAvailableOptions(int user_id, int contract_id);

    public void associateOptions(int option_first_id, int option_second_id);

    public void deleteAssociatedOption(int currentOption_id, int option_id);

    public void deleteIncompatibledOption(int currentOption_id, int option_id);


}
