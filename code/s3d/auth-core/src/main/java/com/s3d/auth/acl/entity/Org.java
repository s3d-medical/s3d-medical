package com.s3d.auth.acl.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/11/7 15:01
 */
@Entity
@Table(name = "auth_org")
public class Org {
    public static final boolean STATUS_VALID = true;
    public static final boolean STATUS_INVALID=false;

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="remark")
    private String desc;

    @Column(name="code")
    private String code;

    @Column(name="status")
    private Boolean status;

    @Column(name="pos")
    private Integer order;

    @ManyToOne(optional = true)
    @JoinColumn(name = "auth_parent_org_id", referencedColumnName = "id")
    private Org parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "parent")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy(value = "id asc")
    private Set<Org> children = new HashSet<Org>();

    public Org() {
    }

    /**
     *
     * @param name
     * @param code
     * @param desc
     * @param status
     */
    public Org(String name,String code,  String desc, Boolean status) {
        this.name = name;
        this.desc = desc;
        this.code = code;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Org> getChildren() {
        return children;
    }

    public void setChildren(Set<Org> children) {
        this.children = children;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void addChild(Org child){
        if(child == null){
            return ;
        }
        this.getChildren().add(child);
    }

    @Transient
    public Integer getParentId(){
        if(this.getParent() != null){
            return this.getParent().getId();
        }
        return null;
    }

    @Transient
    public String getParentName(){
        if(this.getParent() != null){
            return this.getParent().getName();
        }
        return null;
    }

}
