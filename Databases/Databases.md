#Database
Database is an organized collection of data.

###DBMS (Database Management System)
Database management system provides efficient, reliable, convenient, and safe multi-user storage of and access to massive amounts of persistent data.

##ACID
ACID (Atomicity, Consistency, Isolation, Durability) is a set of properties that guarantee that database transactions are processed reliably.

* Atomicity
   * Atomicity requires that each transaction be "all or nothing": if one part of the transaction fails, the entire transaction fails, and the database state is left unchanged.
* Consistency
   * The consistency property ensures that any transaction will bring the database from one valid state to another.
* Isolation
   * The isolation property ensures that the concurrent execution of transactions results in a system state that would be obtained if transactions were executed serially, i.e., one after the other.
* Durability
   * Durability means that once a transaction has been committed, it will remain so, even in the event of power loss, crashes, or errors.

#Type of Database

##SQL (Structured Query Language)

###Relational Database
The relational model is centered on this idea: the organization of data into collections of two-dimensional tables called “relations.”

**Data Model**
* Collections of two-dimensional tables called “relations”
* Table with columns and rows
* Column is a description for each property
* Row is the actual data for matching column

**Pros**
* Flexible and well-established
* Stable, standardized products available
* Standard data access language through SQL
* Costs and risks associated with large development efforts and with large databases are well understood
* The fundamental structure is easily understood and the design and normalization process is well defined

**Cons**
* Performance problems associated with reassembling simple data structures into their more complicated real-world representations
* Lack of support for complex base types, e.g., drawings
* SQL is limited when accessing complex data
* Knowledge of the database structure is required to create ad hoc queries

**Example of Relational Database**
> MySQL  
> MSSQL  
> PostgreSQL


##NoSQL (Not only SQL)

###Document Database
A document-oriented database is a computer program designed for storing, retrieving, and managing document-oriented information, also known as semi-structured data. Document-oriented databases are one of the main categories of NoSQL databases and the popularity of the term "document-oriented database" (or "document store") has grown with the use of the term NoSQL itself.

**Data Model**
* Collection of documents
* A document is a key-value collection
* Index-centric, lots of map-reduce

**Pros**
* Simple, powerful data model
* Scalable

**Cons**
* Poor for interconnected data
* Query model is limited to key and indexes
* Map reduces for larger queries

**Example**
> MongoDB  
> CouchDB


###Key-value Database
A key-value store, or key-value database, is a computer program designed for storing, retrieving, and managing associative arrays, a data structure more commonly known today as a dictionary or hash. Dictionaries contain a collection of objects, or records, which in turn have many different fields within them, each containing data. These records are stored and retrieved using a key that uniquely identifies the record, and is used to quickly find the data within the database.

**Data Model**
* Global key-value mapping
* Big scalable hash map
* Highly fault tolerant

**Pros**
* Simple data model
* Scalable
* Redis and Mem-cached are useful for caching

**Cons**
* Create your own "foreign keys"
* Poor for complex data

**Example**
> Riak  
> LevelDB  
> DynamoDB  
> Redis  
> Mem-cached

###Big Table
BigTable maps two arbitrary string values (row key and column key) and timestamp (hence three-dimensional mapping) into an associated arbitrary byte array. It is not a relational database and can be better defined as a sparse, distributed multi-dimensional sorted map. BigTable is designed to scale into the petabyte range across "hundreds or thousands of machines, and to make it easy to add more machines [to] the system and automatically start taking advantage of those resources without any reconfiguration".

**Pros**
* Naturally indexed
* Scalable

**Cons**
* Poor for interconnected data

**Relational Database vs Big Table**
* Fixed Schema vs Schema-less
* Row-oriented datastore vs Column-oriented datastore
* Designed to store Normalized Data vs Designed to store Denormalized Data
* Contains thin tables vs Contains wide and sparsely populated tables
* Has no built-in support for partitioning vs Supports Automatic Partitioning

**Data Model**
* A big table, with column families
* Map reduce for querying and processing

**Example**
> HBase  
> Cassandra


###Graph Database
NoSQL was never a meaningful database classification. It is a label that can be applied to any database that does not have full support for SQL – and there are different reasons for choosing not to rely on SQL.

Relational database nor NoSQL database can hardly store and navigate with highly connected data structure. Such as `Social computing, Recommendations system, Business intelligence, Scientific computing for bioinformatics, etc`. Their data usually has a form of graph.

**Data Model**
* Node with properties
* Named relationship with properties
* Hypergraph, sometimes

**Pros**
* Powerful data model as general as RDBMS
* Connected data locally indexed
* Easy to query

**Cons**
* Sharding
* Understanding whole new kind of data structure

**Example**
> Neo4j


##Scaling
####Vertical Scaling (Scale-up)
Generally refers to adding more processors and RAM, buying a more expensive and robust server.

**Pros**
* Less power consumption than running multiple servers
* Cooling costs are less than scaling horizontally
* Generally less challenging to implement
* Less licensing costs
* (sometimes) uses less network hardware than scaling horizontally (this is a whole different topic that we can discuss later)

**Cons**
* PRICE
* Greater risk of hardware failure causing bigger outages
* generally severe vendor lock-in and limited upgradeability in the future

####Horizontal Scaling (Scale-out)
Generally refers to adding more servers with less processors and RAM. This is usually cheaper overall and can literally scale infinitely (although we know that there are usually limits imposed by software or other attributes of an environment’s infrastructure)

**Pros**
* Much cheaper than scaling vertically
* Easier to run fault-tolerance
* Easy to upgrade

**Cons**
* More licensing fees
* Bigger footprint in the Data Center
* Higher utility cost (Electricity and cooling)
* Possible need for more networking equipment (switches/routers)


## Author
```
Name     : Leonardo Taehwan Kim
Email    : contact@thefinestartist.com
Website  : http://www.thefinestartist.com
```
