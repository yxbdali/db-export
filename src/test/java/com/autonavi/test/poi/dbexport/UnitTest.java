package com.autonavi.test.poi.dbexport;

import com.autonavi.test.poi.dbexport.core.DefaultExport;
import com.autonavi.test.poi.dbexport.utils.SqlUtils;
import org.junit.Test;

/**
 * @author xiangbin.yang
 * @since 2017/11/24
 */
public class UnitTest {
    @Test
    public void testSqlCountBuild() {
        System.out.println(SqlUtils.buildCountSql("select name from mdb_poi where name = '2'"));
    }

    @Test
    public void testmath() {
        System.out.println("5/3=" + Math.floorDiv(5, 3));
        System.out.println("5%3=" + Math.floorMod(5, 3));
    }
}
