package QLNVStrava;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StravaRepository extends MongoRepository<Activity, String> {

    // Thêm các phương thức truy vấn tùy chỉnh nếu cần
}
