package untitled.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private String customerid;
    private String foodid;
    private String option;
    private String status;
}
