package com.epam.esm.repository.mapper;

import com.epam.esm.entity.GiftCertificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.esm.repository.mapper.ColumnName.*;

/**
 * The type Gift certificate mapper implements springframework
 * RowMapper and used for ResultSet rows mapping.
 *
 * @author Maksim Rutkouski
 */
public class GiftCertificateMapper implements RowMapper<GiftCertificate> {

    @Override
    public GiftCertificate mapRow(ResultSet rs, int rowNum) throws SQLException {
        GiftCertificate certificate = new GiftCertificate();
        certificate.setId(rs.getLong(ID));
        certificate.setName(rs.getString(NAME));
        certificate.setDescription(rs.getString(DESCRIPTION));
        certificate.setPrice(rs.getBigDecimal(PRICE));
        certificate.setDuration(rs.getInt(DURATION));
        certificate.setCreateDate(rs.getTimestamp(CREATE_DATE).toLocalDateTime());
        certificate.setLastUpdateDate(rs.getTimestamp(LAST_UPDATE_DATE).toLocalDateTime());
        return certificate;
    }
}
