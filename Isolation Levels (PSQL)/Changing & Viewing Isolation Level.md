# Command to see set isolation level:

- `SHOW default_transaction_isolation;`

# Command to change the isolation level:

- `SET DEFAULT_TRANSACTION_ISOLATION TO 'REPEATABLE READ';`

# Command to turn off/on autocommit:

- `\set AUTOCOMMIT off/on`

&rarr; Deafult isolation level of psql is **Read Commited**.
&rarr; Available isolation level in psql are: serializable, repeatable read, read committed, read uncommitted.
