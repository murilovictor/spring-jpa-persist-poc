package br.com.hdi.springjpapersistpoc.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LowerCasePhysicalNamingStrategyStandardImpl implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return getToIdentifier(identifier);
    }

    private static Identifier getToIdentifier(Identifier identifier) {
        if (identifier == null) {
            return null;
        }
        return Identifier.toIdentifier(identifier.getText().toLowerCase(Locale.ROOT));
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return getToIdentifier(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return getToIdentifier(identifier);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return getToIdentifier(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return getToIdentifier(identifier);
    }
}
