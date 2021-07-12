package unique.words.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import unique.words.model.Stats;
import unique.words.model.Text;

@Service
public class UniqueWordsCountingServiceImpl implements UniqueWordsCountingService {
    @Override
    public Map<String, Long> countUniqueWords(Text text) {
        return Arrays.stream(text.getPayload().split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    @Override
    public List<Stats> createStats(Map<String, Long> uniqueWords, Text text) {
        List<Stats> stats = new ArrayList<>();
        for(Map.Entry<String, Long> word : uniqueWords.entrySet()) {
            Stats stat = new Stats();
            stat.setText(text);
            stat.setWord(word.getKey());
            stat.setEntry(word.getValue().intValue());
            stats.add(stat);
        }
        return stats;
    }
}
