use Northwind
go

begin transaction 
	update Products set UnitPrice = 11 where ProductID = 1
	update Products set UnitPrice = 22 where ProductID = 2
	update Products set UnitPrice = 33 where ProductID = 3
	select * from Products
	--rollback transaction
commit transaction 	 