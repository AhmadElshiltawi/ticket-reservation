BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "time_seat" (
	"theater"	TEXT,
	"room_number"	INTEGER,
	"movie_name"	TEXT,
	"year"	 INTEGER,
	"month"	 INTEGER,
	"day"	 INTEGER,
	"hour"	 INTEGER,
	"minute" INTEGER,
	"seat"	TEXT,
	"member_only" BIT,
	"booked" BIT
);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 7, 10, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 7, 10, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 7, 12, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 7, 12, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Spiderman: No Way Home',2022,12, 9, 10, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Avatar: The Way of Water',2022,12, 9, 10, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Puss In Boots: The Last Wish',2022,12, 9, 14, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Black Panther: Wakanda Forever',2022,12, 13, 14, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Black Panther: Wakanda Forever',2022,12, 13, 16, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Puss In Boots: The Last Wish',2022,12, 13, 16, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',1,'Avatar: The Way of Water',2022,12, 13, 17, 15, 'b5',1, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'a1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'a2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'a3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'a4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'a5',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'b1',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'b2',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'b3',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'b4',0, 0);
INSERT INTO "time_seat" VALUES ('Theater480',2,'Spiderman: No Way Home',2022,12, 13, 18, 15, 'b5',1, 0);

CREATE TABLE IF NOT EXISTS "tickets" (
	"ticket_id"	TEXT,
	"email"	TEXT,
	"theater" TEXT,
	"room" INTEGER,
	"movie" TEXT,
	"seat" TEXT,
	"date" TEXT
);

CREATE TABLE IF NOT EXISTS "user" (
	"username" TEXT,
	"email" TEXT,
	"password" TEXT,
	"registered" BIT,
	"credit" TEXT
);

COMMIT;