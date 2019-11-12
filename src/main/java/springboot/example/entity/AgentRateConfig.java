package springboot.example.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class AgentRateConfig{

    @Id
    @Column(
            name = "Id"
    )
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;
    /** 代码*/
    private String code;

    private String year;

    private String month;

    private BigDecimal value;

}