

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
option{
	font-size:10px
 }
</style>
    
    <script type='text/javascript'>
	document.oncontextmenu = function(){return false}
</script>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Registrase</title>
    </head>
    <%
        String r = "";
        if(request.getParameter("Vemail")!=null){
             r = "Este correo ya esta registrado";
        }
        if(request.getParameter("Vpass")!=null){
             r = "Las contraseñas no concuerdan";
        }
    %>
    <p align="center"><b><font size="5">

<body>
<div class="container mt-25 col-lg-5">

<center>
<form name="globe" action="Registrarse"  method="POST">
 
<!-- Script Size:  6.08 KB  -->
<div class="form-group text-center">
                            <h5>REGISTRARSE</h5>
                            <h4 class="text-danger"><%=r%></h4>
                        </div>
                        <div class="form-group" size="1">
                            <H6>  <label><b>Correo</b></label> </H6>
                            <input type="email" name="txtemail" class="form-control" placeholder="Favor digita email" required/>
                        </div>
                        <div class="form-group">
                           <H6> <label><b>Contraseña</b></label></H6>
                            <input type="password" name="txtpass" class="form-control" placeholder="Favor digita contraseña" required/>
                        </div>
                        <div class="form-group">
                           <H6> <label><b>Confirmar Contraseña</b></label></H6>
                            <input type="password" name="txtpassConfir" class="form-control" placeholder="Favor confirmar contraseña" required/>
                            
                        </div>
                        
                        <div class="form-group">
                           <H6> <label><b>Cod_Materia</b></label>
                    <input type="txtCod_Materia" name="txtCod_Materia" class="form-control" placeholder="Cod_Materia" required/>
                  </div>
                    
                    <div class="form-group">
                       <H6> <label><b>Materia</b></label>
                    <input type="Materia" name="txtMateria" class="form-control"
                           placeholder="Materia" required />
                  </div>
                     
                     
                    
</center>
               
                                       
   
                        <br>
                         <br>   
              
              
              
                         <button  type="submit" name="accion" value="Registrarse" class="btn btn-success btn-block">Registrarse <img src="data:image/jpeg;base64,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"alt="Guardar" width="30" height="30"> 
  
 
                   
</form>
</body>

 </html>
