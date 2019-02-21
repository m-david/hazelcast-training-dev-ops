## Hazelcast IMDG Dev Ops Training Labs

#### Dev Ops Labs

1. Add License Key to XML files

## Lab1

#### Management Center
1. <a href="https://download.hazelcast.com/management-center/hazelcast-management-center-3.10.3.zip">Download 3.10.3</a>
2. <a href="https://download.hazelcast.com/management-center/hazelcast-management-center-3.11.3.zip">Download 3.11.3</a>
3. Install (version=3.10.x)
4. Login 
  	* create userId/password
  	* Location of credentials (delete to reset)
  	  * $HOME/hazelcast-mancenter3.10
  	  * $HOME/hazelcast-mancenter3.11


## Lab2
  
#### Deployement Topologies
Embedded (version=3.9.x)

* EmbeddedServer1 (2 nodes)
* EmbeddedServer2 (1 node)
* Add to Management Center

* Explore in MC
  * Drop EmbeddedServer2 and observe data migration

Client/Server (version=3.9.x)

* Deploy
* Add to Management Center
* Explore

## Lab3

#### Map Operations
  * IMap operations through Management Center
    * Put many
    * View in Management Center
    * Console commands
  
## Lab4

* Maintenance and Updates
  * Rolling Upgrade Server to 3.10.x
  * Upgrade Management Center to 3.11.3
 
 Notes:
 
 * For this lab, we'll need a 3 member cluster running 3.9.4.
    * From Lab3
 * Perform rolling member upgrade
 * Check that no data loss

 * Perform Mangement Center version upgrade
  

## Lab5
* Create 3 separate clusters

* WAN
  * Map Replication configuration
  * Create WAN Sync


## Lab6 and Lab7
* Revisit Rolling Upgrades

In this lab we will upgrade from HZ 3.9.x to HZ 3.10.x of a two node cluster.

1. Start Server (2 instances) in Lab6
2. Start Client (1 instance) in Lab6
3. Note data in Management Center
4. Perform rolling upgrade of servers
  * Stop Server 1 in Lab6
  * Start Server 2 in Lab7
  * Note warnings in Management Center
  * Stop Server 2 in Lab6
  * Start Server 2 in Lab7
  * Note warning in Management Center
  * Go to Administration, Rolling Upgrade
    * Update version
5. Note Client is still functioning as version 3.9.

  
  
  
