package com.s3d.tech.slicer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  Wind.Chen
 * @since 2015/6/19.
 */
public class ListSlicer<T> {
    private int sliceTotalCount = 0;
    private Map<Integer, List<T>> slicesInMap = new HashMap<Integer, List<T>>();
    private int sliceSize = 0;

    public ListSlicer(List<T> dataSrc, int sliceSize) {
        this.sliceSize = sliceSize;
        this.sliceData(dataSrc);
    }
    private int sliceData(List<T> dataSrc) {
        if (dataSrc != null && dataSrc.size() > 0) {
            List<T> oneSlice = new ArrayList<T>();
            for (int i = 0; i < dataSrc.size(); i++) {
                if (oneSlice.size() < this.sliceSize) {
                    oneSlice.add(dataSrc.get(i));
                } else {
                    // Generate data.
                    sliceTotalCount = sliceTotalCount + 1;
                    slicesInMap.put(sliceTotalCount, oneSlice);
                    oneSlice = new ArrayList<T>();
                    oneSlice.add(dataSrc.get(i));
                }
            }
            if (oneSlice.size() > 0) {
                sliceTotalCount = sliceTotalCount + 1;
                slicesInMap.put(sliceTotalCount, oneSlice);
            }
        }

        return sliceTotalCount;
    }

    public int getSliceTotalCount() {
        return sliceTotalCount;
    }

    /**
     * 1< slice No < the value of getSliceTotalCount();
     *
     * @return
     */
    public List<T> getSliceByNo(int sliceNo) {
        return this.slicesInMap.get(sliceNo);
    }
}