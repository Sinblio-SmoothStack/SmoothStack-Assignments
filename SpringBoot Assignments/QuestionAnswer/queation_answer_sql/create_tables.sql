DROP SCHEMA IF EXISTS `question`;

create schema if not exists `question`;

use `question`;

drop table if exists `question`.`question_type`;

create table if not exists `question`.`question_type` (
	`id` int unsigned not null auto_increment,
    `type_name` varchar(25) not null,
    primary key (`id`)
);


drop table if exists `question`.`question`;

create table if not exists `question`.`question` (
	`id` int unsigned not null auto_increment,
    `type_id` int  unsigned not null,
    primary key (`id`),
    foreign key (`type_id`) references `question`.`question_type`(`id`) on delete no action on update no action
);

drop table if exists `question`.`free_form_question`;

create table if not exists `question`.`free_form_question` (
	`question_id` int unsigned not null,
    `question_text` varchar(500),
    `official_answer` varchar(500),
    primary key (`question_id`),
    foreign key (`question_id`) references `question`.`question`(`id`) on delete cascade on update cascade
);

drop table if exists `question`.`multiple_choice_question`;

create table if not exists `question`.`multiple_choice_question` (
	`question_id` int unsigned not null,
    primary key (`question_id`),
    foreign key (`question_id`) references `question`.`question`(`id`) on delete cascade on update cascade
);

drop table if exists `question`.`multiple_choice_option`;

create table if not exists `question`.`multiple_choice_option`(
	`question_id` int unsigned not null auto_increment,
    `option_text` varchar(500),
    `correct` tinyint not null default 0,
    primary key (`question_id`),
    foreign key (`question_id`) references `question`.`multiple_choice_question`(`question_id`) on delete no action on update no action
);