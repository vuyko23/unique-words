package unique.words.service;

import org.springframework.stereotype.Service;
import unique.words.dao.TextDao;
import unique.words.model.Text;

@Service
public class TextServiceImpl implements TextService {
    private final TextDao textDao;

    public TextServiceImpl(TextDao textDao) {
        this.textDao = textDao;
    }

    @Override
    public Text save(Text text) {
        return textDao.save(text);
    }
}
