package unique.words.service.mapper;

import org.springframework.stereotype.Component;
import unique.words.dto.request.TextRequestDto;
import unique.words.model.Text;

@Component
public class TextDtoMapper {
   public Text mapToModel(TextRequestDto requestDto) {
       Text text = new Text();
       text.setPayload(requestDto.getPayload());
       return text;
   }
}
