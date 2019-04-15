CREATE TABLE `employees` (
	`MID` VARCHAR(11) NOT NULL,
	`NAME` VARCHAR(200) NOT NULL,
	`JOIN_DATE` DATE NOT NULL,
	`email` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`MID`)
);


CREATE TABLE `events` (
	`EVENT_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`EVENT_TITLE` VARCHAR(200) NOT NULL,
	`DESCRIPTION` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`EVENT_ID`)
)
AUTO_INCREMENT=1
;

CREATE TABLE `employee_event` (
	`MID` VARCHAR(11) NOT NULL,
	`EVENT_ID` INT(11) NOT NULL,
	INDEX `fk_mid` (`MID`),
	INDEX `fk_event_id` (`EVENT_ID`),
	CONSTRAINT `fk_event_id` FOREIGN KEY (`EVENT_ID`) REFERENCES `events` (`EVENT_ID`),
	CONSTRAINT `fk_mid` FOREIGN KEY (`MID`) REFERENCES `employees` (`MID`)
)
;

INSERT INTO `employees` (`MID`, `NAME`, `JOIN_DATE`, `email`) VALUES ('M100100', 'Karthik Kumar', '2013-02-05', 'karthik_kumar@mindtree.com');
INSERT INTO `employees` (`MID`, `NAME`, `JOIN_DATE`, `email`) VALUES ('M100108', 'Ramesh Kulakarni', '2013-02-05', 'ramesh_kulakarni@mindtree.com');
INSERT INTO `employees` (`MID`, `NAME`, `JOIN_DATE`, `email`) VALUES ('M100189', 'Rohit Agarawal', '2013-02-22', 'rohit_agarawal@mindtree.com');
INSERT INTO `employees` (`MID`, `NAME`, `JOIN_DATE`, `email`) VALUES ('M101190', 'Magesh Narayanan', '2013-02-25', 'magesh_narayanan@mindtree.com');

INSERT INTO `events` (`EVENT_TITLE`, `DESCRIPTION`) VALUES ('Trekking', 'Held Every Month. More details from Manish Kumar');
INSERT INTO `events` (`EVENT_TITLE`, `DESCRIPTION`) VALUES ('Guitar Class', 'Weekly 3 sessions.Classes conducted by Denial M');
INSERT INTO `events` (`EVENT_TITLE`, `DESCRIPTION`) VALUES ('Yoga Class', 'Saturday and Sunday . classes conducted by Yamini');
INSERT INTO `events` (`EVENT_TITLE`, `DESCRIPTION`) VALUES ('Health And Diet tips', 'Every Friday 5PM to 6PM by Dr.Kishor Dutta');


INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100100', 1);
INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100100', 2);
INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100108', 4);
INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100189', 3);
INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100100', 4);
INSERT INTO `employee_event` (`MID`, `EVENT_ID`) VALUES ('M100189', 1);




