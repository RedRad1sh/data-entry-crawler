package net.radish.crawler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "good", schema = "public")
@Getter
@Setter
@ToString
public class Good extends BaseEntity {
    @Column(name = "\"goodName\"")
    private String goodName;
    @Column(name = "\"vendorNumber\"")
    private String vendorNumber;
}
