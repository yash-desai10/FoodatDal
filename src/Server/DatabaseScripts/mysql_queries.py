show_db_query = "SHOW DATABASES"

create_table_query = "CREATE TABLE "

insert_into_franchise_table_query = "INSERT INTO franchise(franchise_id, franchise_name, number_of_outlets, description) VALUES(%s,%s,%s,%s)"

insert_into_outlets_table_query = "INSERT INTO outlets(outlet_id, franchise_id, location, timings, out_of_stock, avg_wait_time, avg_rating) VALUES (%s,%s,%s,%s,%s,%s,%s)"

query_single_field_query = "SELECT franchise_name FROM %s"

query_terminator = ";"
