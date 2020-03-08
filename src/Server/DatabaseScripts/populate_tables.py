import mysql.connector as mysql
import json
from mysql_queries import *
from database_metadata import *
from database_information import *
from print_logs import *

FRANCHISE_INFO_FILE = "franchise_information.json"
OUTLETS_INFO_FILE = "outlets_info.json"


def populate_franchise_table(db, cursor):
	with open(FRANCHISE_INFO_FILE, 'r') as f:
		data = json.load(f)
	f.close()
	result = []
	values = []
	for franchise in data:
		values.append(str(franchise['franchise_id']))
		values.append(str(franchise['franchise_name']))
		values.append(int(franchise['number_of_outlets']))
		values.append(str(franchise['description']))
		try:
			cursor.execute(insert_into_franchise_table_query, values)
			response = str(franchise['franchise_name']) + " added to franchise table"
			response = generate_info_log(response)
			db.commit()		
		except mysql.Error as e:
			response = generate_error_log(e.errno, e.msg)
		result.append(response)
		values = []
	return result


def populate_outlets_table(db, cursor):
	with open(OUTLETS_INFO_FILE,'r') as f:
		data = json.load(f)
		f.close()
		values = []
		result = []
		for outlet in data:
			values.append(int(outlet['outlet_id']))
			values.append(str(outlet['franchise_id']))
			values.append(str(outlet['location']))
			values.append(str(outlet['timings']))
			values.append(str(outlet['out_of_stock']))
			values.append(str(outlet['avg_wait_time']))
			values.append(float(outlet['avg_rating']))
			try:
				cursor.execute(insert_into_outlets_table_query, values)
				db.commit()
				response = generate_info_log("Outlet #" + str(outlet['outlet_id']) + " added to outlets table")
			except mysql.Error as e:
				response = generate_error_log(e.errno, e.msg)
			result.append(response)
			values = []
		return result


def populate_dependent_tables(db,cursor):
	print_log(generate_info_log("-----POPULATING FRANCHISE AND OUTLETS TABLES-----"))
	
	response = populate_franchise_table(db, cursor)
	for msg in response:
		print_log(msg)

	response = populate_outlets_table(db, cursor)
	for msg in response:
		print_log(msg)
		try:
			db = mysql.connect(
				host=DB_HOST,
				user=DB_USER,
				passwd=DB_PASSWORD,
				db=DB_NAME)
			cursor = db.cursor()
			response = generate_info_log('Connected to database successfully')
		except mysql.Error as e:
			response = generate_error_log(e.errno, e.msg)
		print_log(response)
