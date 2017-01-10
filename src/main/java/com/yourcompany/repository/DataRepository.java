package com.yourcompany.repository;

public interface DataRepository {

    void updateProfVote(int id);

    void updateSoulVote(int id);

    void updateIp(String ip);

    String ipSearch(String ip);

}
