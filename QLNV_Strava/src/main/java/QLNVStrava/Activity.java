package QLNVStrava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activities") // Chỉ định tên collection trong MongoDB
public class Activity {

    @Id
    private String id;
    private String name;
    private double distance;  // Đơn vị km
    private int elapsedTime;  // Thời gian chạy, đơn vị giây
    private Date startDate;   // Thay đổi từ LocalDateTime thành Date

    // Các thuộc tính khác có thể thêm vào tùy nhu cầu
}
