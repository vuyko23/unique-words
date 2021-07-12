package unique.words.service;

import org.springframework.stereotype.Service;
import unique.words.dao.StatsDao;
import unique.words.model.Stats;

@Service
public class StatsServiceImpl implements StatsService {
    private final StatsDao statsDao;

    public StatsServiceImpl(StatsDao statsDao) {
        this.statsDao = statsDao;
    }

    @Override
    public Stats save(Stats stats) {
        return statsDao.save(stats);
    }
}
