from django.shortcuts import render
from django.views import View
import json, datetime
from .models import User, Order
from django.utils.decorators import method_decorator
from django.views.decorators.csrf import csrf_exempt
from django.http import HttpResponse
from django.contrib.auth import login,logout,authenticate,update_session_auth_hash
import time
import smtplib, getpass
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email.mime.text import MIMEText
from email.utils import COMMASPACE, formatdate
from email import encoders
import string, secrets, ast


# Create your views here.
class RegisterView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(RegisterView, self).dispatch(request, *args, **kwargs)

	def post(self, request, **kwargs):
		try:
			unicode_body = request.body.decode('utf-8')
			body = json.loads(unicode_body)
			email = body.get('email','')
			password = body.get('password','')
			banner_id = body.get('banner_id','')
			first_name = body.get('first_name','')
			last_name = body.get('last_name','')
			try:
				date_of_birth = datetime.datetime.strptime(body.get('date_of_birth',None),"%Y-%m-%d")
			except:
				date_of_birth = None
			user = User.objects.create_user(email, banner_id, password)
			user.first_name = first_name
			user.last_name = last_name
			user.date_of_birth = date_of_birth
			user.save()
			return HttpResponse("200 SUCCESS")
		except Exception as e:
			return HttpResponse("400 FAILURE")
			
class LoginView(View):
	
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(LoginView, self).dispatch(request, *args, **kwargs)
	
	def post(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		body = json.loads(unicode_body)
		email = body.get('email','')
		password = body.get('password','')
		user = authenticate(email=email, password=password)
		if user is not None:
			if user.is_active:
				login(request, user)
				return HttpResponse("200 SUCCESS")
		else:
			return HttpResponse("401 FAILURE")
			
class GetUserView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(GetUserView, self).dispatch(request, *args, **kwargs)
	
	def get(self, request, *args, **kwargs):
		return HttpResponse(request.user.email)
		
class PlaceOrderView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(PlaceOrderView, self).dispatch(request, *args, **kwargs)
	
	def post(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		body = json.loads(unicode_body)
		banner_id = body.get('banner_id','')
		email = User.objects.get(banner_id=banner_id).email
		outlet_name = body.get('outlet_name','')
		order_details = str(body.get('order_details',''))
		order = Order()
		#order.save() - this save would have been done if it involved adding foreign keys and many to many field - check docs for future reference 
		order.banner_id = banner_id
		order.email = email
		order.outlet_name = outlet_name
		order.order_details = order_details
		order.save()
		time.sleep(3)
		return HttpResponse("200 SUCCESS")	
		
class ChangePasswordView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(ChangePasswordView, self).dispatch(request, *args, **kwargs)
		
	def post(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		body = json.loads(unicode_body)
		user = User.objects.get(email=request.user.email)
		old_password = body.get('old_password','')
		new_password = body.get('new_password','')
		if user.check_password(old_password):
			user.set_password(new_password)
			user.save()
			update_session_auth_hash(request, user)
			return HttpResponse("200 SUCCESS")
		else:
			return HttpResponse("401 FAILURE")
			
class ResetPasswordView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(ResetPasswordView, self).dispatch(request, *args, **kwargs)

	def post(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		body = json.loads(unicode_body)
		email = body.get("email","")
		alphabet = string.ascii_letters + string.digits
		password = '#' + ''.join(secrets.choice(alphabet) for i in range(8))
		user = User.objects.get(email=email)
		user.set_password(password)
		user.save()
		### update session hash may be needed - RAJESH to check later ###
		self.send_mail("foodatdalteam@gmail.com",email,"Password reset for your FoodAtDal account","Your request to change password has been processed.\nThis is your new password: {}".format(password),server="smtp.gmail.com",username="foodatdalteam@gmail.com",password="foodatdal")
		return HttpResponse("200 SUCCESS")
			
	def send_mail(self, send_from, send_to, subject, body_of_msg, files=[],
              server="localhost", port=587, username='', password='',
              use_tls=True):
		"""Compose and send email with provided info and attachments.

		Args:
		send_from (str): from name
		send_to (str): to name
		subject (str): message title
		message (str): message body
		files (list[str]): list of file paths to be attached to email
		server (str): mail server host name
		port (int): port number
		username (str): server auth username
		password (str): server auth password
		use_tls (bool): use TLS mode
		"""
		message = MIMEMultipart()
		message['From'] = send_from
		message['To'] = send_to
		message['Date'] = formatdate(localtime=True)
		message['Subject'] = subject
		message.attach(MIMEText(body_of_msg))
		smtp = smtplib.SMTP(server, port)
		if use_tls:
			smtp.starttls()
		smtp.login(username, password)
		smtp.sendmail(send_from, send_to, message.as_string())
		smtp.quit()

class GetUserDetailsView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(GetUserDetailsView, self).dispatch(request, *args, **kwargs)
		
	def get(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		user_details = {}
		try:
			user = User.objects.get(email=request.user.email)
			user_details["email"] = user.email
			user_details["banner_id"] = user.banner_id
			user_details["first_name"] = user.first_name
			user_details["last_name"] = user.last_name
			try:
				user_details["date_of_birth"] = user.date_of_birth.strftime("%Y-%m-%d")
			except:
				user_details["date_of_birth"] = "null"
			user_details["response_code"] = "200"
		except:
			user_details = {}
			user_details["response_code"] = "404S"
		return HttpResponse(str(user_details))
		
class PopulateOrdersView(View):
	@method_decorator(csrf_exempt)
	def dispatch(self, request, *args, **kwargs):
		return super(PopulateOrdersView, self).dispatch(request, *args, **kwargs)

	def post(self, request, **kwargs):
		unicode_body = request.body.decode('utf-8')
		body = json.loads(unicode_body)
		email = body.get("email","")
		all_orders = {}
		all_orders['current_orders'] = []
		all_orders['previous_orders'] = []
		orders = Order.objects.filter(email=email)
		for order in orders:
			order_info = {}
			order_info['outlet_name'] = order.outlet_name
			order_info['order_details'] = ast.literal_eval(order.order_details)
			order_info['order_datetime'] = order.order_datetime.strftime("%Y-%m-%d %H:%M:%S")
			order_info['picked_up'] = order.picked_up
			if order_info['picked_up']:
				order_info['picked_up_time'] = order.picked_up_time.strftime("%Y-%m-%d %H:%M:%S")
				all_orders['current_orders'].append(order_info)
			else:
				all_orders['previous_orders'].append(order_info)
		return HttpResponse(str(all_orders))
		