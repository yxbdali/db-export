package com.autonavi.test.poi.dbexport.core;

import java.io.IOException;

import javax.sql.DataSource;

import com.autonavi.test.poi.dbexport.model.ExportInfo;

/**
 * @author xiangbin.yang
 * @since 2017/11/23
 */
public interface IExport {
    void export(String driver, String url, String username, String password, ExportInfo exportInfo, String outputFile) throws Exception;
}
