/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.creator;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Estevan
 */
public class BlueprintCreator {
    @Autowired
    BlueprintsServices blue;
    
    public void registerPlains() throws BlueprintPersistenceException{
        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15),new Point(40, 40),new Point(45, 60),new Point(90, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        blue.addNewBlueprint(bp0);
    }
    
}
