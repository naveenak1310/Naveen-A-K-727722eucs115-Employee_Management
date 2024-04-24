package com.login.login.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.login.login.model.PF;
import com.login.login.repository.PFRepository;

@Service
public class PFService {
    public PFRepository pfRepository;
    public PFService(PFRepository pfRepository)
    {
        this.pfRepository=pfRepository;
    }
    public PF postPf(PF pf)
    {
        return pfRepository.save(pf);
    }
    public PF getPf(int id)
    {
        return pfRepository.findById(id).orElse(null);
    }
    public List<PF> getAllpf()
    {
        return pfRepository.findAll();
    }
    public Page<PF> pagepf(int size,int pageno)
    {
        PageRequest pageRequest =PageRequest.of(size,pageno,Sort.by(Direction.DESC,"amount"));
        return pfRepository.findAll(pageRequest);
    }
    
}
