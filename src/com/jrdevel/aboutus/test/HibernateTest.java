package com.jrdevel.aboutus.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jrdevel.aboutus.model.Group;
import com.jrdevel.aboutus.model.Permission;
import com.jrdevel.aboutus.util.HibernateUtil;

/**
 * @author Raphael Domingues
 *
 */
public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        Group group = new Group();
        group.setName("testeHibernate003");
        
        Set<Permission> permissions = new HashSet<Permission>();
        Permission permission1 = new Permission();
        permission1.setId(1);
        Permission permission2 = new Permission();
        permission2.setId(2);
        permissions.add(permission1);
        permissions.add(permission2);
        
        group.setPermissions(permissions);
        
        session.save(group);
        session.getTransaction().commit();
        session.close();
        
	}

}
