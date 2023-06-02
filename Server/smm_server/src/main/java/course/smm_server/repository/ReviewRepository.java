package course.smm_server.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import course.smm_server.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
