select p.name, c.name from person as p 
join company as c on c.id = p.company_id
where c.id != 5;

select c.name, count(p.company_id) from company as c 
  join person as p
  on p.company_id = c.id
  group by c.name
having  count(p.company_id) =
    (select max(v.count) from (
         select company_id, count(*) from person
         group by company_id
         ) as v
    );
