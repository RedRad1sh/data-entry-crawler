package net.radish.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "\"Category\"", schema = "public")
@Getter
@Setter
@ToString
public class Category extends BaseEntity {

    @Column(name = "\"name\"")
    private String name;

    /**
     * Ссылка на вышестоящую категорию (если not null)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"parentId\"", referencedColumnName = "id")
    private Category parent;

    /**
     * Коллекция нижестоящих категорий
     */
    @JsonIgnore
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Category> categoryCollection;

    /**
     * Коллекция товары
     */
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Good> goodCollection;
}
