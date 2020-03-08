from pprint import pprint
import mysql.connector as mysql
from datetime import datetime
from database_metadata import *
from mysql_queries import *
from database_information import *
from print_logs import *
from populate_tables import *


def close_db_connection(cursor):
	try:
		cursor.close()
		response = generate_info_log('Database connection closed.')
	except mysql.Error as e:
		response = generate_error_log(e.errno, e.msg)
	return response


def create_table(cursor, table_name, table_fields, table_types_and_keys):
	query = create_table_query + table_name + '('
	for (name,param) in zip(table_fields,table_types_and_keys):
		query += name
		query += param
	query += ')' + query_terminator
	try:
		cursor.execute(query)
		response = generate_info_log(table_name + " table created")
	except mysql.Error as e:
		response = generate_error_log(e.errno, e.msg)
	return response


def query_all_franchises(cursor, field_name, table_name):
	query = "SELECT franchise_name FROM franchise;"
	franchises = []
	try:
		cursor.execute(query)
		response = cursor.fetchall()
		print_log(generate_info_log("Fetching existing franchise names to create menu tables"))
	except mysql.Error as e:
		print_log(generate_error_log(e.errno, e.msg))
	for val in response:
		franchises.append(str(val[0]))
	return franchises


def main():
	try:
		db = mysql.connect(
			host=DB_HOST,
			user=DB_USER,
			passwd=DB_PASSWORD,
			db=DB_NAME
			)
		cursor = db.cursor()
		response = generate_info_log('Connected to database successfully')
	except mysql.Error as e:
		response = generate_error_log(e.errno, e.msg)
	print_log(response)
	
	#create customer table
	response = create_table(cursor, customer_table_name, customer_table_fields, customer_table_types_and_keys)
	print_log(response)

	#create franchise table
	response = create_table(cursor, franchise_table_name, franchise_table_fields, franchise_table_types_and_keys)
	print_log(response)

	#create orders table
	response = create_table(cursor, orders_table_name, orders_table_fields, orders_table_types_and_keys)
	print_log(response)

	#create outlets table
	response = create_table(cursor, outlets_table_name, outlets_table_fields, outlets_table_types_and_keys)
	print_log(response)

	populate_dependent_tables(db,cursor)

	franchises_list = query_all_franchises(cursor, "franchise_name", "franchise")
	if (len(franchises_list) == 0):
		print_log(generate_info_log("Cannot create tables for menus as franchise table has no records. Terminating the program."))
		print_log(generate_info_log("----- End of script -----"))
	else:
		for franchise in franchises_list:
			table_name = franchise.replace(" ","_") + "_menu"
			response = create_table(cursor, table_name, menu_table_fields, menu_table_types_and_keys)
			print_log(response)


if __name__ == "__main__":
	main()
