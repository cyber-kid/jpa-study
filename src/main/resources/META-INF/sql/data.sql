# departments
insert into jpa.departments (id, dept_name, state, city, street) values (1, 'Marketing', 'PA', 'Philadelphia', 'Main street');
insert into jpa.departments (id, dept_name, state, city, street) values (2, 'PR', 'MA', 'Boston', 'Main street');
insert into jpa.departments (id, dept_name, state, city, street) values (3, 'Sales', 'VA', 'Virginia Beach', 'Atlantic avenue');
#employees
insert into jpa.employees (id, emp_name, salary, department_id, dob, state, city, street) values (1, 'Gareth Bale', 3000, 1, str_to_date('01,5,1988','%d,%m,%Y'), 'PA', 'Philadelphia', 'Main street');
insert into jpa.employees (id, emp_name, salary, department_id, dob, state, city, street) values (2, 'Tom Hardy', 4000, 2, str_to_date('01,6,1983','%d,%m,%Y'), 'PA', 'Philadelphia', 'Main street');
insert into jpa.employees (id, emp_name, salary, department_id, dob, state, city, street) values (3, 'Iker Casilas', 3000, 1, str_to_date('01,5,1982','%d,%m,%Y'), 'MA', 'Boston', 'Main street');
insert into jpa.employees (id, emp_name, salary, department_id, dob, state, city, street) values (4, 'Manuel Noer', 2500, 3, str_to_date('01,5,1979','%d,%m,%Y'), 'VA', 'Virginia Beach', 'Atlantic avenue');
insert into jpa.employees (id, emp_name, salary, department_id, dob, state, city, street) values (5, 'James Milner', 6000, 3, str_to_date('01,5,1975','%d,%m,%Y'), 'VA', 'Virginia Beach', 'Atlantic avenue');
#phones
insert into jpa.phones (phone_type, phone_number, emp_id) values ('HOME', '+4444', 1);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('MOBILE', '+5555', 1);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('HOME', '+33333', 2);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('MOBILE', '+6666', 2);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('HOME', '+11111', 3);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('MOBILE', '+22222', 3);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('HOME', '+77777', 4);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('MOBILE', '+88888', 4);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('HOME', '+121212', 5);
insert into jpa.phones (phone_type, phone_number, emp_id) values ('MOBILE', '+232323', 5);
#ids
insert into jpa.id_gen (gen_name, gen_val) values ('empIdGen', 6);
insert into jpa.id_gen (gen_name, gen_val) values ('deptIdGen', 4);
commit;
