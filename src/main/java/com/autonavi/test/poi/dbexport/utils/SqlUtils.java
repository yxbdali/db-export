package com.autonavi.test.poi.dbexport.utils;

import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Splitter;

/**
 * @author xiangbin.yang
 * @since 2017/11/24
 */
public class SqlUtils {
    public static String buildCountSql(String orignalSql) {
        StringBuilder sqlBuilder = new StringBuilder();
        Iterable<String> iterable = Splitter.on(Pattern.compile("\\s+")).split(orignalSql);

        int index = 0;
        boolean tailStarted = false;
        for (String part : iterable){
            if (index++ == 0) {
                sqlBuilder.append(part + " ");
            }
            else {
                if (part.equalsIgnoreCase("from")) {
                    sqlBuilder.append("count(1) ").append(part + " ");
                    tailStarted = true;
                }
                else if (tailStarted) {
                    sqlBuilder.append(part + " ");
                }
            }
        }

        return sqlBuilder.toString().trim();
    }

    public static List<String> mapOracleSql(String orignalSql, int totalCount, int divideCount) {
        int mod = Math.floorMod(totalCount, divideCount);
        int divide = Math.floorDiv(totalCount, divideCount);

        return null;

    }
}
