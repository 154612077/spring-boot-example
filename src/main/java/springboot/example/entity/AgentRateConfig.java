package springboot.example.entity;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class AgentRateConfig{


    private Long id;
    /** 代码*/
    private String code;

    private String year;

    private String month;

    private BigDecimal value;


}