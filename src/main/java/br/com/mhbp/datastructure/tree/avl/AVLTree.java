package br.com.mhbp.datastructure.tree.avl;

public class AVLTree {

    Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) node.left = insert(node.left, data);
        else node.right = insert(node.right, data);

        if (node.right == null & node.left == null) {
            node.height = 1;
        } else if (node.right != null & node.left != null) {
            node.height = Math.min(node.right.height, node.left.height) + 1;
        } else if (node.right != null) {
            node.height = node.right.height + 1;
        } else {
            node.height = node.left.height + 1;
        }
        node = setViolation(data, node);
        return node;
    }

    private Node setViolation(int data, Node node) {
        int balance = getBalance(node);

        //heavy left subtree, single left rotation => doubly-left heavy
        if (balance > 1 && data < node.left.data) {
            return rightRotation(node);
        }

        //heavy right situation
        if (balance < -1 && data > node.right.data) {
            return leftRotation(node);
        }

        //heavy left right
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }

        //heavy right left
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }
        return node;
    }

    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    public void traverse() {

        if (root == null) return;

        inOrderTraverse(root);
    }

    public int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int balance(Node n) {
        if (n == null) return 0;

        return Math.abs(balance(n.left) - balance(n.right));
    }

    private void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(node.data + " ");
            inOrderTraverse(node.right);
        }
    }

    private Node rightRotation(Node node) {
        System.out.println("Rotating to right node: " + node);
        Node tmpLeftNode = node.left;
        Node t = tmpLeftNode.right;
        tmpLeftNode.right = node;
        node.left = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        tmpLeftNode.height = Math.max(height(tmpLeftNode.left), height(tmpLeftNode.right)) + 1;
        return tmpLeftNode;
    }

    private Node leftRotation(Node node) {
        System.out.println("Rotating to left on node " + node);
        Node tmpRightNode = node.right;
        Node t = tmpRightNode.left;
        tmpRightNode.left = node;
        node.right = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        tmpRightNode.height = Math.max(height(tmpRightNode.left), height(tmpRightNode.right)) + 1;
        return tmpRightNode;
    }

    public Node remove(int nodeValue) {
        return remove(root, nodeValue);
    }

    private Node remove(Node node, int nodeValue) {
        if(node == null) return node;

        if (nodeValue > node.data)
            return remove(node.right, nodeValue);
        else if (nodeValue < node.data)
            return remove(node.left, nodeValue);
        else { //we found the node we wanna remove it

            if(node.left == null && node.right == null) {
                node = null; //???
                return null;
            }

            if (node.left == null) {
                Node tmpRight = node.right;
                node = null;
                return tmpRight;
            }

            if (node.right == null) {
                Node tmpLeft = node.left;
                node = null;
                return tmpLeft;
            }

            //removing node with two children

            Node predecessor = getPredecessor(node.left);
            node.data = predecessor.data;
            node.left = remove(node.left, predecessor.data);


            node.height = Math.max(node.left.height, node.right.height) + 1;
            return node;
        }
    }

    private Node getPredecessor(Node left) {
        return null;
    }
    /*
    when removing a node we have three possible cases
        1- The node we wanna get rid of is a leaf node
        2- The node we wanna get rid of has a single child
        3- The node we wanna get rid of has two children
     */
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