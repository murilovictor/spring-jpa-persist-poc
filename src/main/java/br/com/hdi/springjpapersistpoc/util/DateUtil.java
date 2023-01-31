package br.com.hdi.springjpapersistpoc.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@Slf4j
public class DateUtil {

    private DateUtil() {
    }

    public static LocalDate strToLocalDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        try {
            return LocalDate.parse(date);
        } catch (Exception e) {
            log.error("Erro ao converter Data. ", e);
            return null;
        }

    }

}
