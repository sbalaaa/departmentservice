package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.training.dao.DepartmentRepository;
import com.training.entities.Department;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InitalSetup implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private DepartmentRepository departmentRepository;


   public static int counter;

   @Override 
   public void onApplicationEvent(ContextRefreshedEvent event) {
       log.info("Increment counter");
       
      if( departmentRepository.count() == 0 ) {
    	  
    	  log.info("No record found in department table");
    	  
    	  Department physics = new Department();
          physics.setDepartmentName("PHYSICS");
          physics.setCreatedBy("ADMIN");
          departmentRepository.save(physics);
          
          Department chemistry = new Department();
          chemistry.setDepartmentName("CHEMISTRY");
          chemistry.setCreatedBy("ROOT");
          departmentRepository.save(chemistry);
      }
       
      
       
       counter++;
   }

}
