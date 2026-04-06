create table tickets (
    id bigint generated always as identity primary key,
    title varchar(120) not null,
    description text not null,
    status varchar(20) not null,
    priority varchar(20) not null,
    assignee_email varchar(254) not null,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),
    constraint ck_tickets_title_len check (char_length(btrim(title)) between 5 and 120),
    constraint ck_tickets_desc_len check (char_length(btrim(description)) >= 10),
    constraint ck_tickets_status check (status in ('OPEN','IN_PROGRESS','RESOLVED','CLOSED')),
    constraint ck_tickets_priority check (priority in ('LOW','MEDIUM','HIGH','URGENT')),
    constraint ck_tickets_assignee_email_not_blank check (assignee_email is null or char_length(btrim(assignee_email)) > 0)
);