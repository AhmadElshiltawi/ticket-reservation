# ticket-reservation
A simple theater ticket reservation system

# Requirements for running program
Must download SQLite:

Get sqlite for terminal commands - get dll (Windows) and tools
https://www.sqlite.org/download.html

Get sqlite jdbc
https://github.com/xerial/sqlite-jdbc/releases/tag/3.40.0.0

optional for viewing databases
https://sqlitestudio.pl/

Make a database called "../Database/theater.db" using theaterDatabase.sql from "./Database"
To make a SQLite database open terminal in "../Database" and write:

>> sqlite3 theater.db
>> .databases
>> .read Databases.sql

Also you need to add JavaFx lib to arg path:
https://openjfx.io/

