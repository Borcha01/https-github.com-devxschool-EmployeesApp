# Getting Started

### Build and run

Build war file <code>mvn install</code> and deploy into any web application container like Tomcat, Jetty etc ...

### Reference Documentation
There are two entities <code>Company</code> and <code>Employee</code>

### API

#### Company 

* list of companies : <code>curl -X GET -i http://localhost:8080/demo-0.0.1-SNAPSHOT/companies </code>
* create company : <code>curl -X POST -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/companies' --data '{
"name":"bollywood",
"webSite":"bollywood.com"
}
'</code>


#### Employee
* list employees: <code>curl -X GET -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/employees</code>
* create employee: <code> curl -X POST -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/employees' --data '{ "firstName":"Raj", "lastName":"Kapoor", "salary":350000, "company": { "id":2, "name":"bollywood", "webSite":"bollywood.com" } }'</code>
* delete employee : <code> curl -X DELETE -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/employees/{id}'</code>
* increment salary: <code> curl -X POST -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/employees/{id}/incrementsalary/{incrementvalue}'</code>
* decrement salary: <code> curl -X POST -H 'Content-Type: application/json' -i 'http://localhost:8080/demo-0.0.1-SNAPSHOT/employees/{id}/decrementsalary/{decrementvalue}'</code>

