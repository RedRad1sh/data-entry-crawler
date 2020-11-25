package net.radish.crawler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Shop", schema = "public")
@Getter
@Setter
@ToString
public class Shop extends BaseEntity{
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"shopUrl\"")
    private String shopUrl;
    @Column(name = "\"comment\"")
    private String comment;
}
