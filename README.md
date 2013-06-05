ImpudentSQL
===========
05.06.13

ImpudentSQL is a MySQL &amp; MSSQL penetration testing utility.

ImpudentSQL has the ability to scan an address range for available MySQL & MSSQL databases on the local network. If a database is found, it will check for empty passwords on MySQL and blank passwords on MSSQL "sa" accounts. If a server is found but not penetratable, you can run a dictionary attack on it with your supplied wordlist. 

Once a server is penetrated, the user will be able to execute a series of commands on the server, exporting the results to files.