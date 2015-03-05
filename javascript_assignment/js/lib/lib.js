var line_attr=
{
	paserLine: function(a,b,c,range_start,range_end,step)
	{
	  this.a=a;
	  this.b=b;
	  this.c=c;	
	  this.x_min_value=range_start;
	  this.x_max_value=range_end;
	  this.step=step;
	}
};

function parser(eq)
  {
    
    alert(eq);
    var pattern=new RegExp("[0-9]+x[+|-][0-9]+y[+|-][0-9]+=0");
    var user_line=Object.create(line_attr);


    if(eq=="" || !(pattern.test(eq)))
    {   
       alert("Enter correct equation");   
    }
    else
    {
  
      var x_index=eq.indexOf("x");
      var a=eq.substring(0,x_index);
      user_line.a=a;
      
      var y_index=eq.indexOf("y");
      var b=eq.substring(x_index+2,y_index);
      user_line.b=b;

      var e_index=eq.indexOf("=");
      var c=eq.substring(y_index+2,e_index);
      user_line.c=c;                  
    } 
    
    return user_line; 
    
  }

function draw(passed_equation,canvas)
{    
     
     
     var x_value=0;
     var y_value=0;
     var context = canvas.getContext('2d');
     context.beginPath();
     context.moveTo(200,200);
        
for(x_value=passed_equation.x_min_value;x_value<passed_equation.x_max_value;x_value=x_value+passed_equation.step)
      {    
       alert(passed_equation.a); 
       y_value=parseInt(((-passed_equation.c-(passed_equation.a*x_value))/passed_equation.b));
        alert(y_value);
	console.log(x_value, y_value);
       context.lineTo(x_value,y_value);
       context.stroke();    
     
      }

}
