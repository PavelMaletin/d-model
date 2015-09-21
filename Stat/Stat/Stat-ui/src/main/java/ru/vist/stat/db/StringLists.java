package ru.vist.stat.db;

import java.util.List;
import java.util.Vector;
import javax.persistence.Query;

/**
 *
 * @author chernov
 */
public class StringLists {

    private static List<String> alFam = null;
    private static List<String> alIm = null;
    private static List<String> alOtch = null;
    private static List<String> alPost = null;

    public static List getAlFam() {
        if (alFam == null) {
            Query qwr = Init.getEm().createNativeQuery("select distinct(t.FAM) from AW_STAT.WORKER t order by 1");
            alFam = (List<String>) qwr.getResultList();
        }
        return alFam;
    }

    public static List getAlIm() {
        if (alIm == null) {
            Query qwr = Init.getEm().createNativeQuery("select distinct(t.IM) from AW_STAT.WORKER t where length(t.IM) > 2 order by 1");
            alIm = (Vector<String>) qwr.getResultList();
        }
        return alIm;
    }

    public static List getAlOtch() {
        if (alOtch == null) {
            Query qwr = Init.getEm().createNativeQuery("select distinct(t.OTCH) from AW_STAT.WORKER t where length(t.OTCH) > 2 order by 1");
            alOtch = (List<String>) qwr.getResultList();
        }
        return alOtch;
    }

    public static List getAlPost() {
        if (alPost == null) {
            Query qwr = Init.getEm().createNativeQuery("select distinct(t.NAME) from AW_STAT.REFERENCE t where t.REFERENCE_TYPE = 'POST' order by 1");
            alPost = (List<String>) qwr.getResultList();
        }
                
        return alPost;
    }

}
