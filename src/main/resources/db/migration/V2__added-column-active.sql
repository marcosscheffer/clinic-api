alter table doctors add column active Boolean not null default 1;
update doctors set active = 1;