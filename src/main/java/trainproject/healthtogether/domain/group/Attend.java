package trainproject.healthtogether.domain.group;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Attend {

    @Id
    @GeneratedValue
    private Long id;

    private Double rate;

}
