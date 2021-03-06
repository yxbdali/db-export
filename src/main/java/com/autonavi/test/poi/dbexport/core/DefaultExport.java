package com.autonavi.test.poi.dbexport.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.sql.DataSource;

import com.autonavi.test.poi.dbexport.model.ExportInfo;
import com.autonavi.test.poi.dbexport.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * export sql data to excel file
 *
 * @author xiangbin.yang
 * @since 2017/11/23
 */
@Slf4j
@Component
public class DefaultExport implements IExport {
    @Autowired
    private ExecutorService singleThreadPool;

    @Override
    public void export(String driver, String url, String username, String password, ExportInfo exportInfo,
                       String outputFile)
        throws Exception {
        log.info("Start to data export...");
        singleThreadPool.execute(() -> {
            DataSource dataSource = DataSourceBuilder.create().driverClassName(driver)
                .url(url)
                .username(username)
                .password(password)
                .type(BasicDataSource.class)
                .build();

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sql = exportInfo.getSql();
            String sheet = exportInfo.getSheet();

            List<Map<String, Object>> dataMapList = jdbcTemplate.queryForList(sql);
            try {
                FileUtils.createExcelFile(dataMapList, outputFile, sheet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        log.info("Export finished!");
    }
}
