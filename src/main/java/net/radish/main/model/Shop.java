package net.radish.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "\"Shop\"", schema = "public")
@Getter
@Setter
@ToString
public class Shop extends BaseEntity {

    @Column(name = "\"name\"")
    private String name;

    @Column(name = "\"shopUrl\"")
    private String shopUrl;

    @Column(name = "\"comment\"")
    private String comment;

    /**
     * Коллекция ссылок на товар
     */
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Collection<GoodUrl> goodUrlCollection;
}
