Create Database Bank;
 Use Bank;
 CREATE TABLE customer_master( CUSTOMER_NUMBER VARCHAR(6), FIRSTNAME VARCHAR(30), middlename VARCHAR(30), lastname
VARCHAR(30), CUSTOMER_CITY VARCHAR(15), CUSTOMER_CONTACT_NO VARCHAR(10), occupation VARCHAR(10), CUSTOMER_DATE_OF_BIRTH DATE,
CONSTRAINT customer_custid_pk PRIMARY KEY (CUSTOMER_NUMBER) ); 

CREATE TABLE branch_master( branch_id VARCHAR(6), branch_name VARCHAR(30), branch_city
VARCHAR(30), CONSTRAINT branch_bid_pk PRIMARY KEY (branch_id) );

 CREATE TABLE account_master (account_number VARCHAR(255), customer_number VARCHAR(255),
branch_id VARCHAR(255), opening_balance INT(20), account_opening_date DATE,
account_type VARCHAR(10), account_status VARCHAR(10), PRIMARY KEY
(account_number), FOREIGN KEY (customer_number) references
customer_master(customer_number), FOREIGN KEY (branch_id) references
branch_master(branch_id) );

 CREATE TABLE transaction_details( transaction_number VARCHAR(6), account_number VARCHAR(6), date_of_transaction DATE,
medium_of_transaction VARCHAR(20), transaction_type VARCHAR(20), transaction_amount
INT(7), CONSTRAINT transaction_details_tnumber_pk PRIMARY KEY (transaction_number),
CONSTRAINT transaction_details_acnumber_fk FOREIGN KEY (account_number)
REFERENCES account_master (account_number) );

 create table loan_details(customer_number varchar(255), branch_id varchar(255), loan_amount bigint(20),
foreign key(customer_number) references customer_master(customer_number)); 

insert into customer_master values('C00001', 'RAMESH', 'CHANDRA', 'SHARMA', 'DELHI', '9543198345','SERVICE' ,'1976-12-06');
 insert into customer_master values('C00002', 'AVINASH', 'SUNDER','MINHA', 'DELHI', '9876532109' ,'SERVICE', '1974-10-16');
 insert into customer_master values('C00003', 'RAHUL', NULL, 'RASTOGI', 'DELHI', '9765178901', 'STUDENT', '1981-09-26'); 
insert into customer_master values('C00004', 'PARUL', NULL, 'GANDHI', 'DELHI','9876532109' ,'HOUSEWIFE', '1976-11-03');
 insert into customer_master values('C00005','NAVEEN' ,'CHANDRA', 'AEDEKAR', 'MUMBAI', '8976523190', 'SERVICE' ,'1976-09-19');
 insert into customer_master values('C00006', 'CHITRESH', NULL, 'BARWE', 'MUMBAI', '7651298321','STUDENT' ,'1992-11-06');
 insert into customer_master values('C00007', 'AMIT' ,'KUMAR','BORKAR', 'MUMBAI', '9875189761', 'STUDENT', '1981-09-06'); 
 insert into customer_master values('C00008', 'NISHA', NULL, 'DAMLE', 'MUMBAI', '7954198761', 'SERVICE', '1975-12-03');
insert into customer_master values('C00009', 'ABHISHEK', NULL, 'DUTTA', 'KOLKATA','9856198761', 'SERVICE' ,'1973-05-22'); 
insert into customer_master values('C00010','SHANKAR' ,NULL, 'NAIR', 'CHENNAI', '8765489076', 'SERVICE', '1976-07-12'); 

insert into branch_master values('B00001', 'ASAF ALI ROAD','DELHI');
 insert into branch_master values('B00002','NEW DELHI MAIN BRANCH','DELHI'); 
insert into branch_master values('B00003' ,'DELHI CANTT', 'DELHI'); 
insert into branch_master values('B00004','JASOLA', 'DELHI'); 
insert into branch_master values('B00005' ,'MAHIM' ,'MUMBAI');
 insert into branch_master values('B00006' ,'VILE PARLE', 'MUMBAI');
 insert into branch_master values('B00007', 'MANDVI' ,'MUMBAI');
 insert into branch_master values('B00008','JADAVPUR', 'KOLKATA');
 insert into branch_master values('B00009' ,'KODAMBAKKAM','CHENNAI');
 
 insert into account_master values('A00001' , 'C00001' ,'B00001' ,1000 ,'2012-12-15', 'SAVING', 'ACTIVE'); 
 insert into account_master values('A00002' ,'C00002' ,'B00001' ,1000,'2012-06-12' ,'SAVING', 'ACTIVE');
 insert into account_master values('A00003' ,'C00003','B00002', 1000 ,'2012-05-17' ,'SAVING', 'ACTIVE'); 
 insert into account_master values('A00004','C00002', 'B00005', 1000 ,'2013-01-27' ,'SAVING ','ACTIVE'); 
 insert into account_master values('A00005' ,'C00006', 'B00006', 1000 ,'2012-12-17' ,'SAVING','ACTIVE');
 insert into account_master values('A00006' ,'C00007', 'B00007', 1000 ,'2010-08-12' ,'SAVING','SUSPENDED'); 
 insert into account_master values('A00007' ,'C00007', 'B00001', 1000 ,'2012-10-02' ,'SAVING ','ACTIVE'); 
 insert into account_master values('A00008' ,'C00001' ,'B00003',1000 ,'2009-11-09' ,'SAVING ','TERMINATED'); 
 insert into account_master values('A00009','C00003', 'B00007', 1000 ,'2008-11-30' ,'SAVING', 'TERMINATED'); 
 insert into account_master values('A00010' ,'C00004', 'B00002', 1000 ,'2013-03-01' ,'SAVING', 'ACTIVE'); 

 insert into transaction_details values('T00001', 'A00001', '2013-01-01', 'CHEQUE', 'DEPOSIT', 2000);
