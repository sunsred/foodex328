package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreApplication;
import untitled.domain.Accepted;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderid;

    private String foodid;

    private String option;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public void start() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void finish() {
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static void loadOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        Accepted accepted = new Accepted(cook);
        accepted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            Accepted accepted = new Accepted(cook);
            accepted.publishAfterCommit();

         });
        */

    }
}
