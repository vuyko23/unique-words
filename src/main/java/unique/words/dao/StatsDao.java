package unique.words.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import unique.words.model.Stats;

public interface StatsDao extends JpaRepository<Stats, Long> {
}
