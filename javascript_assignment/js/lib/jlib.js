 


function draw(user)
{

  
  if(x_max_value == "" ||step == "")
   {
     alert("Enter the valid range or step");
   }
  else
   {
     var x_value=0;
     var y_value=0;
     var canvas = document.getElementById("canvas_id");
     var context = canvas.getContext('2d');
     context.beginPath();
     context.translate(120,120);
     for(x_value=x_min_value;x_value<x_max_value;x_value=x_value+step)
      {     
       y_value=parseInt(((-c-(a*x_value))/b));
       context.lineTo(x_value,y_value);
       context.stroke();    
     
      }
    }

  
}



function parser(eq)
  {
    
    alert(eq);
    var pattern=new RegExp("[0-9]+x[+|-][0-9]+y[+|-][0-9]+=0");
    if(eq=="" || !(pattern.test(eq)))
    {   
       alert("Enter correct equation");   
    }
    else
    {
  
      var x_index=eq.indexOf("x");
      var a=eq.substring(0,x_index);
      
      var y_index=eq.indexOf("y");
      var b=eq.substring(x_index+2,y_index);
      document.getElementById("b_id").value=b;
      var e_index=eq.indexOf("=");
      var c=eq.substring(y_index+2,e_index);
      document.getElementById("c_id").value=c;                    
    }   
  }
