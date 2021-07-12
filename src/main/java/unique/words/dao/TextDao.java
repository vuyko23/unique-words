package unique.words.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import unique.words.model.Text;

public interface TextDao extends JpaRepository<Text, Long> {
}
