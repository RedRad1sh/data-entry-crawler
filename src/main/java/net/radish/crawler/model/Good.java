package net.radish.crawler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "\"Good\"", schema = "public")
@Getter
@Setter
@ToString
public class Good extends BaseEntity {
    @Column(name = "\"goodName\"")
    private String goodName;
    @Column(name = "\"vendorNumber\"")
    private String vendorNumber;
}
