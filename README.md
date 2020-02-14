# Getting Started

### Reference Documentation
There are two entitties <code>Company</code> and <code>Employee</code>

### API 

#### Company 

##### GET
curl -X GET -i http://52.14.198.54:8080/demo-0.0.1-SNAPSHOT/companies -- list of companies
curl 

#### Employee

##### GET
##### POST
<code>{
"firstName":"Johnn",
"lastName":"Deer",
"salary":250000,
"company": {
"id":2,
"name":"hollywood",
"webSite":"hollywood.com"
}
}</code>
