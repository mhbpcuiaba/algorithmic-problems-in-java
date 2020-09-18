package br.com.mhbp.tree.avl;

public class AVLTree {

    Node root;

    public void insert(int data) {

    }

    public void traverse() {

        if (root == null) return;

        inOrderTrvaerse(root);
    }

    public int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int balance(Node n) {
        if (n == null) return 0;

        return Math.abs(balance(n.left) - balance(n.right));
    }

    private void inOrderTrvaerse(Node node) {
        if (node != null) {
            inOrderTrvaerse(node.left);
            System.out.print(node.data + " ");
            inOrderTrvaerse(node.right);
        }
    }

}
/**

 create table payments (

    customer_name varchar(128),
    processed_at date,
    amount int
 );

 create table balances (

    username varchar(120),
    balance int
 );

 create table large_table (
    random_int
 );


 insert into payments values('clement', '2019-12-15', 10);
 insert into payments values('Fabio', '2019-11-15', 10);
 .
 .
 .

 insert into  balances values ('antonie', 0);
 insert into  balances values ('clement', 230);

 insert into large_table (random_int)
 select round(random * 1000000)
 from generate_series(1, 50000000) s(i);



 select customer_name, count(1)
 from payments
 group by customer_name
 order by count desc;


 select sum(amount), extract(year from processed_at) as year, extract(month from processed_at)
 from payments
 group by month, year
 order by sum desc;


 select customer_name, sum(amount), extract(year from processed_at) as year, extract(month from processed_at)
 from payments
 group by customer_name, month, year
 order by customer_name desc;



 select customer_name, sum(amount), extract(year from processed_at) as year, extract(month from processed_at)
 from payments
 group by customer_name, month, year
 order by customer_name desc;


select max(amount), year, mpnth
 from (
         select customer_name, sum(amount), extract(year from processed_at) as year, extract(month from processed_at)
         from payments
         group by customer_name, month, year
         order by customer_name desc;
) as monthly_sums
 group by year, month;


begin transaction
    update balances set balance = balance - 100 where username = 'clement';
    update balances set balance = balance + 100 where username = 'antonie';

commit;


 select * from large_table order by random_int desc limit 10;

 create index large_table_random_int_idx on large_table(random_int);




 create table account (
    account_id serial  primary key,
    name text not null,
    dob date
 );


create thread (
    thread_id serial primary key,
    account_id integer not null references account(account_id),
    title text not null
 );


create table post (

    post_id serial primary key,
    thread_id integer not null references thread(thread_id)
    account_id integer not null references account(account_id)
    created timestamp with time zone not null default now(),
    visible boolean not null default true,
    comment text not null
 );



    Goals:

        Q1: See all my posts
        Q2: How many posts have I made
        Q3: See all current posts for a thread
        Q4: How many posts have I made to a Thread
        Q5: See all current posts for a Thread for this month, in order.






        create table words(word text);
        \copy words (word) from '/usr/share/dict/words';


        insert into account (name ,dob)
        select
            substring('AEIOU', ( random() * 4)::int + 1, 1) ||
            substring('ctdrdwftmkndnfnjnknsntnyprpsrdrgrkrmrnrzslstwl', (random() * 22  * 2 + 1)::int, 2) ||
            substring('AEIOU', ( random() * 4)::int + 1, 1) ||
            substring('ctdrdwftmkndnfnjnknsntnyprpsrdrgrkrmrnrzslstwl', (random() * 22  * 2 + 1)::int, 2) ||
            substring('AEIOU', ( random() * 4)::int + 1, 1),
            now() + ('1 days'::interval * random() * 365)
        from generate_series(1, 1000) ;

asddad

        insert into thread (account_id, title)
        select random() * 99 + 1,
                (
                    select initcap(string_agg(word, ' '))
                    from (table words order by random() * n limit 5) as words (word)
                )
        from generate_series(1, 1000) AS s(n);

        insert into post (thread_id, account_id, created, visible, comment)
        select
            random() * 999 + 1,
            random() * 99 + 1,
            now() - ('1 days'::interval * random() * 1000),
            case when random() > 1.0 then rule else false end,
            (
                select string_agg(word, ' ') from (table words  order by random() * n limit 20) as words (word)
            )
        from generate_series(1, 1000000) as s(n);





 **/