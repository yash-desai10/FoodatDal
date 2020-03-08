# Meta data for the customer table 
customer_table_name = 'customer'
customer_table_fields = ('banner_id', 'first_name', 'last_name', 'email_id', 'password', 'date_of_birth', 'last_order')
customer_table_types_and_keys = (' varchar(15) PRIMARY KEY, ', ' varchar(40) NOT NULL, ', ' varchar(40) NOT NULL, ', ' varchar(255) DEFAULT NULL, ', ' varchar(255) DEFAULT NULL, ', ' date NOT NULL, ', ' date DEFAULT NULL')

# Meta data for the franchise table
franchise_table_name = 'franchise'
franchise_table_fields = ('franchise_id', 'franchise_name', 'number_of_outlets', 'description')
franchise_table_types_and_keys = (' varchar(6) PRIMARY KEY, ', ' varchar(255) NOT NULL, ', ' int NOT NULL DEFAULT 0, ', ' TEXT DEFAULT NULL')

# Meta data for outlets table
outlets_table_name = 'outlets'
outlets_table_fields = ('outlet_id', 'franchise_id' , 'location', 'timings', 'out_of_stock', 'avg_wait_time', 'avg_rating')
outlets_table_types_and_keys = (' int PRIMARY KEY, ', ' varchar(6), ', ' varchar(255) NOT NULL, ', ' TEXT , ', ' TEXT DEFAULT NULL, ', ' varchar(30), ', ' decimal DEFAULT NULL')

# Meta data for the orders table
orders_table_name = 'orders'
orders_table_fields = ('order_id', 'banner_id', 'outlet_id', 'order_details', 'order_token', 'order_date', 'order_time', 'order_prepared_time', 'order_pickup_time', 'item_id')
orders_table_types_and_keys = (' int PRIMARY KEY, ', ' varchar(15), ', ' int, ', ' TEXT NOT NULL, ', ' int NOT NULL, ', ' date NOT NULL, ', ' time NOT NULL, ', ' time NOT NULL, ', ' time NOT NULL', ' varchar(10),')

# Meta data for menu tables
menu_table_fields = ('item_id', 'item_name', 'item_image', 'item_price', 'outlet_id')
menu_table_types_and_keys = (' varchar(10) PRIMARY KEY, ', ' varchar(255) NOT NULL, ', ' varchar(255), ', ' decimal NOT NULL', ' int,')