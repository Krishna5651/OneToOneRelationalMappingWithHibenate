package com.mahagan.onetoonerelationalmappingwithhibenate;

import com.mahagan.onetoonerelationalmappingwithhibenate.entity.Capital;
import com.mahagan.onetoonerelationalmappingwithhibenate.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneRelationalMappingWithHibenateApplication {

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();

		Country country =new Country();
		country.setCountry_Name("India");
		country.setCountry_Continent("Asia");
		country.setCountry_Population("140Crore");

		Capital capital= new Capital();
		capital.setCapital_Name("Delhi");
		capital.setCapital_area("10000acre");
		capital.setCapital_Population("5Crore");

		capital.setCountry(country);
		country.setCapital(capital);

		session.persist(capital);
		transaction.commit();

		session.close();
		System.out.println("Successfully data has been Saved ");
	}

}