insert into transaction_details values ('T00002' ,'A00001' ,'2013-02-01' ,'CASH','WITHDRAWAL', 1000); 
insert into transaction_details values ('T00003', 'A00002 ', '2013-01-01', 'CASH' ,'DEPOSIT', 2000);
 insert into transaction_details values('T00004', 'A00002', '2013-02-01' , 'CASH' ,'DEPOSIT', 3000);
 insert into transaction_details values('T00005', 'A00007','2013-01-11', 'CASH' ,'DEPOSIT', 7000);
 insert into transaction_details values('T00006','A00007', '2013-01-13', 'CASH' ,'DEPOSIT', 9000); 
 insert into transaction_details values('T00007', 'A00001', '2013-03-13', 'CASH' ,'DEPOSIT' ,4000);
 insert into transaction_details values('T00008', 'A00001', '2013-03-14', 'CHEQUE' ,'DEPOSIT' ,3000);
insert into transaction_details values('T00009', 'A00001', '2013-03-21', 'CASH' ,'WITHDRAWAL',9000);
 insert into transaction_details values('T00010', 'A00001', '2013-03-22', 'CASH','WITHDRAWAL' ,2000);
 insert into transaction_details values('T00011', 'A00002', '2013-03-25','CASH' ,'WITHDRAWAL' ,7000); 
 insert into transaction_details values('T00012', 'A00007', '2013-03-26', 'CASH' ,'WITHDRAWAL' ,2000);
 
 insert into Loan_details values('C00001', 'B00001',100000);
 insert into Loan_details values('C00002', 'B00002', 200000);
 insert into Loan_details values('C00009', 'B00008', 400000);
 insert into Loan_details values('C00010', 'B00009',500000); 
 insert into Loan_details values('C00001', 'B00003', 600000); 
 insert into Loan_details values('C00002', 'B00001', 600000);
delete from Loan_details;
set sql_safe_updates=0;
select * from Loan_details;
/*1. Write a query to display account number, customer’s number, customer’s firstname,lastname,account opening date.Display the records sorted in 
ascending order based on account number*/
select * from customer_master;
 select * from account_master;
 
 select account_master.account_number,customer_master.firstname,customer_master.lastname,account_master.account_opening_date 
 from customer_master
 join account_master on customer_master.customer_number = account_master.customer_number 
 order by account_master.account_number asc;
 
 /*2. Write a query to display the number of customer’s from Delhi. Give the count an alias name of Cust_Count.*/
 select count(customer_number) as count from customer_master as cm
 group by customer_city having count>2;		/*group all cities... delhi 4 mumbai 4 kolkata 1 chennai 1.....delhi and mumbai greater than 2 */
 
select count(customer_number) from customer_master 
group by customer_city having customer_city="delhi";

/*3. Write a query to display the customer number, 
customer firstname,account number for the customer’s whose accounts were created after 
15th of any month.Display the records sorted in ascending order based on customer number 
and then by account number.*/
select * from customer_master;
select * from account_master;

select cm.customer_number,cm.firstname, account_master.account_number from customer_master as cm
join account_master on cm.customer_number = account_master.customer_number
where day(account_opening_date)>15 order by cm.customer_number , account_master.account_number;

/*4. Write a query to display customer number, customer's 
first name, account number where the account status is terminated.Display the records sorted 
in ascending order based on customer number and then by account number.*/
select * from customer_master;
select * from account_master;
select cm.customer_number,cm.firstname,account_master.account_number from customer_master as cm
join account_master on cm.customer_number = account_master.customer_number
where account_master.account_status="terminated" order by cm.customer_number , account_master.account_number asc;

/*25. Write a query to display the customers firstname, city and account number whose occupation 
are not into Business, Service or Student.Display the records sorted in ascending order based on 
customer first name and then by account number*/
select * from customer_master;
select * from account_master;
select cm.firstname,cm.CUSTOMER_CITY,account_master.account_number from customer_master as cm
join account_master on cm.customer_number = account_master.customer_number
where cm.occupation not in ('business','service','student')
order by cm.firstname , account_master.account_number asc;

/*24. Write a query to display the customer number , firstname, customer’s date of birth . Display 
the records sorted in ascending order of date of birth year and within that sort by firstname in 
ascending order.*/
select cm.customer_number,cm.firstname,cm.CUSTOMER_DATE_OF_BIRTH from customer_master as cm
join account_master on cm.customer_number = account_master.customer_number
order by cm.CUSTOMER_DATE_OF_BIRTH , cm.firstname asc;

