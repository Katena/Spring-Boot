package com.yourcompany.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;


@org.springframework.stereotype.Repository("dataRespitory")
public class DataRepositoryImpl implements DataRepository {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void updateProfVote(int id) {
        jdbcOperations.update("Update participants set prof_vote_num = prof_vote_num + 1 where id = ?;", id);

    }

    @Override
    public void updateSoulVote(int id) {
        jdbcOperations.update("Update participants set soul_vote_num = soul_vote_num + 1 where id = ?;", id);
    }

    @Override
    public void updateIp(String ip) {
        jdbcOperations.update("insert into ipvote (ip) values (?);", ip);
    }

    @Override
    public String ipSearch(String ip) {
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT ip FROM ipvote where ip = ?;", ip);
        if (rowSet.next()) {
            return rowSet.getString("ip");
        }
        return "";
    }
}