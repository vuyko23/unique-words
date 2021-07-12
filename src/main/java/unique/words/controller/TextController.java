package unique.words.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unique.words.dto.request.TextRequestDto;
import unique.words.dto.response.TextResponseDto;
import unique.words.model.Stats;
import unique.words.model.Text;
import unique.words.service.StatsService;
import unique.words.service.TextService;
import unique.words.service.UniqueWordsCountingService;
import unique.words.service.mapper.TextDtoMapper;

@RestController
@RequestMapping("/request")
public class TextController {
    private final TextDtoMapper textDtoMapper;
    private final TextService textService;
    private final StatsService statsService;
    private final UniqueWordsCountingService uniqueWordsCountingService;

    public TextController(TextDtoMapper textDtoMapper, TextService textService,
                          StatsService statsService, UniqueWordsCountingService uniqueWordsCountingService) {
        this.textDtoMapper = textDtoMapper;
        this.textService = textService;
        this.statsService = statsService;
        this.uniqueWordsCountingService = uniqueWordsCountingService;
    }

    @PostMapping
    public TextResponseDto findUniqueWords(TextRequestDto requestDto) {
        Text text = textService.save(textDtoMapper.mapToModel(requestDto));
        Map<String, Long> uniqueWords = uniqueWordsCountingService.countUniqueWords(text);
        List<Stats> stats = uniqueWordsCountingService.createStats(uniqueWords, text);
        for (Stats stat : stats) {
            statsService.save(stat);
        }

    }
}
