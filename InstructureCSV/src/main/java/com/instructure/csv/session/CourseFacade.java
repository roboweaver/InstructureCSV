/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instructure.csv.session;

import com.instructure.csv.bean.Course;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author robweaver
 */
@Stateless
public class CourseFacade extends AbstractFacade<Course> {
    @PersistenceContext(unitName = "com.instructure_InstructureCSV_war_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CourseFacade() {
        super(Course.class);
    }
    
}
