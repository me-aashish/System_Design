# Different Isolation Levels

- **Repeatable Reads:**
  Consistent reads within same transaction
  even if other transaction commited 1st transaction would not see the changes (if value alredy read).

- **Read Committed:**
  Reads within the same transaction always read fresh value
  con: multiple reads within same transaction are inconsistent.

- **Read Uncommitted:**
  Reads even uncommitted values from other tranactions. "Dirty Read".

- **Serializable:**
  Every read is a locking read and while one transaction reads, others will have to wait.
