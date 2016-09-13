clc;
clear all;
%Projectile
g = 9.81;
xi = 0;
yi = 10;
alpha = 45;
v = 20;

t = time_calc(g,v,alpha,yi);
disp(t);

function t=time_calc(g,v,alpha,yi)
    b = v*sin(pi*(alpha/180));
    a = -g/2
    c=yi
    
    t = (-b-sqrt(b*b-4*a*c))/(2*a)