/*23. Write a query to display customer’s number, first name and middle name. For the customers 
who don’t have middle name, display their last name as middle name. Give the alias name as 
Middle_Name.*/

select customer_master.customer_number,customer_master.firstname,
if (middlename is not null,middlename, lastname)as middlename from customer_master;  /*with if condition*/

select customer_master.customer_number,customer_master.firstname,customer_master.middlename,
 coalesce(middlename,lastname)as middlename from customer_master;    /*using coalesce*/
 
/*22. Write a query to display account id, customer’s firstname, customer’s lastname for the 
customer’s whose account is Active.Display the records sorted in ascending order based on 
account id /account number.*/
select * from customer_master;
select * from account_master;

select account_master.account_number,customer_master.firstname,customer_master.lastname from customer_master 
join account_master on customer_master.customer_number=account_master.customer_number
where account_master.account_status="Active" order by account_master.account_number asc;

/*21. Write a query to display city name and count of 
branches in that city. Give the count of branches an alias name of Count_Branch.Display the 
records sorted in ascending order based on city name. */
select * ,count(branch_id) as  Count_Branch from branch_master
group by branch_city
order by branch_master.branch_city asc;
select * from branch_master;

/*20.  Write a query to display the customer’s number, 
customer’s firstname, branch id and loan amount for people who have taken loans..Display the 
records sorted in ascending order based on customer number and then by branch id and then 
by loan amount.*/
select * from customer_master; 

select cm.customer_number,cm.firstname,loan_details.branch_id,loan_details.loan_amount from customer_master as cm
join loan_details on cm.customer_number= loan_details.customer_number
order by cm.customer_number,loan_details.branch_id, loan_details.loan_amount;

/*19. Write a query to display the customer number, firstname, lastname for those client where 
total loan amount taken is maximum and at least taken from 2 branches. */
select * from loan_details; 
select * from customer_master; 

select cm.customer_number,cm.firstname,cm.lastname,sum(loan_amount)as Total_loan_amount from loan_details
join customer_master as cm on loan_details.customer_number=cm.customer_number
group by loan_details.customer_number
having count(branch_id)>=2
order by cm.customer_number desc;
/*group by branch id*/

/*5. Write a query to display the total number of 
withdrawals and total number of deposits being done by customer whose customer number 
ends with 001. The query should display transaction type and the number of transactions. Give 
an alias name as Trans_Count for number of transactions. Display the records sorted in 
ascending order based on transaction type.*/
select * from customer_master;
select * from branch_master;
select * from account_master;
select * from transaction_details;
select * from loan_details;

-- select Transaction_Type,count(*) as Trans_Count,Customer_Number
--  from transaction_details as t,customer_master as c where c.customer_number like "%001" group by transaction_type ;
select * from account_master;
select * from transaction_details;
-- select td.transaction_type,am.customer_number, count(transaction_type)as Trans_Count 
-- from transaction_details as td
-- join account_master as am on td.account_number=am.account_number
-- group by td.transaction_type having am.customer_number like "%001";
select transaction_details.transaction_type,count(transaction_details.transaction_number) as Trans_Count from transaction_details
join account_master as am on am.account_number=transaction_details.account_number 
where customer_number like "%001"
group by transaction_details.transaction_type;

-- create table karthik(name varchar(10), age int);
-- create table lavanya(name varchar(10), age int);
-- truncate table karthik;
-- drop table karthik;
-- show tables;
-- select * from karthik;

/*6. Write a query to display the number of customers who 
have registration but no account in the bank.Give the alias name as Count_Customer for 
number of customers.
*/
select * from customer_master;
select * from account_master;

select count(customer_master.customer_number)as Count_Customer from customer_master
left outer join account_master on customer_master.customer_number=account_master.customer_number where account_master.account_number is null;
 
/*7. Write a query to display account number and total 
amount deposited by each account holder ( Including the opening balance ). Give the total 
amount deposited an alias name of Deposit_Amount. Display the records in sorted order based 
on account number.*/
select * from transaction_details;
select * from account_master;

select transaction_details.account_number,sum(transaction_amount)+opening_balance as Deposit_Amount from transaction_details
join account_master on transaction_details.account_number=account_master.account_number
 where transaction_details.transaction_type="deposit"   
group by transaction_details.account_number;

/*8. Write a query to display the number of accounts opened in each city .The Query should display Branch City and number of accounts as 
No_of_Accounts.For the branch city where we don’t have any accounts opened display 0. 
Display the records in sorted order based on branch city.*/

select * from branch_master;
select * from account_master;

select branch_master.branch_city,count(account_master.account_number) as No_of_Accounts from branch_master
left outer join account_master on branch_master.branch_id=account_master.branch_id
group by branch_master.branch_city
order by branch_master.branch_city;

/*9. Write a query to display the firstname of the customers who have more than 1 account. Display the records in sorted order based on 
firstname*/
select * from account_master;
select * from customer_master;

select * from account_master
join customer_master on account_master.customer_number=customer_master.customer_number
group by account_number
having account_number;