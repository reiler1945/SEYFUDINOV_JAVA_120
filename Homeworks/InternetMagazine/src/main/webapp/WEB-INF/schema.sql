create table service_user (
                              id bigserial primary key,
                              first_name varchar(20),
                              last_name varchar(20),
                              email varchar(100) unique,
                              login varchar(100) unique,
                              password varchar(100),
                              role varchar(10)
);

create table cookie (
                        id bigserial primary key,
                        value VARCHAR(200),
                        user_id bigint,
                        foreign key (user_id) references service_user(id)

);

create table articles (
                          article_id bigserial primary key,
                          name VARCHAR(100) not null,
                          price money
);

create table carts (
                        cart_id bigserial primary key,
                        user_id bigint not null references service_user(id)
);

create table fill_carts (
                        cart_id bigint not null references carts(cart_id),
                        article_id bigint not null references articles(article_id)
);