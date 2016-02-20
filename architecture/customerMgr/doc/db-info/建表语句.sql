drop table if exists tbl_customer;
create table tbl_customer
(
   uuid                    int not null auto_increment,
   customerId              varchar(20),
   pwd                     varchar(20),
   showName                varchar(100),
   trueName                varchar(100),
   registerTime            varchar(100),
   primary key (uuid)
) charset=utf8 ENGINE=InnoDB;