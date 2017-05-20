* Part of the output


>Hibernate: alter table ACCOUNT drop foreign key FKqcctlnq5qmxbjmcb69r2xidi8
Hibernate: alter table EMPLOYEE_ACCOUNT drop foreign key FKh2w7n9gweyk9hbc762dw1lksg
Hibernate: alter table EMPLOYEE_ACCOUNT drop foreign key FKp4v9vrtcg10g3wiejlwsolvco
Hibernate: drop table if exists ACCOUNT
Hibernate: drop table if exists EMPLOYEE
Hibernate: drop table if exists EMPLOYEE_ACCOUNT
Hibernate: create table ACCOUNT (ACCOUNT_ID integer not null auto_increment, ACCOUNT_NUM varchar(100) not null, EMPLOYEE_ID integer not null, primary key (ACCOUNT_ID))
Hibernate: create table EMPLOYEE (EMPLOYEE_ID integer not null auto_increment, FIRST_NAME varchar(100) not null, LAST_NAME varchar(100) not null, primary key (EMPLOYEE_ID))
Hibernate: create table EMPLOYEE_ACCOUNT (Employee_EMPLOYEE_ID integer not null, accounts_ACCOUNT_ID integer not null, primary key (Employee_EMPLOYEE_ID, accounts_ACCOUNT_ID))
Hibernate: alter table ACCOUNT add constraint UK_lkcdeqa7fmvoa2mrw0fc5s4dh unique (ACCOUNT_NUM)
Hibernate: alter table EMPLOYEE_ACCOUNT add constraint UK_obag0vfr1myoldc71n4iwt2i4 unique (accounts_ACCOUNT_ID)
Hibernate: alter table ACCOUNT add constraint FKqcctlnq5qmxbjmcb69r2xidi8 foreign key (EMPLOYEE_ID) references EMPLOYEE (EMPLOYEE_ID)
Hibernate: alter table EMPLOYEE_ACCOUNT add constraint FKh2w7n9gweyk9hbc762dw1lksg foreign key (accounts_ACCOUNT_ID) references ACCOUNT (ACCOUNT_ID)
Hibernate: alter table EMPLOYEE_ACCOUNT add constraint FKp4v9vrtcg10g3wiejlwsolvco foreign key (Employee_EMPLOYEE_ID) references EMPLOYEE (EMPLOYEE_ID)
May 19, 2017 5:29:37 PM org.hibernate.tool.schema.internal.SchemaCreatorImpl applyImportSources
INFO: HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@5098f78f'
Employee [employeeId=0, firstName=Sayaji, lastName=Patil, accounts=[Account [accountId=0, accountNumber=333-444-555], Account [accountId=0, accountNumber=111-222-333]]]
Hibernate: insert into EMPLOYEE (FIRST_NAME, LAST_NAME) values (?, ?)
Hibernate: insert into ACCOUNT (ACCOUNT_NUM, EMPLOYEE_ID) values (?, ?)
Hibernate: insert into ACCOUNT (ACCOUNT_NUM, EMPLOYEE_ID) values (?, ?)
**Hibernate: insert into EMPLOYEE_ACCOUNT (Employee_EMPLOYEE_ID, accounts_ACCOUNT_ID) values (?, ?)
Hibernate: insert into EMPLOYEE_ACCOUNT (Employee_EMPLOYEE_ID, accounts_ACCOUNT_ID) values (?, ?)**


From the output you can see that hibernate created a third table EMPLOYEE_ACCOUNT to store the employee
to account mappings. There is a way to tell hibernate to not create this extra table using "mappedBy"
keyword.
