package vermolae.network;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import vermolae.model.dto.Tariff.TariffForStand;

import java.io.IOException;
import java.io.StringWriter;


@Component
public class JsonParser {

    public String writeToJSON(TariffForStand standUpdateDto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, standUpdateDto);
        return stringWriter.toString();
    }

}