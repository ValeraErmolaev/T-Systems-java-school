package vermolae.crud.service.api;

import vermolae.model.entity.Option;

import java.util.List;

public interface OptionService extends GenericService<Option, Integer>{
    List<Option> optionsById(int id);

    List<Option> listOfAvailableOptions(int user_id, int contract_id);
}
