# Scaling Strategies

### Vertical Scaling:

![Vertical Scaling](Scaling_Databases\vertical_scaling.png "Vertical Scaling")

- Add more CPU, RAM, disk to the existing database.
- Requires downtime during reboot/scale-up.
- Gives ability to handle "scale", more load.
- vertical scaling has a physical hardware limitation.

### Horizontal Scaling:

#### a. Read Replicas:

![Read Replica](Scaling_Databases\read_replica.png "Read Replica")

- When read:write = 90:10 (range)
- We move reads to another databse so that master is free to do writes and important reads.
- API server should know which DB to connect for read and writes to get things done.

##### Replication:

![Replication](Scaling_Databases\replication.png "Replication")

- Changes on one database(master) needs tobe sent to replica to maintain consistency
- Two modes of replication:

  1. Synchronus Replication:

  ![Synchronus Replication](Scaling_Databases\sync_replication.png "Synchronus Replication")

  - strong consistency
  - zero replication log
  - slower writes.

  2. Asynchronus Replication:

  ![Asynchronus Replication](Scaling_Databases\async_replication.png "Asynchronus Replication")

  - eventual consistency
  - replication logs
  - faster writes

#### b. Sharding:

![Sharding](Scaling_Databases\sharding.png "Sharding")

- Since one node or DB server can't handle the data/load, we split it into multiple mutually exclusive subsets where writes on a particular row will go to one particular shard.
- Shards are independent, no replication between them.
- API server needs to know which server/shard to connect to get things done.
- Each shard can have its own replica if needed.
