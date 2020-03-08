from django.contrib.auth.models import AbstractBaseUser, BaseUserManager, PermissionsMixin
from django.db import models
from django.utils import timezone

# Create your managers here
class UserManager(BaseUserManager):
    def create_user(self, email, banner_id, password, **kwargs):
        if not email:
            raise ValueError("ENTER AN EMAIL")
        if not banner_id:
            raise ValueError("NO BANNER ID")
        if not password:
            raise ValueError("NO PASSWORD GIVEN")
        
        user = self.model(
             email = self.normalize_email(email),
             banner_id = banner_id, **kwargs)
        user.set_password(password)
        user.save(using = self._db)
        return user
		
    def create_superuser(self, email, banner_id, password):
        user = self.create_user(email, banner_id, password)
        user.is_staff = True
        user.is_superuser = True
        user.save(using = self._db)
        return user
		
# Create your models here.
class User(AbstractBaseUser, PermissionsMixin):
	email = models.EmailField(unique=True)
	banner_id = models.CharField(max_length=25, unique=True)
	first_name = models.CharField(max_length=100)
	last_name = models.CharField(max_length=140)
	date_of_birth = models.DateField(null=True,blank=True)
	date_joined = models.DateTimeField(default=timezone.now)
	is_active = models.BooleanField(default=True)
	is_staff = models.BooleanField(default=False)
	objects = UserManager()
	USERNAME_FIELD = "email"
	REQUIRED_FIELDS = ["banner_id"]
	
	# for readability
	def __str__(self):
		return "{}".format(self.email)

	def get_short_name(self):
		return self.first_name
	
	def get_long_name(self):
		return "{} {}".format(self.first_name, self.last_name)
		
class Order(models.Model):
	email = models.EmailField()
	banner_id = models.CharField(max_length=100)
	outlet_name = models.CharField(max_length=100)
	order_details = models.TextField(null=False)
	order_datetime = models.DateTimeField(default=timezone.now)
	picked_up = models.BooleanField(default=False)
	picked_up_time = models.DateTimeField(null=True,blank=True)
	
	# for readability
	def __str__(self):
		return "{}".format(self.id)
		
	def save(self, *args, **kwargs):
		if self.picked_up:
			self.picked_up_time = timezone.now()
		super(Order, self).save(*args, **kwargs)