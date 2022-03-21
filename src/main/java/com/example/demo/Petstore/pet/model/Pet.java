package com.example.demo.Petstore.pet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Pet {
    @Id
    @SequenceGenerator(

            name="pet_sequence",
            sequenceName="pet_sequence",
            allocationSize=1

    )
    @GeneratedValue(

            strategy=GenerationType.SEQUENCE,
            generator="pet_sequence"
    )
    private int id;
    private String name;

    @OneToMany(targetEntity = PhotoUrls.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id",referencedColumnName = "id")
    private List<PhotoUrls> photoUrls = new ArrayList<PhotoUrls>();

    @OneToMany(targetEntity = Tag.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id",referencedColumnName = "id")
    private List<Tag> tags=new ArrayList<Tag>();

    @ManyToOne(targetEntity = Category.class, cascade=CascadeType.ALL, optional=true, fetch=FetchType.EAGER)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    String status;

    public Pet(String name, List<PhotoUrls> photoUrls, List<Tag> tags, Category category, String status) {
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.category = category;
        this.status = status;
    }
}
