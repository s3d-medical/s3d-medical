package com.s3d.webapps.config.persistence;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wind.chen
 * @date 2015/5/20.
 */
@Entity
@Table(name = "da_config_set")
public class ConfigSet implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "fd_id")
    private String fdId;

    @Column(name="fd_type")
    private String fdType;

    @Column(name="fd_name")
    private String fdName;

    @Column(name="fd_code")
    private String fdCode;

    @Column(name="fd_shortcut")
    private String fdShortcut;

    @Column(name="fd_exclusive")
    private String fdExclusive;

    @Column(name="fd_status")
    private Integer fdStatus;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdType() {
        return fdType;
    }

    public void setFdType(String fdType) {
        this.fdType = fdType;
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    public String getFdCode() {
        return fdCode;
    }

    public void setFdCode(String fdCode) {
        this.fdCode = fdCode;
    }

    public String getFdShortcut() {
        return fdShortcut;
    }

    public void setFdShortcut(String fdShortcut) {
        this.fdShortcut = fdShortcut;
    }

    public String getFdExclusive() {
        return fdExclusive;
    }

    public void setFdExclusive(String fdExclusive) {
        this.fdExclusive = fdExclusive;
    }

    public Integer getFdStatus() {
        return fdStatus;
    }

    public void setFdStatus(Integer fdStatus) {
        this.fdStatus = fdStatus;
    }
}
