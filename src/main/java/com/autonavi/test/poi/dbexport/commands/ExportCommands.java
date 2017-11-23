package com.autonavi.test.poi.dbexport.commands;

import com.alibaba.fastjson.JSONObject;

import com.autonavi.test.poi.dbexport.core.IExport;
import com.autonavi.test.poi.dbexport.model.ExportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author xiangbin.yang
 * @since 2017/11/23
 */
@ShellComponent
public class ExportCommands {
    @Autowired
    IExport export;

    @ShellMethod("export data from mysql database to excel")
    public String export(@ShellOption String url,
                         @ShellOption String username,
                         @ShellOption String password,
                         @ShellOption(defaultValue = "mysql-export.xlsx") String outputFile,
                         @ShellOption(
                             help = "A json string that contain sql query and export excel sheet name {sql: 'select *"
                                 + " from a', sheet: 'sheeta'}")
                             String exportInfo) throws Exception {
        ExportInfo exportInfoObj = JSONObject.parseObject(exportInfo, ExportInfo.class);
        export.export("com.mysql.jdbc.Driver", url, username, password, exportInfoObj, outputFile);

        return "finished!";
    }

    @ShellMethod("export data from oracle database to excel")
    public String oracleExport(@ShellOption String url,
                               @ShellOption String username,
                               @ShellOption String password,
                               @ShellOption(defaultValue = "oracle-export.xlsx") String outputFile,
                               @ShellOption(
                                   help = "A json string that contain sql query and export excel sheet name {sql: "
                                       + "'select * from a', sheet: 'sheeta'}")
                                   String exportInfo) throws Exception {
        ExportInfo exportInfoObj = JSONObject.parseObject(exportInfo, ExportInfo.class);
        export.export("oracle.jdbc.OracleDriver", url, username, password, exportInfoObj, outputFile);

        return "finished!";
    }
}
