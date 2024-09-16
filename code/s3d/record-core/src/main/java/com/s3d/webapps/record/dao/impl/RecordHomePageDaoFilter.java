package com.s3d.webapps.record.dao.impl;

import com.mongodb.client.model.Filters;
import com.s3d.webapps.access.config.DoctorSignFieldConfig;
import com.s3d.webapps.record.dto.QRecordAccess;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.webapps.record.dao.impl
 * @date 2016/2/12 13:58
 */
public class RecordHomePageDaoFilter {

    public Bson buildByAccessList(String userId, List<QRecordAccess> accessList){
        if(accessList == null || accessList.size() ==0){
            return null;
        }
        List<Bson> limitByAccesses = new ArrayList<Bson>();
        for(QRecordAccess one : accessList){
            Bson filterByOneAccess = this.buildByOneAccess(userId, one);
            if(filterByOneAccess !=null){
                limitByAccesses.add(filterByOneAccess);
            }
        }
        if(limitByAccesses == null || limitByAccesses.size() ==0){
            return null;
        }
        return Filters.or(limitByAccesses);
    }

    private Bson buildByOneAccess(String userId, QRecordAccess access){
        // filter by  access
        List<Bson> limitsByAccess = new ArrayList<Bson>();
        Bson filterByDepart = this.filterByDepartNo(access);
        if(filterByDepart != null){
            limitsByAccess.add(filterByDepart);
        }
        Bson filterByFieldNames = this.filterByFieldNames(userId, access);
        if(filterByFieldNames != null){
            limitsByAccess.add(filterByFieldNames);
        }
        if(limitsByAccess.size() ==0){
            return null;
        }
        return Filters.and(limitsByAccess);
    }

    private Bson filterByDepartNo(QRecordAccess access){
        Bson filterByDepart = null;
        if( access.getDepartNo() !=null && !"".equals(access.getDepartNo())){
            filterByDepart = Filters.regex("entryExitRecord.inDepartment",access.getDepartNo());
        }
        return filterByDepart;
    }

    private Bson filterByFieldNames(String userId, QRecordAccess access){
        if(access.getSignFields() == null || access.getSignFields().size() ==0){
            return null;
        }
        // filter by sign field names.
        Bson filterFields = null;
        // get field name list.
        List<String> signFieldNames = this.getSignFieldNames(access.getSignFields());
        if(signFieldNames != null && signFieldNames.size() > 0){
            // compose pattern like this(field1 in ( 1 ) or field2 in ( 1) or field3=4)
            List<Bson> limitFields = new ArrayList<Bson>();
            for(String fieldName : signFieldNames){
                limitFields.add(Filters.eq(fieldName, userId));
            }
            filterFields = Filters.or(limitFields);
        }
        return filterFields;
    }

    private List<String> getSignFieldNames(List<String> signFields){
        return DoctorSignFieldConfig.getSignFieldNames(signFields);
    }

}
