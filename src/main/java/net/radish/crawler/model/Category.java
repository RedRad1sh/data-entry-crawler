package net.radish.crawler.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Category", schema = "public")
@Getter
@Setter
@ToString
public class Category extends BaseEntity{
    @Column(name = "\"name\"")
    private String goodName;
}
