package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="NACE")
public class NaceRecord {

    public NaceRecord(){}

    public NaceRecord(Long orderId,
                      Integer level,
                      String code,
                      String parent,
                      String description,
                      String includes,
                      String additionalIncludes,
                      String rulings,
                      String itemExcludes,
                      String referenceToRev4) {
        this.orderId = orderId;
        this.level = level;
        this.code = code;
        this.parent = parent;
        this.description = description;
        this.includes = includes;
        this.additionalIncludes = additionalIncludes;
        this.rulings = rulings;
        this.itemExcludes = itemExcludes;
        this.referenceToRev4 = referenceToRev4;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Integer level;

    private String code;

    private String parent;

    @Column(length = 10000)
    private String description;

    @Column(length = 10000)
    private String includes;

    @Column(length = 10000)
    private String additionalIncludes;

    private String rulings;

    @Column(length = 10000)
    private String itemExcludes;

    private String referenceToRev4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncludes() {
        return includes;
    }

    public void setIncludes(String includes) {
        this.includes = includes;
    }

    public String getAdditionalIncludes() {
        return additionalIncludes;
    }

    public void setAdditionalIncludes(String additionalIncludes) {
        this.additionalIncludes = additionalIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getItemExcludes() {
        return itemExcludes;
    }

    public void setItemExcludes(String itemIncludes) {
        this.itemExcludes = itemIncludes;
    }

    public String getReferenceToRev4() {
        return referenceToRev4;
    }

    public void setReferenceToRev4(String referenceToRev4) {
        this.referenceToRev4 = referenceToRev4;
    }
}
