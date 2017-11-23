package com.autonavi.test.poi.dbexport;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DbExportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbExportApplication.class, args);
	}

	@Bean
	public PromptProvider promptProvider() {
		return () -> new AttributedString("db_export-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
	}
}
