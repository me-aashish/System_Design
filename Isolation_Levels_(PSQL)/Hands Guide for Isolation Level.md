# Hands On Isolation Levels

##### In order to test and see behaviour of different isolation levels, do the following steps:

- Create one simple table 'users' having a column 'id' of type 'numeric' and another column 'name' of type 'character varying' and insert a simple data (1, 'trans0') into that table.
- Create two terminal sessions of psql/mysql etc. side by side and set the isolation level of your choice and turn off the autocommit.
- Now begin the transaction in both the sessions.
- Now update the name from 'trans0' to 'trans1' for id = 1 in first session.
- Check the updated name in second session using command `SELECT * FROM users WHERE id=1;`
- You will see the the value of name according to the set isolation level in second session.
- Now, commit the transaction in first session and check for updated name in second session.
- Also, commit the transaction in second session and check for updated name.
- Based on the set isolation level, you will see different behaviours for name after running `SELECT * FROM users WHERE id=1;` before and after committing the tranaction in respective sessions.
