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
import java.util.ArrayList;
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
    
    @Override
    @SuppressWarnings("deprecation")
    public List<Request> searchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, int limit, int offset) {
        if (empIDs.isEmpty()) {
            return Collections.emptyList();
        }

        String empIDsPlaceholder = String.join(",", Collections.nCopies(empIDs.size(), "?"));

        String sql = "SELECT requestid, empid, tieude, loai, nguoigui, ngaygui, trangthai " +
                     "FROM Request WHERE empid IN (" + empIDsPlaceholder + ") " +
                     "AND nguoigui LIKE ? " +
                     "ORDER BY ngaygui DESC " +
                     "LIMIT ? OFFSET ?";

        List<Object> params = new ArrayList<>(empIDs);
        params.add("%" + searchTerm + "%");
        params.add(limit);
        params.add(offset);

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) -> {
            Request request = new Request();
            request.setrequestid(rs.getInt("requestid"));
            request.setempid(rs.getInt("empid"));
            request.settieude(rs.getString("tieude"));
            request.setloai(rs.getString("loai"));
            request.setnguoigui(rs.getString("nguoigui"));
            request.setngaygui(rs.getDate("ngaygui"));
            request.settrangthai(rs.getInt("trangthai"));
            return request;
        });
    }

    public int countSearchRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm) {
        if (empIDs.isEmpty()) {
            return 0;
        }

        String sql = "SELECT COUNT(requestid) as total " +
                     "FROM Request " +
                     "WHERE empid IN (" + String.join(",", Collections.nCopies(empIDs.size(), "?")) + ") " +
                     "AND nguoigui LIKE ?";

        String searchPattern = "%" + searchTerm + "%";

        Object[] params = new Object[empIDs.size() + 1];
        for (int i = 0; i < empIDs.size(); i++) {
            params[i] = empIDs.get(i);
        }
        params[empIDs.size()] = searchPattern;

        return jdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<Map<String, Object>> filterRequestsByEmpID_QL(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses, int limit, int offset) {
        if (empIDs.isEmpty()) {
            return Collections.emptyList();
        }

        String empIDsPlaceholder = String.join(",", Collections.nCopies(empIDs.size(), "?"));
        String typesPlaceholder = types.isEmpty() ? "" : " AND loai IN (" + String.join(",", Collections.nCopies(types.size(), "?")) + ")";
        String statusesPlaceholder = statuses.isEmpty() ? "" : " AND trangthai IN (" + String.join(",", Collections.nCopies(statuses.size(), "?")) + ")";

        String sql = "SELECT requestid, empid, tieude, loai, nguoigui, ngaygui, trangthai " +
                     "FROM Request WHERE empid IN (" + empIDsPlaceholder + ") " +
                     "AND nguoigui LIKE ? " +
                     typesPlaceholder +
                     statusesPlaceholder +
                     " ORDER BY ngaygui DESC " +
                     "LIMIT ? OFFSET ?";

        List<Object> params = new ArrayList<>();
        params.addAll(empIDs);
        params.add("%" + searchTerm + "%");
        params.addAll(types);
        params.addAll(statuses);
        params.add(limit);
        params.add(offset);

        return jdbcTemplate.query(sql, params.toArray(), (rs, rowNum) -> {
            Map<String, Object> request = new HashMap<>();
            request.put("RequestID", rs.getInt("requestid"));
            request.put("EmpID", rs.getInt("empid"));
            request.put("TieuDe", rs.getString("tieude"));
            request.put("Loai", rs.getString("loai"));
            request.put("NgayGui", rs.getDate("ngaygui"));
            request.put("NguoiGui", rs.getString("nguoigui"));
            request.put("TrangThai", rs.getInt("trangthai"));
            return request;
        });
    }

    @Override
    @SuppressWarnings("deprecation")
    public int countFilterRequestsByEmpID(List<Integer> empIDs, String searchTerm, List<String> types, List<Integer> statuses) {
        if (empIDs.isEmpty()) {
            return 0;
        }

        String empIDsPlaceholder = String.join(",", Collections.nCopies(empIDs.size(), "?"));
        String typesPlaceholder = types.isEmpty() ? "" : String.join(",", Collections.nCopies(types.size(), "?"));
        String statusesPlaceholder = statuses.isEmpty() ? "" : String.join(",", Collections.nCopies(statuses.size(), "?"));
        searchTerm = "%" + searchTerm + "%";

        String sql = "SELECT COUNT(requestid) AS total " +
                     "FROM Request " +
                     "WHERE empid IN (" + empIDsPlaceholder + ") " +
                     "AND nguoigui LIKE ? " +
                     (types.isEmpty() ? "" : "AND loai IN (" + typesPlaceholder + ") ") +
                     (statuses.isEmpty() ? "" : "AND trangthai IN (" + statusesPlaceholder + ") ");

        List<Object> params = new ArrayList<>(empIDs);
        params.add(searchTerm);
        params.addAll(types);
        params.addAll(statuses);

        return jdbcTemplate.queryForObject(sql, params.toArray(), Integer.class);
    }
}
