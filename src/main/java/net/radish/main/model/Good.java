package net.radish.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

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

    /**
     * Коллекция ссылок на товар
     */
    @OneToMany(mappedBy = "good", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private Collection<GoodUrl> goodUrlCollection;

    /**
     * Ссылка на связанную категорию
     */
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "\"categoryId\"")
    private Category category;
}
