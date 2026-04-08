alter table doctors add column active tinyint not null default 1;
update doctors set active = 1;