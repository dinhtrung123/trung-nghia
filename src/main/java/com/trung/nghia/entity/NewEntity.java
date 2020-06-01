package com.trung.nghia.entity;


import javax.persistence.*;

@Entity
@Table(name="new")
public class NewEntity extends BaseEntity {

   @Column(name = "title")
   private String title ;

   @Column(name = "thumbnail")
   private String  thumbnail ;

   @Column(name = "shortdese" ,columnDefinition = "TEXT")
   private String shortdese ;

   @Column(name = "content" , columnDefinition = "TEXT")
   private  String content ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortdese() {
        return shortdese;
    }

    public void setShortdese(String shortdese) {
        this.shortdese = shortdese;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
