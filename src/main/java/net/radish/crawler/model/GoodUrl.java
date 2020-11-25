package net.radish.crawler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "GoodUrl", schema = "public")
@Getter
@Setter
@ToString
public class GoodUrl extends BaseEntity{
    @Column(name = "\"url\"")
    private String url;
    @Column(name = "\"createDate\"")
    private Timestamp createDate;
}
