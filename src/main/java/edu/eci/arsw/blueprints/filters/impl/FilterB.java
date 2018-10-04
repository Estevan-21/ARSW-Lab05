/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filters.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import java.util.List;
import org.springframework.stereotype.Service;
import edu.eci.arsw.blueprints.filters.Filter;
import java.util.ArrayList;

/**
 *
 * @author Estevan
 */
@Service("FilterB")
public class FilterB implements Filter{
       

    /**
     *
     * @param bp
     * @return
     */
    @Override
    public void filter(Blueprint bp) {
        System.out.println("SUBSAMPLING FILTERING (B)");
        List<Point> pts0=bp.getPoints();
        int i=0;
        List<Point> ps1 = new ArrayList();
        for(Point p:pts0){               
            if(i%2==0){                
                ps1.add(p);
            }
            i+=1;
        }        
        bp.setPoints(ps1);        
    }
    
}
