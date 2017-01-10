package com.yourcompany.service;

import com.yourcompany.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dataService")
public class DataServiceImp implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImp.class);

    @Autowired
    @Qualifier("dataRespitory")
    private DataRepository dataRepository;

    @Override
    @Transactional
    public boolean vote(int prof, int soul, String ip) {
        if (dataRepository.ipSearch(ip).equals("")) {
            dataRepository.updateProfVote(prof);
            dataRepository.updateSoulVote(soul);
            dataRepository.updateIp(ip);
            return true;
        } else {
            return false;
        }
    }
}