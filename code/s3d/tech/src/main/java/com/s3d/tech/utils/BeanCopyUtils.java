package com.s3d.tech.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.List;

/**
 * bean 相互拷贝utils.
 * @author wind.chen
 * @since 2016/9/23.
 */
public class BeanCopyUtils {

    /**
     * 拷贝单个对象的属性.
     * @param source
     * @param target
     */
    public static void copySingleObProps(Object source, Object target){
        BeanUtils.copyProperties(source, target);
    }

    public static void copyListObjProps(List sources, List targets){
        if(sources == null || targets == null || sources.size() != targets.size()){
            return ;
        }
        for(int i=0; i< sources.size(); i++){
            BeanUtils.copyProperties(sources.get(i), targets.get(i));
        }
    }

    public static void copySingleObProps(Object source, Object target, String... ignoreProperties) throws BeansException {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    public static void copyListObjProps(List<Object> sources, List<Object> targets, String... ignoreProperties){
        if(sources == null || targets == null || sources.size() != targets.size()){
            return ;
        }
        for(int i=0; i< sources.size(); i++){
            BeanUtils.copyProperties(sources.get(i), targets.get(i), ignoreProperties);
        }
    }
}
