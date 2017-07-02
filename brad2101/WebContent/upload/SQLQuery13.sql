use TestDB
go

select * into Customers from Northwind.dbo.Customers
select * into Orders from Northwind.dbo.Orders
go

select * from Orders

--FK ���p 
alter table Orders 
	add constraint FK_Customers_Orders
		foreign key (CustomerID) references Customers(CustomerID)

alter table Orders
	drop constraint FK_Customers_Orders 

--FK ���p �s�����
alter table Orders 
	add constraint FK_Customers_Orders
		foreign key (CustomerID) references Customers(CustomerID)
		on update cascade on delete cascade

-- ALFKI => 1234
select * from Customers 
	where CustomerID = '1234'

select * from Orders
	where CustomerID = '1234'