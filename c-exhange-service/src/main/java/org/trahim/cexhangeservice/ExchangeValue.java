package org.trahim.cexhangeservice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "currency")
@Getter
@Setter
@NoArgsConstructor
public class ExchangeValue {

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_from")
    private String from;

    @Column(name = "c_to")
    private String to;
    private BigDecimal conversionMultiple;

    @Transient
    private int port;
}
