package com._crud.springboot.util;

import java.util.Properties; 
import org.hibernate.SessionFactory; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import org.hibernate.cfg.Configuration; 
import org.hibernate.cfg.Environment; 
import org.hibernate.service.ServiceRegistry;

import com._crud.springboot.entity.Library; 
public class LibraryUtil { 
private static SessionFactory sessionFactory; 
 public static SessionFactory getSessionFactory() { 
  if(sessionFactory==null) { 
   try { 
    Configuration configuration =new Configuration(); 
     
    Properties settings=new Properties(); 
    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); 
   
 settings.put(Environment.URL,"jdbc:mysql://localhost:3306/sample"); 
    settings.put(Environment.USER,"root"); 
    settings.put(Environment.PASS,""); 
   
 settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect"); 
    settings.put(Environment.SHOW_SQL, "true"); 
   
 settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread"); 
    settings.put(Environment.HBM2DDL_AUTO, "update"); 
    configuration.setProperties(settings); 
    configuration.addAnnotatedClass(Library.class); 
     
    ServiceRegistry serviceRegistry=new 
StandardServiceRegistryBuilder() 
      .applySettings(configuration.getProperties()).build(); 
    sessionFactory=configuration.buildSessionFactory(serviceRegistry); 
     
     
   }catch(Exception e) { 
    e.printStackTrace(); 
   } 
  } 
  return sessionFactory; 
 } 
}