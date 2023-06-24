/**
 * Created By Krishna Shinde
 * Date : 24-06-2023
 * Time : 22:38
 * Project: OneToOneRelationalMappingWithHibenate
 **/

package com.mahagan.onetoonerelationalmappingwithhibenate;

import com.mahagan.onetoonerelationalmappingwithhibenate.entity.Capital;
import com.mahagan.onetoonerelationalmappingwithhibenate.entity.Country;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneRelationalMappingWithHibenateFetchAllRecords {
    public static void main(String[] args) {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        TypedQuery typedQuery=session.createQuery("from Country country");
        List<Country> list=typedQuery.getResultList();
        Iterator<Country> iterator= list.listIterator();
        while (iterator.hasNext()){
            Country country=iterator.next();
            System.out.println(country.getCountry_Name()+"   "+country.getCountry_Continent()+"   "+
                    country.getCountry_Population());
            Capital capital=country.getCapital();
            System.out.println(capital.getCapital_Name()+"   "+capital.getCapital_area()+"   "+capital.getCapital_Population());

        }
        session.close();
        System.out.println("Successfully data retrive from database ");
    }
}


