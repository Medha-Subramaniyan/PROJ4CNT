# Root user command script
# CNT 4714 - Summer 2025 - Project 4
# This script contains the commands that a root user will issue against the
# project4 database (supplier/parts/jobs/shipments.  The Java servlet that is 
# Project 4 incoporates server-side business logic that manipulates the status of a
# supplier when certain conditions involving shipment quantity are triggered.
#
###########################################################
# Command 1: Query: list the supplier number and supplier name for those suppliers who ship every part.

select snum, sname
from suppliers
where not exists
	( select *
  	  from parts
	  where not exists
		( select *
		  from shipments
		  where shipments.snum = suppliers.snum
				and shipments.pnum = parts.pnum
		)
	);
			   
###########################################################
# Command 2 is a multi-part sequence that will trigger the business logic.
# The first part is a query to illustrate all supplier information before the update.
# The second part performs the update and causes the business logic to trigger.
# The third part is a query that illustrates all supplier information after the update/
# 

# Command 2A: Query: list all supplier information.

select *
from suppliers;

# Command 2B: add a new record to shipments table (S5, P6, J7, 400)

insert into shipments
values ('S5', 'P6', 'J6', 400);

# Command 2C: list all supplier information.

select * 
from suppliers;

###########################################################
# Command 3 is a multi-part that does not cause the business logic to trigger

# Command 3A list all supplier information

select *
from suppliers;

# Command 3B: add a new record to the supplier table (S39, Candice Swanepoel, 10, Cardiff)

insert into suppliers
values ('S39','Candice Swanepoel',10,'Cardiff');

# Command 3C: list all supplier information.

select *
from suppliers;

# Command 3D: add a new record to shipments table (S39, P3, J1, 20), business logic will trigger 

insert into shipments
values ('S39','P3','J1', 20);

# Command 3E: list all supplier information

select *
from suppliers;

###########################################################
# Command 4: List the snum, sname, and pnum for those suppliers who ship the
# same part to every job.  This is a fairly complex SQL nested query.

select distinct suppliers.snum, suppliers.sname, shipments.pnum
from suppliers natural join shipments
where shipments.pnum in
    (select pnum
     from parts
     where not exists
        (select * 
         from jobs
         where not exists
            (select *
             from shipments
             where shipments.snum = suppliers.snum
                   and shipments.pnum = parts.pnum
                   and shipments.jnum = jobs.jnum
			)
		) 
	);

###########################################################
# Command 5 is a multipart transaction that will cause the business logic to trigger
#
# The first part is a query to illustrate all shipment information before the update.
# The second part performs the update and causes the business logic to trigger.
# The third part is a query that illustrates all shipment information after the update/
# 

# Command 5A: List all supplier information

select * 
from suppliers;

# Command 5B: List all shipment information

select *
from shipments;
			  
# Command 5C: Update the shipments table by increasing the quantity by 10 every shipment of part P3.

update shipments
set quantity = quantity + 10
where pnum = 'P3';

# Command 5D:  List all shipment information

select *
from shipments;

# Command 5E:  List all supplier information

select *
from suppliers;

###########################################################
# Command 6: List the snum, and sname for those suppliers who ship only green parts.
# Output should list only supplier number S44 (Beryl Burton)

select sname
from suppliers
where snum in (select snum
               from shipments
			      where pnum in (select pnum 
							  			from parts
							  			where color = 'green'
							  			)
					)
	and
		snum not in (select snum
		             from shipments
						 where pnum in (select pnum
								    		 from parts
											 where color <> 'green'
											 )
						);
							
############################################################
# Command 7: This will generate an intentional error in command syntax.
# Output should show the error message generated by catching an SQLEception

select alpha
from jobs;		

############################################################
# Command 8: This will not trigger the business logic.
# Output should show the message indicating that the command was executed but the business logic has not triggered


update jobs
set city = "Madrid" 
where city = "Paris";		

#############################################################
# Command 9: Verify that command #8 did in fact update the jobs table

select *
from jobs;
 

 #############################################################
 # Command 10: This is a basic select command using an aggregation operator
 # Business logic not triggered and no table is updated.
 
 select count(*) as total_shipments
 from shipments;
 
 
 
  #############################################################
 # Command 11: This command will cause a referential integrity violation and will trigger an SQL exeception
 # Business logic not triggered and no table is updated. Command fails.
 
 insert into shipments values ("S0","P1","J4",150);

