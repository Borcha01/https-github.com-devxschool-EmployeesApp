package com.devxschool.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="company_name")
    private String name;

    @Column(name="website")
    private String webSite;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="company", cascade = CascadeType.ALL)
    List<Employee> employees;

    public void addCompany(Employee emp){
        if(emp!=null){
            if (employees == null)
                employees = new ArrayList<Employee>();
            employees.add(emp);
            emp.setCompany(this);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
}

