/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.filters.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import org.springframework.stereotype.Service;
import edu.eci.arsw.blueprints.filters.Filter;
import edu.eci.arsw.blueprints.model.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estevan
 */
@Service("FilterA")
public class FilterA implements Filter {

    @Override
    public void filter(Blueprint bp) {
        System.out.println("REDUNDANCES FILTERING (A)");
        List<Point> pts0=bp.getPoints();        
        List<Point> ps1 = new ArrayList();
        for(int i=0;i<pts0.size()-1;i++){
            if(pts0.get(i).getX()!=pts0.get(i+1).getX() &pts0.get(i).getY()!=pts0.get(i+1).getY() ){
                ps1.add(pts0.get(i));
            }
        }
        ps1.add(pts0.get(pts0.size()-1));
        bp.setPoints(ps1);        
    }
    
}
