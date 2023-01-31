package br.com.hdi.springjpapersistpoc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.hdi.my_app.domain")
@EnableJpaRepositories("br.com.hdi.springjpapersistpoc.repository")
@EnableTransactionManagement
public class DomainConfig {
}
