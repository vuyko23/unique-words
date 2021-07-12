package unique.words.service;

import java.util.List;
import java.util.Map;
import unique.words.model.Stats;
import unique.words.model.Text;

public interface UniqueWordsCountingService {
    Map<String, Long> countUniqueWords(Text text);

    List<Stats> createStats(Map<String, Long> uniqueWords, Text text);
}
