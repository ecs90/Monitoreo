package edu.utn.monitoreo.jpa;

import edu.utn.monitoreo.entities.EntityUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RepositoryUsages extends JpaRepository<EntityUsage, Long>{

    @Query("select os from EntityUsage group by os order by count(os) desc")
    List<String> findTopByOs();

    @Query("select browser from EntityUsage group by browser order by count(browser) desc")
    List<String> findFirstByBrowser();

    @Query("select os, browser from EntityUsage group by os, browser order by count(os) desc")
    List<Object[]> findMostUsedCombination();
}
