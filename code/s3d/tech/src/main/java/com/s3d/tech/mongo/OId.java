package com.s3d.tech.mongo;

import org.bson.types.ObjectId;

import java.io.Serializable;

/**
 * @author wind.chen
 * @date 2015/10/6.
 */
public class OId implements Serializable{
    private ObjectId objectId = new ObjectId();
    public OId(){
        objectId = new ObjectId();
    }
    public String get$oid() {
        return objectId.toHexString();
    }

    public void set$oid(String $oid) {
        objectId = new ObjectId($oid);
    }
}