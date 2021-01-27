package net.radish.main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "\"GoodUrl\"", schema = "public")
@Getter
@Setter
@ToString
public class GoodUrl extends BaseEntity {

    @Column(name = "\"url\"")
    private String url;

    @Column(name = "\"createDate\"")
    private Timestamp createDate;

    /**
     * Ссылка на связанную сущность товара
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "\"goodId\"")
    private Good good;

    /**
     * Ссылка на связанную сущность магазина
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "\"shopId\"")
    private Shop shop;

}
