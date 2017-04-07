INSERT IGNORE INTO days
VALUES (1, "Monday"),
       (2, "Tuesday"),
       (3, "Wednesday"),
       (4, "Thursday"),
       (5, "Friday"),
       (6, "Saturday"),
       (7, "Sunday");
       
INSERT IGNORE INTO times
VALUES (1, "Morning"),
       (2, "Afternoon"),
       (3, "Evening");

INSERT IGNORE INTO workers
VALUES (1, "Malcolm", "Campbell"),
       (2, "Tom", "Jones"),
       (3, "Frank", "Thompson"),
       (4, "Jake", "Hurwitz"),
       (5, "Becca", "Forsyth"),
       (6, "Eva", "Butler");
       
INSERT IGNORE INTO shifts
VALUES (1, 1, 1, 1),
       (2, 6, 1, 1),
       (3, 6, 2, 1),
       (4, 6, 3, 1),
       (5, 1, 2, 2),
       (6, 3, 5, 3),
       (7, 2, 7, 2);