/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.creator;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author Estevan
 */

@Service
public class BlueprintCreator {
    static BlueprintsServices blue;   
    public static void main(String args[]) throws BlueprintPersistenceException, BlueprintNotFoundException{
         ApplicationContext bp = new ClassPathXmlApplicationContext("applicationContext.xml");
         blue=bp.getBean(BlueprintsServices.class);
         registerPlans();
         consultPlans();
         consultPlansAuthor();
         consultPoints();
    }
    
   
    
    public static void registerPlans() throws BlueprintPersistenceException{
        Point[] pts0=new Point[]{new Point(30, 40),new Point(15, 15),new Point(15, 15),new Point(45, 60),new Point(90, 40)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);        
        blue.addNewBlueprint(bp0);
        Point[] pts1=new Point[]{new Point(60, 80),new Point(95, 15),new Point(23, 47),new Point(75, 83),new Point(90, 40)};
        Blueprint bp1=new Blueprint("jhon", "plan",pts1);
        blue.addNewBlueprint(bp1);
        Point[] pts2=new Point[]{new Point(97, 86),new Point(7, 63),new Point(43, 25),new Point(52, 74),new Point(90, 30)};
        Blueprint bp2=new Blueprint("rick", "design",pts2);
        blue.addNewBlueprint(bp2);
    }
    
    public static void consultPlans() throws BlueprintNotFoundException{
        System.out.println("\nBlueprints: \n");
        Blueprint bp=blue.getBlueprint("rick", "design");
        System.out.println("Blueprint of: "+bp.getAuthor()+", called: "+bp.getName());        
        Blueprint bp1=blue.getBlueprint("jhon", "plan");
        System.out.println("Blueprint of: "+bp1.getAuthor()+", called: "+bp1.getName());
        Blueprint bp2=blue.getBlueprint("mack", "mypaint");
        System.out.println("Blueprint of: "+bp2.getAuthor()+", called: "+bp2.getName());
    }
    
    public static void consultPlansAuthor() throws BlueprintPersistenceException, BlueprintNotFoundException{
        Point[] pts1=new Point[]{new Point(60, 80),new Point(95, 15),new Point(23, 47),new Point(75, 83),new Point(90, 40)};
        Blueprint bp1=new Blueprint("mack", "plan",pts1);
        blue.addNewBlueprint(bp1);
        Point[] pts2=new Point[]{new Point(97, 86),new Point(7, 63),new Point(43, 25),new Point(52, 74),new Point(90, 30)};
        Blueprint bp2=new Blueprint("mack", "design",pts2);
        blue.addNewBlueprint(bp2);
        System.out.println("\nBlueprints for Author: \n");
        List<Blueprint> bpList=blue.getBlueprintsByAuthor("mack");
        for(Blueprint bp:bpList){
        System.out.println("Blueprint of: "+bp.getAuthor()+", called: "+bp.getName());
        }
    }
    
    public static void consultPoints() throws BlueprintNotFoundException{
        System.out.println("\nPoints of the blueprint: \n");
        Blueprint bp=blue.getBlueprintFiltered("mack", "mypaint");
        System.out.println("Blueprints of: "+bp.getAuthor()+", called: "+bp.getName());
        List<Point> points=bp.getPoints();
        System.out.println("Points:");
        for (Point p:points){
            System.out.println("X: "+p.getX()+" Y: "+p.getY());
        }
    }
    
}
