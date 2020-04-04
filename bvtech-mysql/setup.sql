create schema `bvtech`;
create user 'bvtech'@'%' identified by 'bvtech';
grant all on `bvtech`.* to 'bvtech'@'%';

drop table if exists `bvtech`.ANALYSIS_REPORT;

create table if not exists `bvtech`.ANALYSIS_REPORT (
  ID bigint not null auto_increment,
  MOST_FREQUENT_WORD varchar(255) not null,
  AVERAGE_PARAGRAPH_SIZE double precision not null,
  AVERAGE_PARAGRAPH_PROCESSING_TIME double precision not null,
  TOTAL_PROCESSING_TIME bigint not null,
  CREATED_AT datetime(6) not null,
  primary key (ID)
) engine=InnoDB;
