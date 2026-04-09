alter table patients add column active Boolean not null default 1;
update patients set active = 1;