package com.s3d.webapps.access.config.vo;

/**
 * @author wind.chen
 * @author 2015/5/23.
 */
public class CodeTableItemVO {
    private String id;
    private String name;
    private String shortcut;

    public CodeTableItemVO(String id, String name, String shortcut) {
        this.id = id;
        this.name = name;
        this.shortcut = shortcut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
}
