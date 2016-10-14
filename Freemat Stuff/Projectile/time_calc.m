function t=time_calc(g,v,alpha,yi)
    b = v*sin(pi*(alpha/180));
    a = -g/2
    c=yi
    
    t = (-b-sqrt(b*b-4*a*c))/(2*a)