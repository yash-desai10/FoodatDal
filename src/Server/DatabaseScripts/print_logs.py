from datetime import datetime

TIMESTAMP_LOG = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
ERROR_LOG = ' ERROR:'
INFO_LOG = ' INFO: '


def generate_error_log(error_code, error_msg):
	error_log = TIMESTAMP_LOG + ERROR_LOG + str(error_code) + ' - ' + str(error_msg)
	return error_log


def generate_info_log(info):
	info_log = TIMESTAMP_LOG + INFO_LOG + str(info)
	return info_log


def print_log(msg):
	print(msg)
