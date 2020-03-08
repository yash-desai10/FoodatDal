from django.contrib import admin
from FoodAtDalWebApp.models import User, Order
from django.contrib.auth import get_user_model
from django.contrib.auth.admin import UserAdmin
from django.contrib.auth.forms import UserCreationForm, UserChangeForm

class MyUserChangeForm(UserChangeForm):
	class Meta:
		model = get_user_model()
		fields = ('email', 'banner_id', 'first_name', 'last_name', 'is_active', 'date_joined', 'date_of_birth', 'is_staff', 'is_superuser')

		
class MyUserCreationForm(UserCreationForm):
	class Meta:
		model = get_user_model()
		fields = ('email', 'banner_id', 'first_name', 'last_name', 'is_active', 'date_joined', 'date_of_birth', 'is_staff', 'is_superuser')

class MyUserAdmin(UserAdmin):
	form = MyUserChangeForm
	add_form = MyUserCreationForm
	fieldsets = (
	(None, {'fields': ('email', 'banner_id', 'first_name', 'last_name', 'is_active', 'date_joined', 'date_of_birth', 'is_staff', 'is_superuser')}),
	)
	add_fieldsets = (
        (None, {
            'classes': ('wide',),
            'fields': ('email', 'password1', 'password2','banner_id', 'first_name', 'last_name', 'is_active', 'date_joined', 'date_of_birth', 'is_staff', 'is_superuser'),
        }),
    )
	list_display = ('email', 'banner_id', 'first_name', 'last_name', 'is_active', 'date_joined', 'date_of_birth', 'is_staff', 'is_superuser')
	ordering = ('email',)
	
admin.site.register(User, MyUserAdmin)
admin.site.register(Order)
