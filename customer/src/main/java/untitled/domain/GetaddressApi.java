package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "GetaddressApi_table")
@Data
public class GetaddressApi {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
