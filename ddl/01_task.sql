create table task
(
    id           varchar(36) primary key,
    workspace_id varchar(36) references workspace not null,
    title        varchar(64)                      not null,
    description  varchar(512)                     not null
)