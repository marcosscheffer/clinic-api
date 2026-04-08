alter table patients add column active tinyint not null default 1;
update patients set active = 1;