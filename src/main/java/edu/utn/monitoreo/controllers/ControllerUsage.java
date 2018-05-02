package edu.utn.monitoreo.controllers;

import edu.utn.monitoreo.entities.EntityUsage;
import edu.utn.monitoreo.jpa.RepositoryUsages;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsage {
    @Autowired //Reemplazo de singleton (genera instancias)
    private RepositoryUsages repositories;

    @GetMapping //API
    public EntityUsage reportUsage(@RequestHeader("User-Agent") String userAgent){
        UserAgent ua = new UserAgent(userAgent);
        EntityUsage entity = new EntityUsage();
        entity.setOs(ua.getOperatingSystem().getName());
        entity.setBrowser(ua.getBrowser().getName());
        repositories.save(entity);
        return entity;
    }

    @GetMapping("OS")
    String findMostUsedOS(){
        String valor = repositories.findTopByOs().get(0);
        return valor;
    }

    @GetMapping("Browser")
    String findMostUsedBrowser(){
        String valor = repositories.findFirstByBrowser().get(0);
        return valor;
    }

    @GetMapping("Combination")
    Object[] findMostUsedCombination(){
        return repositories.findMostUsedCombination().get(0);
    }

}
