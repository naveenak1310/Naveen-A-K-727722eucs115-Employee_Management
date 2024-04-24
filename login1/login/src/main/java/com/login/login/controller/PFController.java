package com.login.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.login.login.model.PF;
import com.login.login.services.PFService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/pf")

public class PFController {
    public PFService pfService;
    public PFController(PFService pfService)
    {
        this.pfService=pfService;
    }
    @ResponseStatus(value =HttpStatus.ACCEPTED)
    @PostMapping("/path/post")
    public PF postMethodName(@RequestBody PF pf) {    
        return pfService.postPf(pf);
    }
    @ResponseStatus(value =HttpStatus.ACCEPTED)
    @GetMapping("/path/get/{id}")
    public PF getMethodName(@PathVariable("id") int id,@RequestParam PF pf) {
        return pfService.getPf(id);
    }
    @ResponseStatus(value =HttpStatus.ACCEPTED)
    @GetMapping("/pf")
    public List<PF> getMethodName() {
        return pfService.getAllpf();
    }
    @GetMapping("/get/page/{size}/{pageno}")
    public Page<PF> getMethodName(@PathVariable("size") int size,@PathVariable ("pageno") int pageno) {
        return pfService.pagepf(size,pageno);
    } 
}
