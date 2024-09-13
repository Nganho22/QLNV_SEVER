package QLNVRequestAPI.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import QLNVRequestAPI.model.Request;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class RequestRepositoryImpl implements RequestRepositoryCustom  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getRequestCountsByEmpIDs(List<Integer> empIDs) {
        if (empIDs.isEmpty()) {
            Map<String, Object> result = new HashMap<>();
            result.put("total", 0);
            result.put("pending", 0);
            result.put("approved", 0);
            return result;
        }

        String sql = "SELECT " +
                     "COUNT(requestid) AS total, " +
                     "SUM(CASE WHEN trangthai = 0 THEN 1 ELSE 0 END) AS pending, " +
                     "SUM(CASE WHEN trangthai IN (1, 2) THEN 1 ELSE 0 END) AS approved " +
                     "FROM Request " +
                     "WHERE empid IN (" + String.join(",", Collections.nCopies(empIDs.size(), "?")) + ")";

        return jdbcTemplate.queryForMap(sql, empIDs.toArray());
    }
    
    @SuppressWarnings("deprecation")
    public List<Request> getRequestsByEmpID_QL(List<Integer> empIDs) {
        if (empIDs.isEmpty()) {
            return Collections.emptyList();
        }

        String sql = "SELECT * FROM Request WHERE empid IN (" + String.join(",", Collections.nCopies(empIDs.size(), "?")) + ") ORDER BY ngaygui DESC";

        return jdbcTemplate.query(sql, empIDs.toArray(), (rs, rowNum) -> {
            Request request = new Request();
            request.setrequestid(rs.getInt("requestid"));
            request.setempid(rs.getInt("empid"));
            request.settieude(rs.getString("tieude"));
            request.setloai(rs.getString("loai"));
            request.setngaygui(rs.getDate("ngaygui"));
            request.setnguoigui(rs.getString("nguoigui"));
            request.setngayxuly(rs.getDate("ngayxuly"));
            request.settrangthai(rs.getInt("trangthai"));
            request.setngaychon(rs.getDate("ngaychon"));
            return request;
        });
    }
}
