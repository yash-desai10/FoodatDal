"""FoodAtDalServer URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.conf.urls import url
from FoodAtDalWebApp import views as fv

urlpatterns = [
    path('admin/', admin.site.urls),
	url(r'^login/$', fv.LoginView.as_view()),
	url(r'^register/$', fv.RegisterView.as_view()),
	url(r'^getuser/$', fv.GetUserView.as_view()),
	url(r'^placeorder/$',fv.PlaceOrderView.as_view()),
	url(r'^changepassword/$',fv.ChangePasswordView.as_view()),
	url(r'^resetpassword/$',fv.ResetPasswordView.as_view()),
	url(r'^getuserdetails/$',fv.GetUserDetailsView.as_view()),
	url(r'^populateorders/$',fv.PopulateOrdersView.as_view()),
]
